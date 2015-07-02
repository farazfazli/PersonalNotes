package com.farazfazli.personalnotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 6/25/15
 */
public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(AppSharedPreferences.hasUserLearned(getActivity(),
                AppConstant.KEY_USER_LEARNED_DRAWER, AppConstant.FALSE));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        View containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (slideOffset < 0.6) {
                    toolbar.setAlpha(1 - slideOffset / 2);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    AppSharedPreferences.setUserLearned(getActivity(),
                            AppConstant.KEY_USER_LEARNED_DRAWER, AppConstant.TRUE);
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                AppSharedPreferences.setUserLearned(getActivity(),
                        AppConstant.KEY_USER_LEARNED_DRAWER, AppConstant.TRUE);

            }
        };

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

}