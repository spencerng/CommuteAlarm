package com.pennapps.xv.adoperari.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
=======
import android.support.v7.widget.Toolbar;
import android.view.Menu;
>>>>>>> 661bd3d73f95c624beef63f767497c48df7b1a00

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.Settings;
import com.pennapps.xv.adoperari.models.Time;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
       if(!Settings.getInstance(getBaseContext()).isSetup()){
=======

        /*if(!Settings.getInstance(getBaseContext()).isSetup()){
>>>>>>> 661bd3d73f95c624beef63f767497c48df7b1a00
            Intent i = new Intent(MainActivity.this, GetStartedActivity.class);
            startActivity(i);
            finish();
        }*/

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NextAlarmFragment(), "UPCOMING");
        adapter.addFragment(new ListAlarmFragment(), "ALARMS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

<<<<<<< HEAD

        /*final boolean[] days = {true,false,false,false,false,false,false};
        final TextView timeDisplay = (TextView) findViewById(R.id.test);
        final Time pennAppsDeadlne = new Time(8,0,0, days);


        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                timeDisplay.setText(pennAppsDeadlne.displayCountdown());

                            }
                        });
                    }
                } catch (InterruptedException e) {

                }
            }
        };

        t.start();*/




=======
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
>>>>>>> 661bd3d73f95c624beef63f767497c48df7b1a00
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;}
}
