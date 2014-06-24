package com.dan.swipeViewswithTabs;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    ViewPager mViewPager;
    CollectionPagerAdapter mColloctionPagerAdapter;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mColloctionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mColloctionPagerAdapter);
//        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//        public void onPageSelected(int pos){
//                getActionBar().setSelectedNavigationItem(pos);
//            }
//        });


//        final ActionBar actionBar = getActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
//            @Override
//            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//            }
//
//            @Override
//            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//            }
//        };
//
//        for (int i=0; i<3; ++i) {
//            actionBar.addTab(actionBar.newTab().setText("Tab"+i).setTabListener(tabListener));
//        }
    }

    public static class CollectionPagerAdapter extends FragmentStatePagerAdapter {
        public CollectionPagerAdapter (FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int i) {
            Fragment fragment = new ObjectFragment();
            Bundle args = new Bundle();
            args.putInt(ObjectFragment.ARG_OBJECT, i+1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public CharSequence getPageTitle(int pos) {
            return "O"+pos;
        }
    }

    public static class ObjectFragment extends Fragment {
        public static final String ARG_OBJECT = "object";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            Bundle args = getArguments();
            TextView textView = (TextView)rootView.findViewById(android.R.id.text1);
            textView.setText(Integer.toString(args.getInt(ARG_OBJECT)));
            return rootView;
        }
    }
}

