/**
 * @Title: TreeListViewAdapter.java
 * @Package com.sloop.treeview.utils.adapter
 * Copyright: Copyright (c) 2015
 * @author sloop
 * @date 2015年2月22日 上午1:16:25
 * @version V1.0
 */

package com.android.core.widget.treeview.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.core.utils.Utils;
import com.android.core.widget.treeview.utils.OtherNode;
import com.android.core.widget.treeview.utils.TreeHelperOther;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sloop
 * @ClassName: TreeListViewAdapter
 * @date 2015年2月22日 上午1:16:25
 */

public abstract class TreeListViewOtherAdapter<T> extends BaseAdapter {

    protected Context mContext;

    /**
     * 存储所有可见的Node
     */
    protected List<OtherNode> mNodes;
    protected LayoutInflater mInflater;
    public List<Boolean> isCheckeds = new ArrayList<>();
    /**
     * 存储所有的Node
     */
    protected List<OtherNode> mAllNodes;

    /**
     * 点击的回调接口
     */
    private OnTreeNodeClickListener onTreeNodeClickListener;

    public interface OnTreeNodeClickListener {
        /**
         * 处理node click事件
         *
         * @param node
         * @param position
         */
        void onClick(OtherNode node, int position);

        /**
         * 处理checkbox选择改变事件
         *
         * @param node
         * @param position
         * @param checkedNodes
         */
        void onCheckChange(OtherNode node, int position, List<OtherNode> checkedNodes);
    }

    public void setOnTreeNodeClickListener(
            OnTreeNodeClickListener onTreeNodeClickListener) {
        this.onTreeNodeClickListener = onTreeNodeClickListener;
    }

    /**
     * @param mTree
     * @param context
     * @param datas
     * @param defaultExpandLevel 默认展开几级树
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public TreeListViewOtherAdapter(ListView mTree, Context context, List<T> datas,
                                    int defaultExpandLevel, boolean isHide)
            throws IllegalArgumentException, IllegalAccessException {
        mContext = context;
        /**
         * 对所有的Node进行排序
         */
        mAllNodes = TreeHelperOther
                .getSortedNodes(datas, defaultExpandLevel, isHide);
        /**
         * 过滤出可见的Node
         */
        mNodes = TreeHelperOther.filterVisibleNode(mAllNodes);
        mInflater = LayoutInflater.from(context);

        /**
         * 设置节点点击时，可以展开以及关闭；并且将ItemClick事件继续往外公布
         */
        mTree.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                expandOrCollapse(position);

                if (onTreeNodeClickListener != null) {
                    onTreeNodeClickListener.onClick(mNodes.get(position),
                            position);
                }
            }

        });

    }

    public void clearList() {
        if (!Utils.isEmpty(mAllNodes)) {
            for (int i = 0; i < mAllNodes.size(); i++) {
                mAllNodes.get(i).setChecked(false);
            }
        }
    }

    /**
     * 相应ListView的点击事件 展开或关闭某节点
     *
     * @param position
     */

    public void expandOrCollapse(int position) {
        OtherNode n = mNodes.get(position);

        if (n != null)// 排除传入参数错误异常
        {
            if (!n.isLeaf()) {
                n.setExpand(!n.isExpand());
                mNodes = TreeHelperOther.filterVisibleNode(mAllNodes);
                notifyDataSetChanged();// 刷新视图
            }
        }
    }

    boolean isRootClick = false;

    @Override
    public int getCount() {
        return mNodes.size();
    }

    @Override
    public Object getItem(int position) {
        return mNodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final OtherNode node = mNodes.get(position);

        convertView = getConvertView(node, position, convertView, parent);
        // 设置内边距
        convertView.setPadding(node.getLevel() * 30, 3, 3, 3);
        if (!node.isHideChecked()) {
            //获取各个节点所在的父布局
            RelativeLayout myView = (RelativeLayout) convertView;
            //父布局下的CheckBox
            CheckBox cb = (CheckBox) myView.getChildAt(1);
            cb.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (node.isRoot()) {
                        isRootClick = true;
                    } else {
                        isRootClick = false;
                    }
                    return false;
                }
            });
//            cb.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(node.isRoot()){
//                        isRootClick = true;
//                    }else {
//                        isRootClick = false;
//                    }
//                }
//            });
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    TreeHelperOther.setNodeChecked(node, isChecked, isRootClick);
                    List<OtherNode> checkedNodes = new ArrayList<OtherNode>();
                    for (OtherNode n : mAllNodes) {
                        if (n.isChecked()) {
                            checkedNodes.add(n);
                        }
                    }
                    isCheckeds.clear();
                    for (int i = 0; i < mNodes.size(); i++) {
                        isCheckeds.add(mNodes.get(i).isChecked());
                    }
                    onTreeNodeClickListener.onCheckChange(node, position, checkedNodes);
                    TreeListViewOtherAdapter.this.notifyDataSetChanged();
                }

            });
            cb.setChecked(mNodes.get(position).isChecked());
        }


        return convertView;
    }

    public abstract View getConvertView(OtherNode node, int position,
                                        View convertView, ViewGroup parent);

    /**
     * 更新
     *
     * @param isHide
     */
    public void updateView(boolean isHide) {
        for (OtherNode node : mAllNodes) {
            node.setHideChecked(isHide);
        }

        this.notifyDataSetChanged();
    }
}
