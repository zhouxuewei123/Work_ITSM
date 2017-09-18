package com.android.core.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.core.R;

/**
 * @Description: 
 * @author: ragkan
 * @time: 2016/11/1 14:39
 */
public class ToastView {

	/**
	 * 显示Toast消息
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void showToast(Context context, String message, int duration) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.custom_toast, null);
		TextView text = (TextView) view.findViewById(R.id.toast_message);
		text.setText(message);
		Toast toast = new Toast(context);
		toast.setDuration(duration);
		toast.setGravity(Gravity.BOTTOM, 0, 300);
		toast.setView(view);
		toast.show();
	}
}
