package com.example.sunnygurnani.multimenu;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sunnygurnani on 11/3/15.
 */
public class CommonHelper {

    public  static String getMobileId(Activity activity){
        SharedPreferences preferences =  activity.getPreferences(Context.MODE_PRIVATE);
        String mobileId = preferences.getString("MobileId", null);
        return mobileId;
    }

    public static void setMobileId(Activity activity, String id){
        SharedPreferences preferences =  activity.getPreferences(Context.MODE_PRIVATE);


            SharedPreferences.Editor editor = preferences.edit();


            editor.putString("MobileId", id);
            editor.commit();


    }
}
