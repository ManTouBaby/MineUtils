package com.hrw.utilslibrary.file;

import android.content.Context;
import android.os.Environment;

/**
 * @author:MtBaby
 * @date:2018/11/23 22:31
 * @desc:
 */
public class MtFileUtil {

    public static String getAppPath(Context context) {
        return getExternalStorageDirectory() + "/" + context.getPackageName();
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }


}
