package nayak.adarsh.sampleapp.ui.adapter;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		RecyclerAdapter
 * @Project:
 *		 DemoApplication	
 *
 * @Abstract FriendsDetailAdapter binds data to recyler view from model
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import nayak.adarsh.sampleapp.R;
import nayak.adarsh.sampleapp.model.IModelInterface;
import nayak.adarsh.sampleapp.model.Story;
import nayak.adarsh.sampleapp.utils.SampleUtil;

/*! Revision history (Most recent first)
 Created by adarsha on 10/3/16
 */
public class FriendsDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final int ITEM_PHOTO = 0;
    public final int ITEM_SIMPLE_CARD = 1;
    public final int ITEM_CHECKIN_CARD = 2;

    public static final String IMAGE_URL = "http://developer.android.com/images/training/system-ui.png";

    private List<Story> mStoryList;
    private Context mContext = null;
    private String mPhotoUrl = null;

    public FriendsDetailAdapter(Context context, IModelInterface friendsModel) {
        mStoryList = friendsModel.getStory();
        mPhotoUrl = friendsModel.getPhoto();
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // create a new view
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case ITEM_PHOTO:
                View photoViewLayout = inflater.inflate(R.layout.photo_layout, viewGroup, false);
                viewHolder = new PhotoViewHolder(photoViewLayout);
                break;
            case ITEM_SIMPLE_CARD:
                View simpleCardLayout = inflater.inflate(R.layout.simple_card_layout, viewGroup, false);
                viewHolder = new SimpleCardViewHolder(simpleCardLayout);
                break;
            case ITEM_CHECKIN_CARD:
                View checkinCardLayout = inflater.inflate(R.layout.checkin_card_layout, viewGroup, false);
                viewHolder = new CheckinCardViewHolder(checkinCardLayout);
                break;
            default:
                throw new RuntimeException("Invalid view type");
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case ITEM_PHOTO:
                configurePhotoViewHolder((PhotoViewHolder) viewHolder);
                break;
            case ITEM_SIMPLE_CARD:
                configureSimpleCardHolder((SimpleCardViewHolder) viewHolder, position - 1);
                break;
            case ITEM_CHECKIN_CARD:
                configureCheckinCardHolder((CheckinCardViewHolder) viewHolder, position - 1);
                break;
        }
    }

    /**
     *
     * @param checkinCardViewHolder view holder type
     * @param position model position in list
     *
     *  binds story model data for check in card type
     *
     */
    private void configureCheckinCardHolder(CheckinCardViewHolder checkinCardViewHolder, int position) {
        Story story = mStoryList.get(position);
        Picasso.with(mContext)
                .load(story.getImageUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(checkinCardViewHolder.getImageView());
        checkinCardViewHolder.getLocationIv().setTag(story.getLocationUrl());
        checkinCardViewHolder.getLocationIv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationUrl = (String) v.getTag();
                SampleUtil.launchTheUrl(mContext, locationUrl);
            }
        });
        checkinCardViewHolder.getLocationTv().setText(story.getTitle());
        String moreImageUrl = story.getMoreImages();
        if(moreImageUrl == null) {
            checkinCardViewHolder.getMoreImageTv().setVisibility(View.INVISIBLE);
        } else {
            checkinCardViewHolder.getMoreImageTv().setVisibility(View.VISIBLE);
        }
        checkinCardViewHolder.getMoreImageTv().setTag(moreImageUrl);
        checkinCardViewHolder.getMoreImageTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String moreImagesUrl = (String) v.getTag();
                SampleUtil.launchTheUrl(mContext, moreImagesUrl);
            }
        });
    }

    /**
     *
     * @param simpleCardViewHolder view holder type
     * @param position model position in list
     *
     *  binds story model data for simple card type
     *
     */
    private void configureSimpleCardHolder(SimpleCardViewHolder simpleCardViewHolder, int position) {
        Story story = mStoryList.get(position);
        simpleCardViewHolder.getAboutTextview().setText(story.getTitle());
        simpleCardViewHolder.getContentTextView().setText(story.getContent());
    }


    /**
     *
     * @param photoViewHolder view holder type     *
     *
     *  binds friends photo to photo view holder
     *
     */
    private void configurePhotoViewHolder(PhotoViewHolder photoViewHolder) {
        Picasso.with(mContext)
                .load(mPhotoUrl)
                .placeholder(R.drawable.placeholder_image)
                .into(photoViewHolder.getPhotoView());
    }

    @Override
    public int getItemCount() {
        return mStoryList == null? 1 : mStoryList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {

        //header item at position 0
        if(position == 0) {
            return ITEM_PHOTO;
        }

        Story storyModel = mStoryList.get(position - 1);
        String type = storyModel.getType();
        if(type.equals("simple_card")) {
            return ITEM_SIMPLE_CARD;
        } else if (type.equals("checkin_card")) {
            return ITEM_CHECKIN_CARD;
        }

        return -1;
    }
}