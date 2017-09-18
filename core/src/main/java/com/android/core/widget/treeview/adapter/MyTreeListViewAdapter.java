package com.android.core.widget.treeview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.core.R;
import com.android.core.widget.treeview.utils.OtherNode;
import com.android.core.widget.treeview.utils.adapter.TreeListViewOtherAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTreeListViewAdapter<T> extends TreeListViewOtherAdapter<T> {

	public MyTreeListViewAdapter(ListView mTree, Context context,
			List<T> datas, int defaultExpandLevel,boolean isHide)
			throws IllegalArgumentException, IllegalAccessException {
		super(mTree, context, datas, defaultExpandLevel,isHide);
	}
	Map<Integer,View> map = new HashMap<>();
	Map<Integer,ImageView> iconmap = new HashMap<>();
	Map<Integer,TextView> labelmap = new HashMap<>();
	Map<Integer,CheckBox> checkBoxmap = new HashMap<>();
	ImageView icon ;
	TextView label ;
	CheckBox checkBox ;


	@SuppressWarnings("unchecked")
	@Override
	public View getConvertView(final OtherNode node, int position, View convertView,
			ViewGroup parent) {
//		if(position<map.size()){
//			convertView = map.get(position);
//			icon = iconmap.get(position);
//			label = labelmap.get(position);
//			checkBox = checkBoxmap.get(position);
//			if (node.getIcon() == -1)
//			{
//				icon.setVisibility(View.INVISIBLE);
//			} else
//			{
//				icon.setVisibility(View.VISIBLE);
//				icon.setImageResource(node.getIcon());
//			}
//
//			if(node.isHideChecked()){
//				checkBox.setVisibility(View.GONE);
//			}else{
//				checkBox.setVisibility(View.VISIBLE);
////			setCheckBoxBg(checkBox, node.isChecked());
//			}
//			checkBox.setChecked(node.isChecked());
//			label.setText(node.getName());
//		}else {
//			convertView = mInflater.inflate(R.layout.list_item_o, parent, false);
//			icon = (ImageView) convertView
//					.findViewById(R.id.id_treenode_icon);
//			label = (TextView) convertView
//					.findViewById(R.id.id_treenode_name);
//			checkBox = (CheckBox)convertView.findViewById(R.id.id_treeNode_check);
//			if (node.getIcon() == -1)
//			{
//				icon.setVisibility(View.INVISIBLE);
//			} else
//			{
//				icon.setVisibility(View.VISIBLE);
//				icon.setImageResource(node.getIcon());
//			}
//
//			if(node.isHideChecked()){
//				checkBox.setVisibility(View.GONE);
//			}else{
//				checkBox.setVisibility(View.VISIBLE);
////			setCheckBoxBg(checkBox, node.isChecked());
//			}
//			checkBox.setChecked(node.isChecked());
//			label.setText(node.getName());
//			iconmap.put(position,icon);
//			labelmap.put(position,label);
//			checkBoxmap.put(position,checkBox);
//			map.put(position, convertView);
//		}

//		convertView = mInflater.inflate(R.layout.list_item_o, parent, false);
//		checkBox = (CheckBox)convertView.findViewById(R.id.id_treeNode_check);
//		label = (TextView) convertView
//				.findViewById(R.id.id_treenode_name);
//		icon = (ImageView) convertView
//				.findViewById(R.id.id_treenode_icon);
////		if(icon!=null){
////			icon = (ImageView) convertView
////					.findViewById(R.id.id_treenode_icon);
////		}
////		if(label!=null){
////			label = (TextView) convertView
////					.findViewById(R.id.id_treenode_name);
////		}
////		if(checkBox!=null){
////			checkBox = (CheckBox)convertView.findViewById(R.id.id_treeNode_check);
////		}
//		if (node.getIcon() == -1)
//		{
//			icon.setVisibility(View.INVISIBLE);
//		} else
//		{
//			icon.setVisibility(View.VISIBLE);
//			icon.setImageResource(node.getIcon());
//		}
//
//		if(node.isHideChecked()){
//			checkBox.setVisibility(View.GONE);
//		}else{
//			checkBox.setVisibility(View.VISIBLE);
////			setCheckBoxBg(checkBox, node.isChecked());
//		}
//		checkBox.setChecked(node.isChecked());
//		label.setText(node.getName());


		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.list_item_o, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_name);
			viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.id_treeNode_check);
			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (node.getIcon() == -1)
		{
			viewHolder.icon.setVisibility(View.INVISIBLE);
		} else
		{
			viewHolder.icon.setVisibility(View.VISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		}

		if(node.isHideChecked()){
			viewHolder.checkBox.setVisibility(View.GONE);
		}else{
			viewHolder.checkBox.setVisibility(View.VISIBLE);
//			if(isCheckeds.size()>0){
//				if(node.isChecked()==isCheckeds.get(position)){
//					viewHolder.checkBox.setChecked(node.isChecked());
//				}
//			}


		}
//		if(ischanges.get(position)!=null){
//			if(ischanges.get(position)){
//				if(node.isChecked()){
//					viewHolder.checkBox.setChecked(node.isChecked());
//				}
//			}else {
//				if(!node.isChecked()){
//					viewHolder.checkBox.setChecked(node.isChecked());
//				}
//			}
//		}else {
////			viewHolder.checkBox.setChecked(node.isChecked());
//		}

//		viewHolder.checkBox.setChecked(node.isChecked());

//		if(mAllNodes.get(position).isChecked()){
//			if(node.isChecked()){
//				viewHolder.checkBox.setChecked(node.isChecked());
//			}
//		}else {
//			if(!node.isChecked()){
//				viewHolder.checkBox.setChecked(node.isChecked());
//			}
//		}

		viewHolder.label.setText(node.getName());

		return convertView;
	}
	private final class ViewHolder
	{
		ImageView icon;
		TextView label;
		CheckBox checkBox;
	}
	
	/**
	 * checkbox是否显示
	 * @param cb
	 * @param isChecked
	 */
	private void setCheckBoxBg(CheckBox cb,boolean isChecked){
//		if(isChecked){
//			cb.setChecked(true);
//		}else{
//			cb.setChecked(false);
//		}
		if(isChecked){
			cb.setBackgroundResource(R.drawable.check_box_bg_check);
		}else{
			cb.setBackgroundResource(R.drawable.check_box_bg);
		}

	}

}
