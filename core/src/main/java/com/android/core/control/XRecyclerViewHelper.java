package com.android.core.control;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:36
 */
public class XRecyclerViewHelper {

    static XRecyclerViewHelper ourInstance;

    public XRecyclerViewHelper() {

    }

//    public static XRecyclerViewHelper init() {
//        if (ourInstance == null)
//            ourInstance = new XRecyclerViewHelper();
//        return ourInstance;
//    }
//
//
//    public void setLinearLayout(Context context, XRecyclerView mRecy) {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecy.setLayoutManager(layoutManager);
//        mRecy.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        mRecy.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
//        mRecy.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
//        //设置分隔线
//        mRecy.addItemDecoration(new RecycleViewDivider(
//                context,
//                LinearLayoutManager.HORIZONTAL,
//                R.drawable.divider_mileage));
//    }
//
//    public void setLinearLayoutH(Context context, XRecyclerView mRecy) {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecy.setLayoutManager(layoutManager);
//        //设置分隔线
////        mRecy.addItemDecoration(new SpacesItemDecoration(1));
//        mRecy.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        mRecy.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
//        mRecy.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
//    }

}
