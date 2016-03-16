package nayak.adarsh.sampleapp.utils;

/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		AssetManagerTask
 * @Project:
 *		 DemoApplication
 *
 *@Abstract	AsyncTask to load and parse the json response from asset file
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import nayak.adarsh.sampleapp.model.IModelInterface;

public class AssetManagerTask extends AsyncTask<Void, Void, IModelInterface> {

    private String mFileName = null;
    private Context mContext = null;
    private Class mModelClass = null;
    private IAssetReponseListener mListener = null;

    public AssetManagerTask(Context context, String fileName, Class modelClass, IAssetReponseListener listener) {
        mFileName = fileName;
        mContext = context;
        mModelClass = modelClass;
        mListener = listener;
    }

    @Override
    protected IModelInterface doInBackground(Void... params) {
        try {
            InputStream is = mContext.getAssets().open(mFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonString = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            IModelInterface model = (IModelInterface) gson.fromJson(jsonString, mModelClass);
            return model;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(IModelInterface model) {
        super.onPostExecute(model);
        if(mListener != null) {
            mListener.onResponse(model);
        }
    }

}