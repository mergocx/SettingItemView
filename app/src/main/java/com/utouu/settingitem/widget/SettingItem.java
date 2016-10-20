package com.utouu.settingitem.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.utouu.settingitem.R;

import static android.content.ContentValues.TAG;

/**
 * Created by chenxin on 2016/10/19.
 * Fuction:自定义一个可扩展的设置界面的条目
 */

public class SettingItem extends LinearLayout {

    private ImageView leftIcon, rightIcon;
    private TextView leftTextView, rightTextView, mainTextView, nextTextView;
    private ToggleButton toggleButton;
    private int leftIconId, rightIconId;
    private float leftIconWidth, leftIconHeight, rightIconWidth, rightIconHeight;
    private float leftIconMarginLeft, rightIconMarginRight;
    private boolean isLeftIcon, isRightIcon, isToggleButton,isRightFirst;

    private String leftText;
    private String rightText;
    private String mainText;
    private String nextText;
    private float leftTextMarginLeft;
    private float mainTextMarginTop;
    private float nextTextMarginBottom;
    private float rightTextMarginRight;
    private boolean isLeftTextView, isRightTextView, isMainTextView, isNextTextView;
    private OnToggleButtonChecked onToggleButtonChecked;

    public void setOnToggleButtonChecked(OnToggleButtonChecked onToggleButtonChecked) {
        this.onToggleButtonChecked = onToggleButtonChecked;
    }

    public interface OnToggleButtonChecked {
        void onOpen();

        void onClose();

        void onSettingItemClick();
    }

