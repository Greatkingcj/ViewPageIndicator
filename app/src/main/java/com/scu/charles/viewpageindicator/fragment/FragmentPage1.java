package com.scu.charles.viewpageindicator.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.scu.charles.viewpageindicator.R;

/**
 * Created by charles on 2016/7/13.
 */
public class FragmentPage1 extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_one,null);
        return view;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
