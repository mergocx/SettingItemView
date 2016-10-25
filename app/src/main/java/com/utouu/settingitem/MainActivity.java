package com.utouu.settingitem;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.chenxin.sivlibary.SettingItem;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private com.chenxin.sivlibary.SettingItem settingItem;
    private ListView listView;
    private ToggleButton mToggleButton;
    private HashMap<Integer, View> hash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToggleButton = (ToggleButton) findViewById(R.id.toggle_btn);
        mToggleButton.setText("");
        mToggleButton.setTextOn("");
        mToggleButton.setTextOff("");
        mToggleButton.setBackgroundColor(Color.TRANSPARENT);
        mToggleButton.setButtonDrawable(R.drawable.toggle_selector);
        settingItem = (SettingItem) findViewById(R.id.settingItem);
        //ToggleButton状态改变时候的监听器
        settingItem.setOnToggleButtonChecked(new SettingItem.OnToggleButtonChecked() {
            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this, "打开", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClose() {
                Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
            }
        });
        //整个条目的点击事件
        settingItem.setOnSettingItemClick(new SettingItem.OnSettingItemClick() {
            @Override
            public void onSettingItemClick() {
                Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        //settingItem.setLeftText("你好啊");
        settingItem.setLeftText("我很好", getResources().getColor(R.color.colorPrimary), 12);
        //settingItem.setLeftIcon(false);
        settingItem.setBackgroundResource(R.drawable.item_shape_normal);
        SettingItem settingItem1 = (SettingItem) findViewById(R.id.settingItem1);
        settingItem1.setMainTextViewParams(Gravity.CENTER_VERTICAL,10);
    }

    static class ViewHolder {
        SettingItem siv;
    }
}
