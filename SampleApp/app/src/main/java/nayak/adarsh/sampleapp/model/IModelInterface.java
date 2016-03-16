package nayak.adarsh.sampleapp.model;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		IModelInterface
 * @Project:
 *		 SampleApp	
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.util.List;

/*! Revision history (Most recent first)
 Created by adarsha on 15/3/16
 */
public interface IModelInterface {
    public List<Story> getStory();
    public String getName();
    public String getPhoto();
    public String getPhone();
    public String getEmail();
    public String getContactUrl();
}
