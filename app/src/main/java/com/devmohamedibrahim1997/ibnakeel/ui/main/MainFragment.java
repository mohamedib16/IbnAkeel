package com.devmohamedibrahim1997.ibnakeel.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.adapter.PagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        if(savedInstanceState == null) {
            getParentFragmentManager().beginTransaction().replace(R.id.inside_main_fragment_container, new ProfileFragment()).commit();
        }

        initBottomNavigationView(view);
        initViewPager(view);

        return view;
    }

    private void initBottomNavigationView(View view) {
        bottomNavigationView = view.findViewById(R.id.mainBottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile_tab:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.register_courses_tab:
                        fragment = new RegisteredCoursesFragment();
                        break;
                    case R.id.sections_tab:
                        fragment = new SectionsFragment();
                        break;
                    case R.id.lectures_tab:
                        fragment = new LecturesFragment();
                        break;
                }
                getParentFragmentManager().beginTransaction().replace(R.id.inside_main_fragment_container, fragment).commit();
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(menuItem -> {
        });
    }

    private void initViewPager(View view) {
        ViewPager mainViewPager = view.findViewById(R.id.main_viewpager);
        mainViewPager.setAdapter(new PagerAdapter(getParentFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        mainViewPager.addOnPageChangeListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.profile_tab:
                    mainViewPager.setCurrentItem(0, true);
                    break;

                case R.id.register_courses_tab:
                    mainViewPager.setCurrentItem(1, true);
                    break;

                case R.id.lectures_tab:
                    mainViewPager.setCurrentItem(2, true);
                    break;

                case R.id.sections_tab:
                    mainViewPager.setCurrentItem(3, true);
                    break;
            }

            return true;
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        switch(position){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.profile_tab);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.register_courses_tab);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.lectures_tab);
                break;

            case 3:
                bottomNavigationView.setSelectedItemId(R.id.sections_tab);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
