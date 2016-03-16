package nayak.adarsh.sampleapp.model;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		Story
 * @Project:
 *		 SampleApp	
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/*! Revision history (Most recent first)
 Created by adarsha on 15/3/16
 */
public class Story {
    private String type;
    private String title;
    private String content;
    private String image_url;
    private String location_url;
    private String more_images;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getLocationUrl() {
        return location_url;
    }

    public void setLocationUrl(String locationUrl) {
        this.location_url = locationUrl;
    }

    public String getMoreImages() {
        return more_images;
    }

    public void setMoreImages(String moreImages) {
        this.more_images = moreImages;
    }
}
