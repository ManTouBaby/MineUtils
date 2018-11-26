package com.hrw.utilslibary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hrw.utilslibrary.sharepreferences.MtSPHelper;

/**
 * @author:MtBaby
 * @date:2018/11/24 20:32
 * @desc:
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MtSPHelper.init(getApplication(), "TestActivity");
        MtSPHelper.putString("TestActivity", "TestActivity", "我是TestActivity产生的数据");
        System.out.println("TestActivity测试SharedPreferences:" + MtSPHelper.getString("TestActivity", "TestActivity"));
    }

    public void onMineClick(View view) {
        switch (view.getId()) {
            case R.id.bt_show_test:
                MtSPHelper.init(getApplication(), "QQ");
                MtSPHelper.putString("QQ", "qq", "我是QQ产生的数据");
                System.out.println("QQ测试SharedPreferences:" + MtSPHelper.getString("QQ", "qq"));
                break;
            case R.id.bt_show_test1:
                System.out.println("QQ测试SharedPreferences:" + MtSPHelper.getString("MainActivity", "main"));
                break;
        }
    }
}
