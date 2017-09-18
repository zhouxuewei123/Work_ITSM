package com.android.core.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.core.R;

import java.util.List;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:34
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    //如果包含有下拉刷新时，getPosition需要-1(即使用XRecyclerView时)
//    protected int reduce;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;

    }

    public RecyclerAdapter(Context context, int layoutId, List<T> datas) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
        this.mDatas = datas;
//        this.reduce = reduce;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder = RecyclerViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }


    protected void setListener(final ViewGroup parent, final RecyclerViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
//                    if(mDatas.size()==0){
//                        mDatas.add((T) "000000");
//                    }
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);

                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemView.setBackgroundResource(R.drawable.recycler_bg);
        holder.updatePosition(position);
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(RecyclerViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mDatas.size() != 0 ? mDatas.size() : 0;
    }


    public interface OnItemClickListener<T> {
        void onItemClick(ViewGroup parent, View view, T t, int position);

        boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
    }

    public T getDatas(int position){
        return mDatas.get(position);
    }

    public void setDatas(List<T> position){
        this.mDatas = position;
    }
}