package nayak.adarsh.sampleapp.ui.adapter;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		SimpleCardViewHolder
 * @Project:
 *		 SampleApp
 *
 * @Abstract Simple card holder display the about and description detail of friend
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nayak.adarsh.sampleapp.R;

/*! Revision history (Most recent first)
 Created by adarsha on 16/3/16
 */
public class SimpleCardViewHolder extends RecyclerView.ViewHolder {

    private TextView mAboutTextview = null;
    private TextView mContentTextView = null;

    public SimpleCardViewHolder(View itemView) {
        super(itemView);
        mAboutTextview = (TextView) itemView.findViewById(R.id.about_textview);
        mContentTextView = (TextView) itemView.findViewById(R.id.content_textview);
    }

    public TextView getAboutTextview() {
        return mAboutTextview;
    }

    public void setAboutTextview(TextView aboutTextview) {
        this.mAboutTextview = aboutTextview;
    }

    public TextView getContentTextView() {
        return mContentTextView;
    }

    public void setContentTextView(TextView contentTextView) {
        this.mContentTextView = contentTextView;
    }
}
