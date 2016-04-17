package easyvote.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

import easyvote.com.easyvote.HomeActivity;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();
 
    // Shared Preferences
    SharedPreferences pref;
 
    Editor editor;
    Context _context;
 
    // Shared pref mode
    int PRIVATE_MODE = 0;
 
    // Shared preferences file name
    private static final String PREF_NAME = "MedoBossPreferences";
     
    private static final String IS_LOGIN = "isLoggedIn";

    public static final String KEY_ID="id",KEY_USER_TYPE_ID="user_type_id",KEY_FIRST_NAME="first_name",
            KEY_LAST_NAME="last_name",KEY_EMAIL="email",KEY_USER_TYPE="user_type",KEY_ABOUT_ME="about_me",KEY_USERNAME="username";
 
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String id, String userTypeId,String firstName,String lastName,String email,String userType,
                                   String aboutMe,String username, String newFriendRequests, String newConnectionRequests, String chat,
                                   String activeCircuit,String dailyStatHistory, String profileImage, String normalImage,
                                   String profileImageURLThumb, String profilePicPath, String profilePicImageName, String profileImageURL){

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_ID, id);
        editor.putString(KEY_USER_TYPE_ID, userTypeId);
        editor.putString(KEY_FIRST_NAME, firstName);
        editor.putString(KEY_LAST_NAME, lastName);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_USER_TYPE, userType);
        editor.putString(KEY_ABOUT_ME, aboutMe);
        editor.putString(KEY_USERNAME, username);
        editor.putString("newFriendRequests", newFriendRequests);
        editor.putString("newConnectionRequests", newConnectionRequests);
        editor.putString("chat", chat);
        editor.putString("activeCircuit", activeCircuit);
        editor.putString("dailyStatHistory", dailyStatHistory);
        editor.putString("profileImage", profileImage);
        editor.putString("normalImage", normalImage);

        editor.putString("profileImageURLThumb", profileImageURLThumb);
        editor.putString("profileImageURL", profileImageURL);
        editor.putString("profilePicImageName", profilePicImageName);
        editor.putString("profilePicPath", profilePicPath);
        editor.putString("todaysDailyStat", "");



        // commit changes
        editor.commit();
    }
    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, HomeActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        // user name
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_USER_TYPE_ID, pref.getString(KEY_USER_TYPE_ID, null));
        user.put(KEY_FIRST_NAME, pref.getString(KEY_FIRST_NAME, null));
        user.put(KEY_LAST_NAME, pref.getString(KEY_LAST_NAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_USER_TYPE, pref.getString(KEY_USER_TYPE, null));
        user.put(KEY_ABOUT_ME, pref.getString(KEY_ABOUT_ME, null));
        user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
        user.put("newFriendRequests", pref.getString(KEY_USERNAME, null));
        user.put("newConnectionRequests", pref.getString("newConnectionRequests", null));
        user.put("chat", pref.getString("chat", null));
        user.put("activeCircuit", pref.getString("activeCircuit", null));
        user.put("dailyStatHistory", pref.getString("dailyStatHistory", null));
        user.put("profileImage", pref.getString("profileImage", null));
        user.put("normalImage", pref.getString("normalImage", null));
        user.put("profileImageURLThumb", pref.getString("profileImageURLThumb", null));
        user.put("profileImageURL", pref.getString("profileImageURL", null));
        user.put("profilePicImageName", pref.getString("profilePicImageName", null));
        user.put("profilePicPath", pref.getString("profilePicPath", null));
        user.put("todaysDailyStat", pref.getString("todaysDailyStat", null));








        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

/*

        Ion.with(_context)
                .load("GET", AppConfig.MEDOBOSSURL+"/api/auth/signout")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        Toast.makeText(_context, "Logged Out", Toast.LENGTH_SHORT).show();

                    }
                });

*/

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, HomeActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getLoggedInUserType()
    {
        return pref.getString(KEY_USER_TYPE, null);
    }

    public String getUserName()
    {
        return pref.getString(KEY_USERNAME, null);
    }

    public String getEmail()
    {
        return pref.getString(KEY_EMAIL, null);
    }

    public String getUserId()
    {
        return pref.getString(KEY_ID, null);
    }

    public String getNewFriendRequests()
    {
        return pref.getString("newFriendRequests", null);
    }

    public String getNewConnectionRequests()
    {
        return pref.getString("newConnectionRequests", null);
    }

    public String getChatId()
    {
        return pref.getString("chat",null);
    }

    public String getDisplayName(){ return pref.getString(KEY_FIRST_NAME,null);}

    public String getUserTypeId(){ return pref.getString(KEY_USER_TYPE_ID,null);}

    public String getActiveCircuit(){ return pref.getString("activeCircuit",null);}

    public String getDailyHistoryId(){ return pref.getString("dailyStatHistory",null);}

    public String getProfileAlbumId(){ return pref.getString("profileImage",null);}

    public String getNormalAlbumId(){ return pref.getString("normalImage",null);}

    public String getProfileImageURLThumb(){ return pref.getString("profileImageURLThumb",null);}

    public String getProfileImagePath(){ return pref.getString("profilePicPath",null);}

    public String getNormalImage(){ return pref.getString("normalImage",null);}

    public String getProfileImageName(){ return pref.getString("profileImageName",null);}

    public String getDailyStatHistory(){ return pref.getString("dailyStatHistory",null);}

    public String getTodaysDailyStat(){ return pref.getString("todaysDailyStat",null);}



    public void setActiveCircuit(String activeCircuit){
        editor.putString("activeCircuit", activeCircuit);
        editor.commit();
    }


    public void setProfileImagePath(String profileImageURL){
        editor.putString("profilePicPath", profileImageURL);
        editor.commit();
    }

    public void setProfileImageName(String profileImageName){
        editor.putString("profileImageName", profileImageName);
        editor.commit();
    }

    public void setTodaysDailyStatId(String todaysDailyStat){
        editor.putString("todaysDailyStat", todaysDailyStat);
        editor.commit();
    }
    /*public void setLogin(boolean isLoggedIn) {
 
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
 
        // commit changes
        editor.commit();
 
        Log.d(TAG, "User login session modified!");
    }*/
     
}