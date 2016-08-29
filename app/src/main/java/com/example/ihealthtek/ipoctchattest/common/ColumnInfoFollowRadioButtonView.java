package com.example.ihealthtek.ipoctchattest.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ihealthtek.ipoctchattest.R;

/**
 * Created by Jiang on 2016/8/26.
 * Email:tengfangjiang@126.com
 */
public class ColumnInfoFollowRadioButtonView extends LinearLayout {
    public interface ColumnInfoTextListener {
        public void onCheckedChangeListener(ColumnInfoFollowRadioButtonView radioGroup, int checkedId);
    }

    private ColumnInfoTextListener listener;
    private TextView mLeftTitleView;
    private ImageView mStarImageView;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private RadioButton mRadioButton6;
    private int mCurSelect = 0;

    private Context mContext;

    private LinearLayout mLinearLayout;

    public ColumnInfoFollowRadioButtonView(Context context) {
        this(context, null);
        this.mContext = context;
    }

    public ColumnInfoFollowRadioButtonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
    }

    public ColumnInfoFollowRadioButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.column_info_follow_radio_button_view, this, true);

        initView();
        initData(context, attrs, defStyle);
        initListener();

    }

    private void initView() {
        this.mLeftTitleView = (TextView) this.findViewById(R.id.follow_table_gxy_left_rb_txt);
        this.mRadioButton1 = (RadioButton) this.findViewById(R.id.column_info_view_radio_1_id);
        this.mRadioButton2 = (RadioButton) this.findViewById(R.id.column_info_view_radio_2_id);
        this.mRadioButton3 = (RadioButton) this.findViewById(R.id.column_info_view_radio_3_id);
        this.mRadioButton4 = (RadioButton) this.findViewById(R.id.column_info_view_radio_4_id);
        this.mRadioButton5 = (RadioButton) this.findViewById(R.id.column_info_view_radio_5_id);
        this.mRadioButton6 = (RadioButton) this.findViewById(R.id.column_info_view_radio_6_id);
        this.mStarImageView = (ImageView) this.findViewById(R.id.column_info_edit_view_left_name_iv_id);
        this.mLinearLayout = (LinearLayout) this.findViewById(R.id.thistime_gxy_tnb_category);
    }

    private void initData(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.columnView, defStyle, 0);

        final String titleleft = a.getString(R.styleable.columnView_titleleft);
        final String radio1 = a.getString(R.styleable.columnView_radio1);
        final String radio2 = a.getString(R.styleable.columnView_radio2);
        final String radio3 = a.getString(R.styleable.columnView_radio3);
        final String radio4 = a.getString(R.styleable.columnView_radio4);
        final String radio5 = a.getString(R.styleable.columnView_radio5);
        final String radio6 = a.getString(R.styleable.columnView_radio6);
        final int leftcolor = a.getColor(R.styleable.columnView_titleleftcolor, 0);
        final int rightcolor = a.getColor(R.styleable.columnView_titlerightcolor, 0);

        final boolean showradio3 = a.getBoolean(R.styleable.columnView_titleshowradio3, false);
        final boolean showradio4 = a.getBoolean(R.styleable.columnView_titleshowradio4, false);
        final boolean showradio5 = a.getBoolean(R.styleable.columnView_titleshowradio5, false);
        final boolean showradio6 = a.getBoolean(R.styleable.columnView_titleshowradio6, false);
        final boolean showstar = a.getBoolean(R.styleable.columnView_titleshowstar, false);
        if (showstar) {
            this.mStarImageView.setVisibility(VISIBLE);
        }
        if (showradio3) {
            this.mRadioButton3.setVisibility(VISIBLE);
        }
        if (showradio4) {
            this.mRadioButton4.setVisibility(VISIBLE);
        }
        if (showradio5) {
            this.mRadioButton5.setVisibility(VISIBLE);
        }
        if (showradio6) {
            this.mRadioButton6.setVisibility(VISIBLE);
        }
        if (leftcolor != 0) {
            this.mLeftTitleView.setTextColor(leftcolor);
        }
        if (TextUtils.isEmpty(titleleft)) {
            mLinearLayout.setVisibility(View.GONE);
//            if (!showstar) {
//                this.mStarImageView.setVisibility(View.GONE);
//            }
        }
        if (rightcolor != 0) {
            this.mRadioButton1.setTextColor(rightcolor);
            this.mRadioButton2.setTextColor(rightcolor);
            this.mRadioButton3.setTextColor(rightcolor);
            this.mRadioButton4.setTextColor(rightcolor);
            this.mRadioButton5.setTextColor(rightcolor);
            this.mRadioButton6.setTextColor(rightcolor);
        }
        if (!TextUtils.isEmpty(titleleft)) {
            this.mLeftTitleView.setText(titleleft);
        }
        if (!TextUtils.isEmpty(radio1)) {
            mRadioButton1.setText(radio1);
        }
        if (!TextUtils.isEmpty(radio2)) {
            mRadioButton2.setText(radio2);
        }
        if (!TextUtils.isEmpty(radio3)) {
            mRadioButton3.setText(radio3);
        }
        if (!TextUtils.isEmpty(radio4)) {
            mRadioButton4.setText(radio4);
        }
        if (!TextUtils.isEmpty(radio5)) {
            mRadioButton5.setText(radio5);
        }
        if (!TextUtils.isEmpty(radio6)) {
            mRadioButton6.setText(radio6);
        }
        a.recycle();
    }


    private void initListener() {

        mRadioButton1.setOnCheckedChangeListener(myRadioButtonListener);
        mRadioButton2.setOnCheckedChangeListener(myRadioButtonListener);
        mRadioButton3.setOnCheckedChangeListener(myRadioButtonListener);
        mRadioButton4.setOnCheckedChangeListener(myRadioButtonListener);
        mRadioButton5.setOnCheckedChangeListener(myRadioButtonListener);
        mRadioButton6.setOnCheckedChangeListener(myRadioButtonListener);
    }

    private CompoundButton.OnCheckedChangeListener myRadioButtonListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            int viewId = compoundButton.getId();
            int id = 0;
            switch (viewId) {
                case R.id.column_info_view_radio_1_id:
                    id = 1;
                    break;
                case R.id.column_info_view_radio_2_id:
                    id = 2;
                    break;
                case R.id.column_info_view_radio_3_id:
                    id = 3;
                    break;
                case R.id.column_info_view_radio_4_id:
                    id = 4;
                    break;
                case R.id.column_info_view_radio_5_id:
                    id = 5;
                    break;
                case R.id.column_info_view_radio_6_id:
                    id = 6;
                    break;
            }
            if (checked) {
                setRightSelect(id);
            }
        }
    };

    public void setRightSelect(int index) {
        mRadioButton1.setChecked(false);
        mRadioButton2.setChecked(false);
        mRadioButton3.setChecked(false);
        mRadioButton4.setChecked(false);
        mRadioButton5.setChecked(false);
        mRadioButton6.setChecked(false);
        if (index == 1) {
            mRadioButton1.setChecked(true);
        } else if (index == 2) {
            mRadioButton2.setChecked(true);
        } else if (index == 3) {
            mRadioButton3.setChecked(true);
        } else if (index == 4) {
            mRadioButton4.setChecked(true);
        } else if (index == 5) {
            mRadioButton5.setChecked(true);
        } else if (index == 6) {
            mRadioButton6.setChecked(true);
        }
        mCurSelect = index;
        Log.i("RadioButtonView", "setRightSelect " + index);
        if (listener != null) {
            listener.onCheckedChangeListener(this, mCurSelect);
        }
    }

    public int getRightSelect() {
        return this.mCurSelect;
    }

    public void addCheckedChangeListener(ColumnInfoTextListener listener) {
        this.listener = listener;
    }
}
