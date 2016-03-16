package nayak.adarsh.sampleapp.ui.adapter;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		CheckinCardViewHolder
 * @Project:
 *		 SampleApp	
 *
 * @Abstract PhotoViewHolder just display friend's photo
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nayak.adarsh.sampleapp.R;

/*! Revision history (Most recent first)
 Created by adarsha on 16/3/16
 */
public class CheckinCardViewHolder extends RecyclerView.ViewHolder {

    private ImageView mLocationIv;
    private ImageView mImageView;
    private TextView mLocationTv;
    private TextView mMoreImageTv;

    public CheckinCardViewHolder(View itemView) {
        super(itemView);
        mLocationIv = (ImageView) itemView.findViewById(R.id.location_iv);
        mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        mLocationTv = (TextView) itemView.findViewById(R.id.location_textview);
        mMoreImageTv = (TextView) itemView.findViewById(R.id.more_image_textView);
    }

    public ImageView getLocationIv() {
        return mLocationIv;
    }

    public void setLocationIv(ImageView locationIv) {
        this.mLocationIv = locationIv;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        this.mImageView = imageView;
    }

    public TextView getLocationTv() {
        return mLocationTv;
    }

    public void setLocationTv(TextView locationTv) {
        this.mLocationTv = locationTv;
    }

    public TextView getMoreImageTv() {
        return mMoreImageTv;
    }

    public void setMoreImageTv(TextView moreImageTv) {
        this.mMoreImageTv = moreImageTv;
    }
}
