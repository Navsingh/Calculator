package com.example.navjot.calcul;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Navjot on 12/20/2017.
 */

public class SharedPrefrences {
    Context context;
    SharedPrefrences(Context context)
    {
        this.context = context;
    }
    public void lastCalulatedValue(String Value)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LastValues",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Last",Value);
        editor.commit();
    }
    public String getLastValue()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LastValues",Context.MODE_PRIVATE);
        return sharedPreferences.getString("Last","");
    }
}
