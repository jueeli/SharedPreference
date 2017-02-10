package layout.com.layoutdemoapp.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mii-android2 on 24/1/17.
 */

public class SharedPrefClass {

    public static final String PREF_NAME = "SharedData";

    public static final String KEY_FIRST_NAME = "fname";
    public static final String KEY_LAST_NAME = "lname";
    public static final String KEY_ADDRESS = "addr";

    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    public SharedPrefClass(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setData(String firstName, String lastName, String addr) {
        editor.putString(KEY_FIRST_NAME, firstName);
        editor.putString(KEY_LAST_NAME, lastName);
        editor.putString(KEY_ADDRESS, addr);
        editor.commit();
    }
}