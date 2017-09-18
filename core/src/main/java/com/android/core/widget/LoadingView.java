package com.android.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import com.android.core.R;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:39
 */
public class LoadingView extends Dialog implements View.OnClickListener {

//    int[] colors = new int[]{
//            android.graphics.Color.parseColor("#D55400"),
//            android.graphics.Color.parseColor("#2B3E51"),
//            android.graphics.Color.parseColor("#00BD9C"),
//            android.graphics.Color.parseColor("#227FBB"),
//            android.graphics.Color.parseColor("#7F8C8D"),
//            android.graphics.Color.parseColor("#FFCC5C"),
//            android.graphics.Color.parseColor("#D55400"),
//            android.graphics.Color.parseColor("#1AAF5D"),
//    };
//
//    public LoadingView(Context context) {
//        super(context, R.style.loading_dialog_style);
//        onInit();
//    }
//
//    private void onInit() {
//        View view = getLayoutInflater().inflate(R.layout.abc_view_loading, null);
//
//        ProgressBar mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
//        DoubleBounce doubleBounce = new DoubleBounce();
//        doubleBounce.setBounds(0, 0,
//                100,
//                100);
//        doubleBounce.setColor(colors[7]);
//        mProgressBar.setIndeterminateDrawable(doubleBounce);
//
//        view.setOnClickListener(this);
//        setContentView(view);
//        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//    }
//
//    @Override
//    public void onClick(View v) {
//        this.dismiss();
//    }
//
//    @Override
//    public void show() {
//        super.show();
//    }
//
//
//    @Override
//    public void dismiss() {
//        super.dismiss();
//    }

    private TextView tv_text;

    public LoadingView(Context context) {
        super(context, R.style.loading_dialog_style);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loading);
        tv_text = (TextView) findViewById(R.id.tv_text);
        setCanceledOnTouchOutside(false);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public LoadingView setMessage(String message) {
        tv_text.setText(message);
        return this;
    }

    public String getMessage() {
        return tv_text.getText().toString();
    }

    @Override
    public void onClick(View v) {

    }
}