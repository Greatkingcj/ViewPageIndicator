package com.scu.charles.viewpageindicator.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by charles on 2016/7/13.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected View rootView;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = initView(inflater);
        return rootView;
    }

    public View getRootView(){
        return rootView;
    }

    protected abstract View initView(LayoutInflater inflater);

    protected abstract void initData(Bundle savedInstanceState);
}
