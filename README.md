# SettingItemView
--------------------------
#### 一、简介：
**1.1 Gradle集成**
  
	allprojects {
		repositories{ 
			...
			maven { url "https://jitpack.io" }
		}
	}
  
	dependencies {
		compile 'com.github.starmeigo:SettingItemView:V1.0.1'
	}
**1.2 功能说明**

    1,通过属性的设置,可以展示不同的条目的效果
    
    2,可以在xml文件中设置,也可以在Java代码中设置
 
#### 二、截图
![github](https://github.com/starmeigo/SettingItemView/raw/master/example/example.png)  
#### 三、使用

**3.1 提供方法**

<div>
    <table border="0">
      <tr>
        <th>xml属性</th>
        <th>功能</th>
      </tr>
      <tr>
        <td>isLeftIconCX</td>
        <td>左侧的图片是否显示</td>
      </tr>
      <tr>
        <td>leftIconIdCX</td>
        <td>左侧图片的资源id</td>
      </tr>
      <tr>
        <td>leftIconWidthCX</td>
        <td>左侧图片的宽</td>
      </tr>
       <tr>
        <td>leftIconHeightCX</td>
        <td>左侧图片的高</td>
      </tr>
      <tr>
        <td>leftIconMarginLeftCX</td>
        <td>左侧图片距左侧的距离</td>
      </tr>
      <tr>
        <td>isLeftTextViewCX</td>
        <td>左侧的文字是否显示</td>
      </tr>
      <tr>
        <td>leftTextCX</td>
        <td>左侧文字的内容</td>
      </tr>
      <tr>
        <td>leftTextMarginLeftCX</td>
        <td>左侧文字距左边的距离</td>
      </tr>
      <tr>
        <td>isMainTextViewCX</td>
        <td>中间上方的文字是否显示</td>
      </tr>
      <tr>
        <td>mainTextCX</td>
        <td>中间上方文字的内容</td>
      </tr>
      <tr>
        <td>mainTextMarginTopCX</td>
        <td>中间上方文字距上边的距离</td>
      </tr>
      <tr>
        <td>isNextTextViewCX</td>
        <td>中间下侧的文字是否显示</td>
      </tr>
      <tr>
        <td>nextTextCX</td>
        <td>中间下侧文字的内容</td>
      </tr>
      <tr>
        <td>nextTextMarginBottomCX</td>
        <td>中间下侧文字距下边的距离</td>
      </tr>
      <tr>
        <td>isRightTextViewCX</td>
        <td>右侧的文字是否显示</td>
      </tr>
      <tr>
        <td>rightTextCX</td>
        <td>右侧文字的内容</td>
      </tr>
      <tr>
        <td>rightTextMarginRightCX</td>
        <td>右侧文字距右边的距离</td>
      </tr>
      <tr>
        <td>isRightIconCX</td>
        <td>右侧的图片是否显示</td>
      </tr>
      <tr>
        <td>rightIconIdCX</td>
        <td>右侧图片的资源id</td>
      </tr>
      <tr>
        <td>rightIconWidthCX</td>
        <td>右侧图片的宽</td>
      </tr>
       <tr>
        <td>rightIconHeightCX</td>
        <td>右侧图片的高</td>
      </tr>
      <tr>
        <td>rightIconMarginRightCX</td>
        <td>右侧图片距右侧的距离</td>
      </tr>
      <tr>
        <td>isToggleButtonCX</td>
        <td>toggleButton是否显示</td>
      </tr>
      <tr>
        <td>isRightFirstCX</td>
        <td>右侧文字和右侧图片的位置顺序,默认文字在左</td>
      </tr>
    </table>
</div>
	
<div>
    <table border="0">
      <tr>
        <th>方法</th>
        <th>功能</th>
      </tr>
      <tr>
        <td>setLeftText(String leftText, int color, int size)</td>
        <td>设置左文字的一系列的信息</td>
      </tr>
      <tr>
        <td>setRightText(String rightText, int color, int size)</td>
        <td>设置右边文字的展示内容,颜色,大小</td>
      </tr>
      <tr>
        <td>setMainText(String mainText, int color, int size)</td>
        <td>中间上部文字的展示内容,颜色和大小</td>
      </tr>
      <tr>
        <td>setNextText(String nextText, int color, int size)()</td>
        <td>中间下部分文字的展示内容,颜色和大小</td>
      </tr>
      <tr>
        <td>getToggleButtonState</td>
        <td>获取toggleButton的开关状态</td>
      </tr>
      <tr>
        <td>setToggleButtonState(boolean state)</td>
        <td>设置toggleButton的状态</td>
      </tr>
      <tr>
        <td>setLeftIcon(boolean hasLeftIcon)</td>
        <td>设置左侧图标的显示与隐藏</td>
      </tr>
      <tr>
        <td>setRightIcon(boolean hasRightIcon)</td>
        <td>设置右侧图标的显示与隐藏</td>
      </tr>
      <tr>
        <td>setToggleButton(boolean hasToggleButton)</td>
        <td>设置ToggleButton的现实与隐藏</td>
      </tr>
      <tr>
        <td>setLeftTextView(boolean hasLeftTextView)</td>
        <td>设置左侧文字的显示与隐藏</td>
      </tr>
      <tr>
        <td>setRightTextView(boolean hasRightTextView)</td>
        <td>设置右侧的文字显示与隐藏</td>
      </tr>
      <tr>
        <td>setMainTextView(boolean hasMainTextView)</td>
        <td>设置中间上方的文字显示与隐藏</td>
      </tr>
      <tr>
        <td>setNextTextView(boolean hasNextTextView)</td>
        <td>设置中间下方的文字显示与隐藏</td>
      </tr>
      <tr>
        <td>setToggleButtonStyle(int resId)</td>
        <td>设置toggleButton的样式</td>
      </tr>
    </table>
</div>
	//设置了左侧文字的属性
	settingItem.setLeftText("我很好",getResources().getColor(R.color.colorPrimary),12);
	
**3.2 示例代码**
	
	xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/settingItem"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:background="@drawable/settingitem_selector"
        android:padding="5dp"
        app:isToggleButtonCX="true"
        app:leftIconHeightCX="20dp"
        app:leftIconIdCX="@drawable/item_paymethod_alipay"
        app:leftIconMarginLeftCX="5dp"
        app:leftIconWidthCX="20dp"
        app:leftTextCX="支付方式"
        app:leftTextMarginLeftCX="5dp"
        app:mainTextCX="安啦"
        app:isNextTextViewCX="true"
        app:nextTextCX="keyi"
        app:rightIconHeightCX="15dp"
        app:rightIconIdCX="@drawable/right_arrow"
        app:rightIconMarginRightCX="5dp"
        app:rightIconWidthCX="15dp"
        app:rightTextCX="厉害"
        app:rightTextMarginRightCX="5dp" 

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