    public SettingItem(Context context) {
        this(context, null);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs);
        initView();
        Log.e(TAG, "SettingItem: gogoogogogogoogo");
        initLayout();
    }

    /**
    * 说明方法的作用
    * 将属性值读取出来
    */
    private void initData(Context context, AttributeSet attrs) {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onToggleButtonChecked != null) {
                    onToggleButtonChecked.onSettingItemClick();
                }
            }
        });
        setBackgroundDrawable(getResources().getDrawable(R.drawable.settingitem_selector));
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItem);
            isLeftIcon = tArray.getBoolean(R.styleable.SettingItem_isLeftIcon, true);
            leftIconId = tArray.getResourceId(R.styleable.SettingItem_leftIconId, 0);
            leftIconWidth = tArray.getLayoutDimension(R.styleable.SettingItem_leftIconWidth, 0);
            leftIconHeight = tArray.getLayoutDimension(R.styleable.SettingItem_leftIconHeight, 0);
            leftIconMarginLeft = tArray.getLayoutDimension(R.styleable.SettingItem_leftIconMarginLeft, 0);

            isLeftTextView = tArray.getBoolean(R.styleable.SettingItem_isLeftTextView, true);
            leftText = tArray.getString(R.styleable.SettingItem_leftText);
            leftTextMarginLeft = tArray.getLayoutDimension(R.styleable.SettingItem_leftTextMarginLeft, 0);

            isMainTextView = tArray.getBoolean(R.styleable.SettingItem_isMainTextView, true);
            mainText = tArray.getString(R.styleable.SettingItem_mainText);
            mainTextMarginTop = tArray.getLayoutDimension(R.styleable.SettingItem_mainTextMarginTop, 0);

            isNextTextView = tArray.getBoolean(R.styleable.SettingItem_isNextTextView, false);
            nextText = tArray.getString(R.styleable.SettingItem_nextText);
            nextTextMarginBottom = tArray.getLayoutDimension(R.styleable.SettingItem_nextTextMarginBottom, 0);

            isRightTextView = tArray.getBoolean(R.styleable.SettingItem_isRightTextView, true);
            rightText = tArray.getString(R.styleable.SettingItem_rightText);
            rightTextMarginRight = tArray.getLayoutDimension(R.styleable.SettingItem_rightTextMarginRight, 0);

            isRightIcon = tArray.getBoolean(R.styleable.SettingItem_isRightIcon, true);
            rightIconId = tArray.getResourceId(R.styleable.SettingItem_rightIconId, 0);
            rightIconWidth = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconWidth, 0);
            rightIconHeight = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconHeight, 0);
            rightIconMarginRight = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconMarginRight, 0);

            isToggleButton = tArray.getBoolean(R.styleable.SettingItem_isToggleButton, false);

            isRightFirst = tArray.getBoolean(R.styleable.SettingItem_isRightFirst,true);
            tArray.recycle();
        }
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        rightIcon = new ImageView(getContext());
        toggleButton = new ToggleButton(getContext());
        leftTextView = new TextView(getContext());
        rightTextView = new TextView(getContext());
        mainTextView = new TextView(getContext());
        nextTextView = new TextView(getContext());
    }

    /**
    * 说明方法的作用
    * 所有子view的设置和初始化
    */
    private void initLayout() {
        if (isLeftIcon) {
            leftIcon = new ImageView(getContext());
            Log.e(TAG, "initLayout: leftIcon==true");
            leftIcon.setImageResource(leftIconId);
            LayoutParams leftIconParams = new LayoutParams((int) leftIconWidth, (int) leftIconHeight);
            leftIconParams.gravity = Gravity.CENTER_VERTICAL;
            leftIconParams.leftMargin = (int) leftIconMarginLeft;
            addView(leftIcon, leftIconParams);
        }
        if (isLeftTextView) {
            Log.e(TAG, "initLayout: leftText" + leftText);
            leftTextView.setText(leftText);
            LayoutParams leftTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            leftTextViewParams.gravity = Gravity.CENTER_VERTICAL;
            leftTextViewParams.leftMargin = (int) leftTextMarginLeft;
            leftTextView.setTextSize(16);
            leftTextView.setTextColor(Color.BLACK);
            addView(leftTextView, leftTextViewParams);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(VERTICAL);
        LayoutParams llayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        llayoutParams.gravity = Gravity.CENTER;
        llayoutParams.weight = 1;
        if (isMainTextView) {
            mainTextView.setText(mainText);
            LayoutParams mainTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mainTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
            mainTextViewParams.topMargin = (int) mainTextMarginTop;
            mainTextView.setTextSize(18);
            mainTextView.setTextColor(Color.BLACK);
            linearLayout.addView(mainTextView, mainTextViewParams);
            if (isNextTextView) {
                nextTextView.setText(nextText);
                LayoutParams nextTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                nextTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
                nextTextViewParams.bottomMargin = (int) nextTextMarginBottom;
                nextTextView.setTextSize(16);
                linearLayout.addView(nextTextView, nextTextViewParams);
            }
        }
        addView(linearLayout, llayoutParams);
        if (isRightFirst) {
            initRightText();
            initRightIcon();
        }else {
            initRightIcon();
            initRightText();
        }
        initToggleButton();
    }

    /**
    * 说明方法的作用
    * 开关的初始化设置
    */
    private void initToggleButton() {
        if (isToggleButton) {
            LayoutParams tButtonParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tButtonParams.gravity = Gravity.CENTER_VERTICAL;
            toggleButton.setFocusable(false);
            toggleButton.setButtonDrawable(getResources().getDrawable(R.drawable.toggle_selector));
            toggleButton.setBackgroundColor(Color.TRANSPARENT);
            toggleButton.setTextOff("");
            toggleButton.setTextOn("");
            toggleButton.setText("");
            addView(toggleButton, tButtonParams);
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (onToggleButtonChecked != null) {
                        if (isChecked) {
                            onToggleButtonChecked.onOpen();
                        } else {
                            onToggleButtonChecked.onClose();
                        }
                    }
                }
            });
        }
    }

    /**
    * 说明方法的作用
    * 右侧图片的初始化
    */
    private void initRightIcon() {
        if (isRightIcon) {
            rightIcon.setImageResource(rightIconId);
            LayoutParams rightIconParams = new LayoutParams((int) rightIconWidth, (int) rightIconHeight);
            rightIconParams.gravity = Gravity.CENTER_VERTICAL;
            rightIconParams.rightMargin = (int) rightIconMarginRight;
            addView(rightIcon, rightIconParams);
        }
    }

    /**
    * 说明方法的作用
    * 右侧文字的初始化
    */
    private void initRightText() {
        if (isRightTextView) {
            rightTextView.setText(rightText);
            LayoutParams rightTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            rightTextViewParams.gravity = Gravity.CENTER_VERTICAL;
            rightTextViewParams.rightMargin = (int) rightTextMarginRight;
            rightTextView.setTextSize(16);
            rightTextView.setTextColor(Color.BLACK);
            addView(rightTextView, rightTextViewParams);
        }
    }

    public void setLeftIconId(int leftIconId) {
        if (leftIcon != null) {
            leftIcon.setImageResource(leftIconId);
        } else {
            Log.e(TAG, "setLeftIconId: leftIcon为空,不可用");
        }
    }

    public void setRightIconId(int rightIconId) {
        rightIcon.setImageResource(rightIconId);
    }

    /**
    * 说明方法的作用  设置左文字的一系列的信息
    * @param leftText 设置左文字的信息
    * @param color 设置左文字的颜色
    * @param size 设置左文字的大小
    */
    public void setLeftText(String leftText,int color,int size) {
        leftTextView.setText(leftText);
        leftTextView.setTextColor(color);
        leftTextView.setTextSize(size);
    }

    /**
    * 说明方法的作用
    * 设置右边文字的展示内容,颜色,大小
    */
    public void setRightText(String rightText,int color,int size) {
        rightTextView.setText(rightText);
        rightTextView.setTextColor(color);
        rightTextView.setTextSize(size);
    }

    /**
    * 说明方法的作用
    * 中间上部文字的展示内容,颜色和大小
    */
    public void setMainText(String mainText,int color,int size) {
        mainTextView.setText(mainText);
        mainTextView.setTextColor(color);
        mainTextView.setTextSize(size);
    }

    /**
    * 说明方法的作用
    * 中间下部分文字的展示内容,颜色和大小
    */
    public void setNextText(String nextText,int color,int size) {
        nextTextView.setText(nextText);
        nextTextView.setTextColor(color);
        nextTextView.setTextSize(size);
    }
}
