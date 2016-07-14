package com.scu.charles.viewpageindicator;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.scu.charles.viewpageindicator.adater.RhythmAdapter;
import com.scu.charles.viewpageindicator.adater.StatePageAdapter;
import com.scu.charles.viewpageindicator.fragment.BaseFragment;
import com.scu.charles.viewpageindicator.fragment.FragmentPage1;
import com.scu.charles.viewpageindicator.fragment.FragmentPage2;
import com.scu.charles.viewpageindicator.fragment.FragmentPage3;
import com.scu.charles.viewpageindicator.fragment.FragmentPage4;
import com.scu.charles.viewpageindicator.fragment.FragmentPage5;
import com.scu.charles.viewpageindicator.widget.RhythmLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    RhythmLayout mRhythmLayout;
    List<BaseFragment> mFragments = new ArrayList<>(5);
    private static final int[] sChartColors={Color.parseColor("#26a69a"),Color.parseColor("#5c6bc0"),
            Color.parseColor("#42a5f5"), Color.parseColor("#4dd0e1"),Color.parseColor("#66bb6a")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册eventBus
        EventBus.getDefault().register(this);
        initData();
    }

    private void initData() {
        FragmentPage1 page1 = new FragmentPage1();
        FragmentPage2 page2 = new FragmentPage2();
        FragmentPage3 page3 = new FragmentPage3();
        FragmentPage4 page4 = new FragmentPage4();
        FragmentPage5 page5 = new FragmentPage5();
        mFragments.add(page1);
        mFragments.add(page2);
        mFragments.add(page3);
        mFragments.add(page4);
        mFragments.add(page5);
        mRhythmLayout = (RhythmLayout) findViewById(R.id.box_rhythm);
        RhythmAdapter adapter = new RhythmAdapter(this,sChartColors);
        mRhythmLayout.setAdapter(adapter);
        mViewPager = (ViewPager) findViewById(R.id.vp_view_page);
        mViewPager.setAdapter(new StatePageAdapter(getSupportFragmentManager(),mFragments));
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mRhythmLayout.showRhythmAtPosition(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //注意参数必须是对象，所以不能直接用int,要使用Integer
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceive(Integer mCurrentPosition){
        Log.i("mesage",mCurrentPosition+"ffffff");
        mViewPager.setCurrentItem(mCurrentPosition,true);
    }

    @Override
    protected void onDestroy() {
        //注册eventBus
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
