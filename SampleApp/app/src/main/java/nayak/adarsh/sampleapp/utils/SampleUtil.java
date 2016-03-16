package nayak.adarsh.sampleapp.utils;
/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 *		SampleUtil
 * @Project:
 *		 SampleApp	
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/*! Revision history (Most recent first)
 Created by adarsha on 16/3/16
 */
public class SampleUtil {

    /**
     * Launch any url in browser or app which handles ACTION_VIEW
     */
    public static void launchTheUrl(Context context, String url) {
        if(url != null) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivityWithIntent(context, i, "Open URL...");
        }
    }

    /**
     * Try to catch the activity not found exception for the implicit intent
     */
    public static void startActivityWithIntent(Context context, Intent intent, String chooserMessage) {
        try {
            context.startActivity(Intent.createChooser(intent, chooserMessage));
        } catch (ActivityNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
