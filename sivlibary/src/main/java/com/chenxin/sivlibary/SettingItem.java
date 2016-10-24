package com.chenxin.sivlibary;

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

import static android.content.ContentValues.TAG;

/**
 * Created by chenxin on 2016/10/19.
 * Fuction:自定义一个可扩展的设置界面的条目
 */

public class SettingItem extends LinearLayout {

    private Context context;
    public static final int DefaultTextSize = 16;
    public static final int DefaultTextColor = Color.BLACK;
    public static final int DefaultHighTextSize = 18;

    private ImageView leftIcon;
    private ImageView rightIcon;
    private TextView leftTextView;
    private TextView rightTextView;
    private TextView mainTextView;
    private TextView nextTextView;
    private ToggleButton toggleButton;
    private int leftIconId;
    private int rightIconId;
    private float leftIconWidth;
    private float leftIconHeight;
    private float rightIconWidth;
    private float rightIconHeight;
    private float leftIconMarginLeft;
    private float rightIconMarginRight;
    private boolean isLeftIcon;
    private boolean isRightIcon;
    private boolean isToggleButton;
    private boolean isRightFirst;

    private String leftText;
    private String rightText;
    private String mainText;
    private String nextText;
    private float leftTextMarginLeft;
    private float mainTextMarginTop;
    private float nextTextMarginBottom;
    private float rightTextMarginRight;
    private boolean isLeftTextView;
    private boolean isRightTextView;
    private boolean isMainTextView;
    private boolean isNextTextView;
    private OnToggleButtonChecked onToggleButtonChecked;
    private OnSettingItemClick onSettingItemClick;

    public void setOnSettingItemClick(OnSettingItemClick onSettingItemClick) {
        this.onSettingItemClick = onSettingItemClick;
    }

    public void setOnToggleButtonChecked(OnToggleButtonChecked onToggleButtonChecked) {
        this.onToggleButtonChecked = onToggleButtonChecked;
    }

    /**
     * ToggleButton的状态变化的监听
     *
     */
    public interface OnToggleButtonChecked {
        void onOpen();

        void onClose();
    }

