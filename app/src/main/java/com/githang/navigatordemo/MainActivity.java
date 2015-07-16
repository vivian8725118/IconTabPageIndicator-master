package com.githang.navigatordemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.githang.navigatordemo.fragments.BaseFragment;
import com.githang.navigatordemo.fragments.RefreshLayoutFragment;
import com.githang.viewpagerindicator.IconPagerAdapter;
import com.githang.viewpagerindicator.IconTabPageIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private IconTabPageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();//去掉actionbar

        initViews();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIndicator = (IconTabPageIndicator) findViewById(R.id.indicator);
        List<BaseFragment> fragments = initFragments();
        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mIndicator.setViewPager(mViewPager);
    }

    private List<BaseFragment> initFragments() {
        List<BaseFragment> fragments = new ArrayList<BaseFragment>();
        String[] tabs = getResources().getStringArray(R.array.tabs);

        RefreshLayoutFragment refreshLayoutFragment = new RefreshLayoutFragment();
        refreshLayoutFragment.setTitle(tabs[0]);
        refreshLayoutFragment.setIconId(R.drawable.tab_user_selector);
        fragments.add(refreshLayoutFragment);

        BaseFragment noteFragment = new BaseFragment();
        noteFragment.setTitle(tabs[1]);
        noteFragment.setIconId(R.drawable.tab_record_selector);
        fragments.add(noteFragment);

        BaseFragment contactFragment = new BaseFragment();
        contactFragment.setTitle(tabs[2]);
        contactFragment.setIconId(R.drawable.tab_user_selector);
        fragments.add(contactFragment);

        BaseFragment recordFragment = new BaseFragment();
        recordFragment.setTitle(tabs[3]);
        recordFragment.setIconId(R.drawable.tab_record_selector);
        fragments.add(recordFragment);

        BaseFragment fourthFragment = new BaseFragment();
        fourthFragment.setTitle(tabs[4]);
        fourthFragment.setIconId(R.drawable.icon_record_normal);
        fragments.add(fourthFragment);
        return fragments;
    }

    class FragmentAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(List<BaseFragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getIconResId(int index) {
            return mFragments.get(index).getIconId();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getTitle();
        }
    }

}
