package com.azwar.sub_2_azwar.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.adapter.SectionPagerAdapter;
import com.azwar.sub_2_azwar.fragment.MovieFragment;
import com.azwar.sub_2_azwar.fragment.TvShowFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    SectionPagerAdapter sectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        viewPager.setAdapter(sectionPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),this);
        sectionPagerAdapter.addFragment(new MovieFragment());
        sectionPagerAdapter.addFragment(new TvShowFragment());
        viewPager.setAdapter(sectionPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings){
            Intent mIntent = new Intent( Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
