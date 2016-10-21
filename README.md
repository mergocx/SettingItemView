# SettingView
--------------------------
#### 一、简介：
**1.1 Gradle集成**
  
  allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
  
  dependencies {
	        compile 'com.github.starmeigo:SettingItemView:V1.0.0'
	}
**1.2 功能说明**
    1,通过属性的设置,可以展示不同的条目的效果
    2,可以在xml文件中设置,也可以在Java代码中设置
 
#### 二、截图
    
 
#### 三、使用
**3.1 提供方法**
    //设置了左侧文字的属性
    settingItem.setLeftText("我很好",getResources().getColor(R.color.colorPrimary),12);
**3.2 示例代码**
    <com.chenxin.sivlibary.SettingItem xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/settingItem"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:background="@drawable/settingitem_selector"
        android:padding="5dp"
        app:isToggleButton="true"
        app:leftIconHeight="20dp"
        app:leftIconId="@drawable/item_paymethod_alipay"
        app:leftIconMarginLeft="5dp"
        app:leftIconWidth="20dp"
        app:leftText="支付方式"
        app:leftTextMarginLeft="5dp"
        app:mainText="安啦"
        app:isNextTextView="true"
        app:nextText="keyi"
        app:rightIconHeight="15dp"
        app:rightIconId="@drawable/right_arrow"
        app:rightIconMarginRight="5dp"
        app:rightIconWidth="15dp"
        app:rightText="厉害"
        app:rightTextMarginRight="5dp" />
        
        settingItem.setOnSettingItemClick(new SettingItem.OnSettingItemClick() {
            @Override
            public void onSettingItemClick() {
                Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        //settingItem.setLeftText("你好啊");
        settingItem.setLeftText("我很好",getResources().getColor(R.color.colorPrimary),12);
        settingItem.setLeftIcon(false);
        settingItem.setBackgroundResource(R.drawable.item_shape_normal);
        
