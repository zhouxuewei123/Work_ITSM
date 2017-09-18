package com.android.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:39
 */
public class DialogCreate extends Dialog {
    private Context context;
    private View view;
    private boolean isOutSideTouch = false;
    private int width;
    private int height;

    public DialogCreate(Context context) {
        super(context);
        this.context = context;
    }

    public DialogCreate(Context context, View view) {
        super(context);
        this.view = view;
        this.context = context;
    }

    public DialogCreate(Context context, View view, int theme) {
        super(context, theme);
        this.view = view;
        this.context = context;
    }

    public DialogCreate(Context context, View view, int theme,
                        boolean isOutSide) {
        super(context, theme);
        this.view = view;
        this.isOutSideTouch = isOutSide;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(view);
        this.setCanceledOnTouchOutside(isOutSideTouch);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager m = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        m.getDefaultDisplay().getMetrics(dm);

        if (this.width == 0) {
            this.width = (int) (dm.widthPixels * 0.9);
        }
        if (this.height == 0) {
            this.height = (int) (dm.heightPixels * 0.85);
        }
        WindowManager.LayoutParams layoutParams = this.getWindow()
                .getAttributes();
        layoutParams.width = this.width;
        layoutParams.height = this.height;
        this.getWindow().setAttributes(layoutParams);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
