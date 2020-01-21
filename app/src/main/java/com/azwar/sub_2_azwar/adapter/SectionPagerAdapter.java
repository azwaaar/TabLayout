package com.azwar.sub_2_azwar.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.azwar.sub_2_azwar.fragment.MovieFragment;
import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.fragment.TvShowFragment;
import java.util.ArrayList;
import java.util.List;

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;
    private final List<Fragment> fragmentsMovie = new ArrayList<>();
    private final List<Fragment> fragmentsTv = new ArrayList<>();

    public SectionPagerAdapter(@NonNull FragmentManager fm, Context mContext) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = mContext;
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_movie,
            R.string.tab_tvshow
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MovieFragment();
                fragmentsMovie.add(fragment);
                break;
            case 1:
                fragment = new TvShowFragment();
                fragmentsTv.add(fragment);
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
    public void addFragment (Fragment fragment){
        fragmentsTv.add( fragment );
        fragmentsMovie.add( fragment );
    }
}
