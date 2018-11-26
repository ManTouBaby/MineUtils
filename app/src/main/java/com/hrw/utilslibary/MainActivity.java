package com.hrw.utilslibary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hrw.utilslibrary.sharepreferences.MtSPHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMineClick(View view) {
        switch (view.getId()) {
            case R.id.bt_show_test:
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_show_test1:
                MtSPHelper.init(getApplication(), "MainActivity");
                MtSPHelper.putString("MainActivity", "main", "我是main产生的数据");
                System.out.println("QQ测试SharedPreferences:" + MtSPHelper.getString("MainActivity", "main"));
                break;
        }
    }
}