    /**
     * 监听SettingItem是否被点击
     *
     */
    public interface OnSettingItemClick {
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
     * 将属性值读取出来
     *
     */
    private void initData(Context context, AttributeSet attrs) {
        this.context = context;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSettingItemClick != null) {
                    onSettingItemClick.onSettingItemClick();
                }
            }
        });
        setBackgroundDrawable(getResources().getDrawable(R.drawable.settingitem_selector));
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItem);
            isLeftIcon = tArray.getBoolean(R.styleable.SettingItem_isLeftIconCX, true);
            leftIconId = tArray.getResourceId(R.styleable.SettingItem_leftIconIdCX, 0);
            leftIconWidth = tArray.getDimension(R.styleable.SettingItem_leftIconWidthCX, DimensUtil.dp2px(20,context));
            leftIconHeight = tArray.getDimension(R.styleable.SettingItem_leftIconHeightCX, DimensUtil.dp2px(20,context));
            leftIconMarginLeft = tArray.getDimension(R.styleable.SettingItem_leftIconMarginLeftCX, 0);

            isLeftTextView = tArray.getBoolean(R.styleable.SettingItem_isLeftTextViewCX, true);
            leftText = tArray.getString(R.styleable.SettingItem_leftTextCX);
            leftTextMarginLeft = tArray.getDimension(R.styleable.SettingItem_leftTextMarginLeftCX, 0);

            isMainTextView = tArray.getBoolean(R.styleable.SettingItem_isMainTextViewCX, true);
            mainText = tArray.getString(R.styleable.SettingItem_mainTextCX);
            mainTextMarginTop = tArray.getLayoutDimension(R.styleable.SettingItem_mainTextMarginTopCX, 0);

            isNextTextView = tArray.getBoolean(R.styleable.SettingItem_isNextTextViewCX, false);
            nextText = tArray.getString(R.styleable.SettingItem_nextTextCX);
            nextTextMarginBottom = tArray.getLayoutDimension(R.styleable.SettingItem_nextTextMarginBottomCX, 0);

            isRightTextView = tArray.getBoolean(R.styleable.SettingItem_isRightTextViewCX, true);
            rightText = tArray.getString(R.styleable.SettingItem_rightTextCX);
            rightTextMarginRight = tArray.getLayoutDimension(R.styleable.SettingItem_rightTextMarginRightCX, 0);

            isRightIcon = tArray.getBoolean(R.styleable.SettingItem_isRightIconCX, true);
            rightIconId = tArray.getResourceId(R.styleable.SettingItem_rightIconIdCX, 0);
            rightIconWidth = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconWidthCX, DimensUtil.dp2px(15,context));
            rightIconHeight = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconHeightCX, DimensUtil.dp2px(15,context));
            rightIconMarginRight = tArray.getLayoutDimension(R.styleable.SettingItem_rightIconMarginRightCX, 0);

            isToggleButton = tArray.getBoolean(R.styleable.SettingItem_isToggleButtonCX, false);

            isRightFirst = tArray.getBoolean(R.styleable.SettingItem_isRightFirstCX, true);
            tArray.recycle();
        }
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        leftIcon = new ImageView(getContext());
        leftTextView = new TextView(context);
        mainTextView = new TextView(context);
        nextTextView = new TextView(context);
        rightIcon = new ImageView(context);
        rightTextView = new TextView(context);
        toggleButton = new ToggleButton(context);
    }

    /**
     * 所有子view的设置和初始化
     *
     */
    private void initLayout() {
        if (isLeftIcon) {
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
            leftTextView.setTextSize(DefaultTextSize);
            leftTextView.setTextColor(DefaultTextColor);
            addView(leftTextView, leftTextViewParams);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(VERTICAL);
        LayoutParams lLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lLayoutParams.gravity = Gravity.CENTER;
        lLayoutParams.weight = 1;
        if (isMainTextView) {
            mainTextView.setText(mainText);
            LayoutParams mainTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mainTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
            mainTextViewParams.topMargin = (int) mainTextMarginTop;
            mainTextView.setTextSize(DefaultHighTextSize);
            mainTextView.setTextColor(DefaultTextColor);
            linearLayout.addView(mainTextView, mainTextViewParams);
            if (isNextTextView) {
                nextTextView.setText(nextText);
                LayoutParams nextTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                nextTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
                nextTextViewParams.bottomMargin = (int) nextTextMarginBottom;
                nextTextView.setTextSize(DefaultTextSize);
                nextTextView.setTextColor(DefaultTextColor);
                linearLayout.addView(nextTextView, nextTextViewParams);
            }
        }
        addView(linearLayout, lLayoutParams);
        if (isRightFirst) {
            initRightText();
            initRightIcon();
        } else {
            initRightIcon();
            initRightText();
        }
        initToggleButton();
    }

    /**
     * 开关的初始化设置
     *
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
     * 右侧图片的初始化
     *
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
     * 右侧文字的初始化
     *
     */
    private void initRightText() {
        if (isRightTextView) {
            rightTextView.setText(rightText);
            LayoutParams rightTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            rightTextViewParams.gravity = Gravity.CENTER_VERTICAL;
            rightTextViewParams.rightMargin = (int) rightTextMarginRight;
            rightTextView.setTextSize(DefaultTextSize);
            rightTextView.setTextColor(DefaultTextColor);
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
     * 设置左文字的一系列的信息
     *
     * @param leftText 设置左文字的信息
     * @param color    设置左文字的颜色
     * @param size     设置左文字的大小
     */
    public void setLeftText(String leftText, int color, int size) {
        leftTextView.setText(leftText);
        leftTextView.setTextColor(color);
        leftTextView.setTextSize(size);
    }

    /**
     * 设置右边文字的展示内容,颜色,大小
     *
     */
    public void setRightText(String rightText, int color, int size) {
        rightTextView.setText(rightText);
        rightTextView.setTextColor(color);
        rightTextView.setTextSize(size);
    }

    /**
     * 中间上部文字的展示内容,颜色和大小
     *
     */
    public void setMainText(String mainText, int color, int size) {
        mainTextView.setText(mainText);
        mainTextView.setTextColor(color);
        mainTextView.setTextSize(size);
    }

    /**
     * 中间下部分文字的展示内容,颜色和大小
     *
     */
    public void setNextText(String nextText, int color, int size) {
        nextTextView.setText(nextText);
        nextTextView.setTextColor(color);
        nextTextView.setTextSize(size);
    }

    /**
     * 获取toggleButton的开关状态
     *
     */
    public boolean getToggleButtonState() {
        boolean checked = false;
        if (toggleButton != null) {
            checked = toggleButton.isChecked();
        }
        return checked;
    }

    /**
     * 设置toggleButton的状态
     *
     */
    public void setToggleButtonState(boolean state) {
        if (toggleButton != null) {
            toggleButton.setChecked(state);
        }
    }

    /**
     * 设置左侧图标的显示与隐藏
     *
     */
    public void setLeftIcon(boolean hasLeftIcon) {
        if (leftIcon != null) {
            if (hasLeftIcon) {
                leftIcon.setVisibility(View.VISIBLE);
            } else {
                leftIcon.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置右侧图标的显示与隐藏
     *
     */
    public void setRightIcon(boolean hasRightIcon) {
        if (rightIcon != null) {
            if (hasRightIcon) {
                rightIcon.setVisibility(View.VISIBLE);
            } else {
                rightIcon.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置ToggleButton的现实与隐藏
     *
     */
    public void setToggleButton(boolean hasToggleButton) {
        if (toggleButton != null) {
            if (hasToggleButton) {
                toggleButton.setVisibility(View.VISIBLE);
            } else {
                toggleButton.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置左侧文字的显示与隐藏
     *
     */
    public void setLeftTextView(boolean hasLeftTextView) {
        if (leftTextView != null) {
            if (hasLeftTextView) {
                leftTextView.setVisibility(View.VISIBLE);
            } else {
                leftTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置右侧的文字显示与隐藏
     *
     */
    public void setRightTextView(boolean hasRightTextView) {
        if (rightTextView != null) {
            if (hasRightTextView) {
                rightTextView.setVisibility(View.VISIBLE);
            } else {
                rightTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置中间上方的文字显示与隐藏
     *
     */
    public void setMainTextView(boolean hasMainTextView) {
        if (mainTextView != null) {
            if (hasMainTextView) {
                mainTextView.setVisibility(View.VISIBLE);
            } else {
                mainTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置中间下方的文字显示与隐藏
     *
     */
    public void setNextTextView(boolean hasNextTextView) {
        if (nextTextView != null) {
            if (hasNextTextView) {
                nextTextView.setVisibility(View.VISIBLE);
            } else {
                nextTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置toggleButton的样式
     *
     */
    public void setToggleButtonStyle(int resId) {
        if (toggleButton != null) {
            toggleButton.setButtonDrawable(resId);
        }
    }
}
