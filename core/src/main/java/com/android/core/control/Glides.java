package com.android.core.control;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.android.core.R;
import com.android.core.widget.GlideCircleTransform;
import com.bumptech.glide.Glide;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:36
 */
public class Glides {

    public static Glides instance = new Glides();

    public Glides() {
    }

    public static Glides getInstance() {
        return instance;
    }

    // 加载网络图片
    public void load(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .crossFade()
                .into(imageView);
    }

    // 加载圆型网络图片
    public void loadCircle(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }



    // 加载本地图片
    public void load(Context context, int resid, ImageView imageView) {
        Glide.with(context)
                .load(resid)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .crossFade()
                .into(imageView);
    }

    // 加载圆型本地图片
    public void loadCircle(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }
    // 加载网络图片动画
    public void loadAnima(Context context, String url, Animation animation, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animation)
                .crossFade()
                .into(imageView);
    }

    // 加载网络图片动画
    public void loadAnima(Context context, String url, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animationId)
                .crossFade()
                .into(imageView);
    }

    // 加载本地图片动画
    public void loadAnima(Context context, int resId, Animation animation, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animation)
                .crossFade()
                .into(imageView);
    }


    // 加载drawable图片
    public void loadAnima(Context context, int resId, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)
                .animate(animationId)
                .crossFade()
                .into(imageView);
    }
}
