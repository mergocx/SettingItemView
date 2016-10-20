package com.utouu.settingitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.utouu.settingitem.widget.SettingItem;

public class MainActivity extends AppCompatActivity {
    private SettingItem settingItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingItem = (SettingItem) findViewById(R.id.settingItem);
        settingItem.setOnToggleButtonChecked(new SettingItem.OnToggleButtonChecked() {
            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this, "打开", Toast.LENGTH_SHORT).show();
           }

            @Override
            public void onClose() {
                Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSettingItemClick() {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        //settingItem.setLeftText("你好啊");
        settingItem.setLeftText("我很好",getResources().getColor(R.color.colorPrimary),12);
        //settingItem.setBackgroundResource(R.drawable.item_shape_normal);
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        settingItem.addView(imageView);
    }
}
