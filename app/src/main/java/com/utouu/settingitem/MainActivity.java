package com.utouu.settingitem;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.chenxin.sivlibary.SettingItem;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private com.chenxin.sivlibary.SettingItem settingItem;
    private ListView listView;
    private HashMap<Integer,View> hash = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        settingItem.setLeftText("我很好",getResources().getColor(R.color.colorPrimary),12);
        //settingItem.setLeftIcon(false);
        //settingItem.setBackgroundResource(R.drawable.item_shape_normal);
        listView = (ListView) findViewById(R.id.lv_siv);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (hash.get(position) == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(MainActivity.this,R.layout.listview_item,null);
                    holder.siv = (SettingItem) convertView.findViewById(R.id.siv_item);
                    convertView.setTag(holder);
                    hash.put(position,convertView);
                }else {
                    convertView = hash.get(position);
                    holder = (ViewHolder) convertView.getTag();
                }
                SettingItem settingItem1 = holder.siv;
                settingItem1.setLeftText(position+"般武艺", Color.BLACK,16);
                settingItem1.setLeftIconId(R.drawable.item_paymethod_wechat);
                settingItem1.setRightIconId(R.drawable.right_arrow);
                return convertView;
            }
        });
    }

    static class ViewHolder{
        SettingItem siv;
    }
}
