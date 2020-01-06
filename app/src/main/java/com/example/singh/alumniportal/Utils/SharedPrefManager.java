/*
package com.example.singh.alumniportal.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.singh.alumniportal.Model.User;
import com.example.singh.alumniportal.activity.LoginActivity;

public class SharedPrefManager {

    //the constants
    private static final String SHARED_PREF_NAME = "serverloginsharedpref";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_ROLL = "keyroll";
    private static final String KEY_BATCH = "keybatch";
    private static final String KEY_BRANCHES = "keybranches";
    private static final String KEY_PHONENUMBER = "keyphonenumber";
    private static final String KEY_DOB = "keydob";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_ROLE = "keyrole";
    private static final String KEY_ID = "keyid";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(KEY_ID, user.g);
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_EMAIL, user.getEmailId());
        editor.putString(KEY_ROLL, user.getRollNo());
        editor.putString(KEY_BATCH, user.getBatch());
        editor.putString(KEY_BRANCHES, user.getBranches());
        editor.putString(KEY_PHONENUMBER, user.getPhonenumber());
        editor.putString(KEY_DOB, user.getDateOfBirth());
        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putString(KEY_ROLE, user.getRole());

        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_ROLL, null),
                sharedPreferences.getString(KEY_BATCH, null),
                sharedPreferences.getString(KEY_BRANCHES, null),
                sharedPreferences.getString(KEY_PHONENUMBER, null),
                sharedPreferences.getString(KEY_DOB, null),
                sharedPreferences.getString(KEY_PASSWORD, null),
                sharedPreferences.getString(KEY_ROLE, null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));

    }
}*/
