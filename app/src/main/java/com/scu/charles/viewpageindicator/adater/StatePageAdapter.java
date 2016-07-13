package com.scu.charles.viewpageindicator.adater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.scu.charles.viewpageindicator.fragment.BaseFragment;

import java.util.List;

/**
 * Created by charles on 2016/7/13.
 */
public class StatePageAdapter extends FragmentStatePagerAdapter{
    private List<BaseFragment> mBaseFragments;
    public StatePageAdapter(FragmentManager fm, List<BaseFragment> mBaseFragments){
        super(fm);
        this.mBaseFragments = mBaseFragments;
    }
    @Override
    public Fragment getItem(int position) {
        return mBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBaseFragments.size();
    }
}
