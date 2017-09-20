package com.example.lanshan.work_itsm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanshan.work_itsm.R;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by lanshan on 2017/9/20.
 */

public class LeftSlideFragment extends Fragment implements View.OnClickListener {
    public DrawerLayout drawer_layout;
    public FragmentManager fManager;
    public TextView tvSlideUser;
    public ImageView ivExit;
    public AutoLinearLayout llSlide_Todo,llSlide_CompletOrder,llSlide_Stastics,llSlide_Scan,llSlide_Query,llSlide_Polling;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_left, container, false);
        llSlide_Todo = (AutoLinearLayout)view.findViewById(R.id.llSlide_Todo);
        llSlide_CompletOrder = (AutoLinearLayout)view.findViewById(R.id.llSlide_CompletOrder);
        llSlide_Stastics = (AutoLinearLayout)view.findViewById(R.id.llSlide_Stastics);
        llSlide_Scan = (AutoLinearLayout)view.findViewById(R.id.llSlide_Scan);
        llSlide_Query = (AutoLinearLayout)view.findViewById(R.id.llSlide_Query);
        llSlide_Polling = (AutoLinearLayout)view.findViewById(R.id.llSlide_Polling);
        tvSlideUser = (TextView) view.findViewById(R.id.tvSlideUser);
        ivExit = (ImageView) view.findViewById(R.id.ivExit);
        llSlide_Todo.setOnClickListener(this);
        llSlide_CompletOrder.setOnClickListener(this);
        llSlide_Stastics.setOnClickListener(this);
        llSlide_Scan.setOnClickListener(this);
        llSlide_Query.setOnClickListener(this);
        llSlide_Polling.setOnClickListener(this);
        ivExit.setOnClickListener(this);
        fManager = getActivity().getSupportFragmentManager();
        return view;
    }
    public void setDrawerLayout(DrawerLayout drawer_layout,String User){
        this.drawer_layout = drawer_layout;
        tvSlideUser.setText(User);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.llSlide_Todo:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.llSlide_CompletOrder:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.llSlide_Stastics:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.llSlide_Scan:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.llSlide_Query:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.ivExit:
                drawer_layout.closeDrawer(Gravity.START);
                break;
            case R.id.llSlide_Polling:
                drawer_layout.closeDrawer(Gravity.START);
                break;
        }
    }
}
