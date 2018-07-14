package com.gomtel.settings.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.gomtel.settings.R;
import com.gomtel.settings.SettingsFragment;
import com.gomtel.settings.account.AccountFragment;
import com.gomtel.settings.datetime.DateTimeFragment;
import com.gomtel.settings.datetime.DateTimeTestFragment;
import com.gomtel.settings.language.LanguageFragment;
import com.gomtel.settings.reset.ResetFragment;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by luojunqing on 2018/7/6.
 */

public class SettingsUtil {

    private final static String SP_NAME = "new_language_image";

    public static void replaceSettingsMain(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        SettingsFragment settingsFragment = new SettingsFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, settingsFragment).commit();
    }

    public static void replaceLanguage(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getActivity().getFragmentManager();
        LanguageFragment languageFragment = new LanguageFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, languageFragment).commit();
    }

    public static void replaceReset(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        ResetFragment resetFragment = new ResetFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, resetFragment).commit();
    }

    public static void replaceAccount(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        AccountFragment accountFragment = new AccountFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, accountFragment).commit();
    }

    public static void replaceTimeDate(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getActivity().getFragmentManager();
        DateTimeFragment dateTimeFragment = new DateTimeFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, dateTimeFragment).commit();
    }

    public static void replaceTest(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getActivity().getFragmentManager();
        DateTimeTestFragment dateTimeTestFragment = new DateTimeTestFragment();
        fragmentManager.beginTransaction().replace(R.id.activity_main_layout, dateTimeTestFragment).commit();
    }

    public static void setInt(Context context, String key, int value) {
        Log.d("yangyulin", "updateItemImageView: value====" + String.valueOf(value));
        SharedPreferences.Editor sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit();
        sp.putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        Log.d("yangyulin", "updateItemImageView: defaultValue====" + String.valueOf(defaultValue));
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        int str = sp.getInt(key, defaultValue);
        return str;
    }

    public static void setString(Context context, String key, String value) {
        Log.d("yangyulin", "updateItemImageView: value====" + value);
        SharedPreferences.Editor sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit();
        sp.putString(key, value).commit();
    }
    public static String getString(Context context, String key, String defaultValue) {
        Log.d("yangyulin", "updateItemImageView: defaultValue====" + String.valueOf(defaultValue));
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        String str = sp.getString(key, defaultValue);
        return str;
    }

    public static int getYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return year;
    }

    public static String getDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        String hourstr;
        if (hour >= 12) {
            hourstr = (hour - 12) < 10 ? "0" + (hour - 12) : (hour - 12) + "";
            Log.e("yang", "getpos: hourstr===if====" + hourstr);
        }else {
            hourstr = hour < 10 ? "0" + hour : hour + "";
            Log.e("yang", "getpos: hourstr===else====" + hourstr);
        }
        String minutestr = minute < 10 ? "0" + minute : minute + "";
        String dateStr = hourstr + ":" + minutestr;
        Log.e("yang", "getpos: dateStr=======" + dateStr);
        return dateStr;
    }

    public static int getAp() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int point = 0;
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if (hour >= 12) {
            point = 1;
        }
        return point;
    }

    public static String getDays() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        String monthstr = (month + 1) < 10 ? "0" + (month + 1) : (month + 1) + "";
        String datestr = date < 10 ? "0" + date : date + "";
        String daysStr = monthstr + "月" + datestr + "日";
        return daysStr;
    }

    public static int getDatePosition(String[] args, String str) {
        //Log.e("yang", "getpos: str===" + str);
        String current;
        for (int i = 0; i < args.length; i++) {
            //Log.e("yang", "getpos:for args[i]===" + args[i]);
            current = args[i];
            if (current.equals(str)) {
                Log.e("yang", "getpos:if current===");
                return i;
            } else {
                //Log.e("yang", "getpos:else current===");
            }
        }
        return 0;
    }

    public static int getDaysPosition(String[] args, String str) {
        //Log.e("yang", "getpos: str===" + str);
        String current;
        for (int i = 0; i < args.length; i++) {
            //Log.e("yang", "getpos:for args[i]===" + args[i]);
            current = args[i];
            if (current.equals(str)) {
                //Log.e("yang", "getpos:if current===");
                return i;
            } else {
                //Log.e("yang", "getpos:else current===");
            }
        }
        return 0;
    }
}
