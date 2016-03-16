package nayak.adarsh.sampleapp.ui;

/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		MainActivity
 * @Project:
 *		 DemoApplication
 *
 *@Abstract	Main activity is the main screen which displays the detail information of friend
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import nayak.adarsh.sampleapp.R;
import nayak.adarsh.sampleapp.model.FriendDetail;
import nayak.adarsh.sampleapp.model.IModelInterface;
import nayak.adarsh.sampleapp.ui.adapter.FriendsDetailAdapter;
import nayak.adarsh.sampleapp.utils.AssetManagerTask;
import nayak.adarsh.sampleapp.utils.IAssetReponseListener;
import nayak.adarsh.sampleapp.utils.SampleUtil;

public class MainActivity extends AppCompatActivity implements IAssetReponseListener, View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView = null;
    private ProgressBar mProgressBar = null;
    private IModelInterface mModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        fetchFeriendsDetail();
    }


    /**
     * To fetch the data from asset folder
     */
    private void fetchFeriendsDetail() {
        mProgressBar.setVisibility(View.VISIBLE);
        new AssetManagerTask(getApplicationContext(), "sample_response.json", FriendDetail.class, this).execute();
    }

    /**
     * Initialize all the views of main activity
     */
    private void initializeView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        findViewById(R.id.bottom_bar).setVisibility(View.INVISIBLE);
        findViewById(R.id.bottom_bar).findViewById(R.id.phone_image_view).setOnClickListener(this);
        findViewById(R.id.bottom_bar).findViewById(R.id.mail_image_view).setOnClickListener(this);
        findViewById(R.id.bottom_bar).findViewById(R.id.contact_image_view).setOnClickListener(this);
    }

    /**
     * Model will be sent to this ad=fter parsing json response
     */
    @Override
    public void onResponse(IModelInterface model) {
        mModel = model;
        updateView();
    }

    /**
     * update the view once model is available, show the recycler view with updated data
     */
    private void updateView() {
        mProgressBar.setVisibility(View.GONE);
        getSupportActionBar().setTitle(mModel.getName());
        FriendsDetailAdapter adapter = new FriendsDetailAdapter(this, mModel);
        mRecyclerView.setAdapter(adapter);
        findViewById(R.id.bottom_bar).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone_image_view:
                launchPhoneIntent();
                break;

            case R.id.mail_image_view:
                launchEmailIntent();
                break;

            case R.id.contact_image_view:
                if(mModel != null) {
                    SampleUtil.launchTheUrl(this, mModel.getContactUrl());
                }
                break;
        }
    }


    /**
     * Launch the phone intent to dial phone number
     */
    private void launchPhoneIntent() {
        if(mModel == null) return;
        String phone = mModel.getPhone();
        if(phone != null) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone));
            SampleUtil.startActivityWithIntent(this, intent, "Dial...");
        }
    }

    /**
     * Launch the email intent to send mail
     */
    private void launchEmailIntent() {
        if(mModel == null) return;
        String email = mModel.getEmail();
        if(email != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            SampleUtil.startActivityWithIntent(this, intent, "Send mail to...");
        }
    }
}
