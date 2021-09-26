package com.example.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class myView extends ViewGroup {

    private static final String TAG = myView.class.getSimpleName();
    private ImageView iv_test1;
    private TextView tv_test1;
    private Button btn_test1;

    public myView(Context context) {
        super(context);
        initView();
    }

    public myView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public myView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public myView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private EditText mEditText;
    private View fatherViewGroup;
    private ViewGroup f;
    private Button mButton;
    private OnClickListener onClickListener;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Log.d(TAG, "measuredWidth:" + measuredWidth + " measuredHeight:" + measuredHeight);
        int mEditTextL = 0;
        int mEditTextT = 0;
        int mEditTextR = mEditText.getLayoutParams().width ;
        int mEditTextB = mEditText.getLayoutParams().height;
        mEditText.layout(mEditTextL, mEditTextT, mEditTextR, mEditTextB);

        int mButtonTextL = mEditText.getLayoutParams().width + 30;
        int mButtonTextT = 0;
        int mButtonTextR = mEditTextR+mButton.getLayoutParams().width ;
        int mButtonTextB = mEditTextB+mButton.getLayoutParams().height;
        mButton.layout(mButtonTextL, mButtonTextT, mButtonTextR, mButtonTextB);

    }

    private void initView() {
        mEditText = new EditText(getContext());
        mButton = new Button(getContext());
        mEditText.setHint("等待输入");
        ViewGroup.LayoutParams editTextLayoutParams = new ViewGroup.LayoutParams(300, 200);
        mEditText.setLayoutParams(editTextLayoutParams);

        ViewGroup.LayoutParams buttonLayoutParams = new ViewGroup.LayoutParams(300, 200);
        mButton.setLayoutParams(buttonLayoutParams);
        mButton.setBackgroundColor(getContext().getColor(R.color.teal_200));
        mButton.setText("提交");
        mButton.setTextSize(15);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
            }
        });

        addView(mEditText);
        addView(mButton);
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
