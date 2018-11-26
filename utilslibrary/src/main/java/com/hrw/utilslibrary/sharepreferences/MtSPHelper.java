package com.hrw.utilslibrary.sharepreferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/10/18 11:13
 * @desc:
 */
public class MtSPHelper {
    private static Map<String, SharedPreferences> mPreferencesMap = new HashMap<>();

    private MtSPHelper() {
    }

    public static void init(Application context, String fileName) {
        init(context, fileName, 0);
    }

    public static void init(Application context, String sharedPreferencesFileName, int mode) {
        if (mPreferencesMap.containsKey(sharedPreferencesFileName)) {
            try {
                throw new Exception("the preferencesFileName already exists,Please named by other");
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }
            return;
        } else {
            SharedPreferences preferences = context.getSharedPreferences(sharedPreferencesFileName, mode);
            mPreferencesMap.put(sharedPreferencesFileName, preferences);
        }
    }

    public static boolean putString(@NonNull String fileName, String key, String value) {
        return getEditor(fileName).putString(key, value).commit();
    }

    public static boolean putStringSet(@NonNull String fileName, String key, Set<String> value) {
        return getEditor(fileName).putStringSet(key, value).commit();
    }

    public static boolean putInt(@NonNull String fileName, String key, int value) {
        return getEditor(fileName).putInt(key, value).commit();
    }

    public static boolean putLong(@NonNull String fileName, String key, long value) {
        return getEditor(fileName).putLong(key, value).commit();
    }

    public static boolean putFloat(@NonNull String fileName, String key, float value) {
        return getEditor(fileName).putFloat(key, value).commit();
    }

    public static boolean putBoolean(@NonNull String fileName, String key, boolean value) {
        return getEditor(fileName).putBoolean(key, value).commit();
    }

    public static SharedPreferences.Editor remove(@NonNull String fileName, String key) {
        return getEditor(fileName).remove(key);
    }

    public static SharedPreferences.Editor clear(@NonNull String fileName) {
        return getEditor(fileName).clear();
    }


    public static Map<String, ?> getAll(@NonNull String fileName) {
        return getSharedPreferences(fileName).getAll();
    }

    public static String getString(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getString(key, null);
    }

    public static String getString(@NonNull String fileName, String key, String defaultValue) {
        return getSharedPreferences(fileName).getString(key, defaultValue);
    }

    public static Set<String> getStringSet(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getStringSet(key, null);
    }

    public static Set<String> getStringSet(@NonNull String fileName, String key, Set<String> defaultValue) {
        return getSharedPreferences(fileName).getStringSet(key, defaultValue);
    }

    public static int getInt(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getInt(key, -1);
    }

    public static int getInt(@NonNull String fileName, String key, int defaultValue) {
        return getSharedPreferences(fileName).getInt(key, defaultValue);
    }

    public static long getLong(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getLong(key, -1);
    }

    public static long getLong(@NonNull String fileName, String key, long defaultValue) {
        return getSharedPreferences(fileName).getLong(key, defaultValue);
    }

    public static float getFloat(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getFloat(key, -1);
    }

    public static float getFloat(@NonNull String fileName, String key, float defaultValue) {
        return getSharedPreferences(fileName).getFloat(key, defaultValue);
    }

    public static boolean getBoolean(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).getBoolean(key, false);
    }

    public static boolean getBoolean(@NonNull String fileName, String key, boolean defaultValue) {
        return getSharedPreferences(fileName).getBoolean(key, defaultValue);
    }

    public static boolean contains(@NonNull String fileName, String key) {
        return getSharedPreferences(fileName).contains(key);
    }

    private static SharedPreferences.Editor getEditor(String fileName) {
        if (mPreferencesMap.containsKey(fileName)) {
            return mPreferencesMap.get(fileName).edit();
        } else {
            try {
                throw new Exception("the preferencesFileName name no exists,Please create the SharedPreferences first!!");
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    private static SharedPreferences getSharedPreferences(String fileName) {
        if (mPreferencesMap.containsKey(fileName)) {
            return mPreferencesMap.get(fileName);
        } else {
            try {
                throw new Exception("the preferencesFileName name no exists,Please create the SharedPreferences first!!");
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }


}
