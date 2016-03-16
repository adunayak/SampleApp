package nayak.adarsh.sampleapp.model;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		FriendDetail
 * @Project:
 *		 SampleApp	
 *
 * @Abstract Friends detail model lists all the information related to friends
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.util.List;

/*! Revision history (Most recent first)
 Created by adarsha on 15/3/16
 */
public class FriendDetail implements IModelInterface {
    private String name;
    private String photo;
    private String phone;
    private String email;
    private String contact_url;
    private List<Story> our_story;

    @Override
    public String getName() {
        return name != null ? name : "NA";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getContactUrl() {
        return contact_url;
    }

    public void setContactUrl(String contactUrl) {
        this.contact_url = contactUrl;
    }

    public void setOurStory(List<Story> ourStory) {
        this.our_story = ourStory;
    }

    @Override
    public List<Story> getStory() {
        return our_story;
    }
}
