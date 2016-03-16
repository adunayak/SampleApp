package nayak.adarsh.sampleapp.ui.adapter;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		PhotoViewHolder
 * @Project:
 *		 SampleApp	
 *
 * @Abstract PhotoViewHolder just display friend's photo
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import nayak.adarsh.sampleapp.R;

/*! Revision history (Most recent first)
 Created by adarsha on 16/3/16
 */
public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private ImageView mPhotoView;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        mPhotoView = (ImageView) itemView.findViewById(R.id.photo_image_view);
    }

    public ImageView getPhotoView() {
        return mPhotoView;
    }

    public void setPhotoView(ImageView photoView) {
        this.mPhotoView = photoView;
    }

}
