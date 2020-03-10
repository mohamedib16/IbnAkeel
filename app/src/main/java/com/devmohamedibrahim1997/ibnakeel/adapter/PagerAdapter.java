package com.devmohamedibrahim1997.ibnakeel.adapter;
import com.devmohamedibrahim1997.ibnakeel.ui.main.LecturesFragment;
import com.devmohamedibrahim1997.ibnakeel.ui.main.ProfileFragment;
import com.devmohamedibrahim1997.ibnakeel.ui.main.RegisteredCoursesFragment;
import com.devmohamedibrahim1997.ibnakeel.ui.main.SectionsFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private static final int PROFILE_FRAGMENT = 0;
    private static final int REGISTERED_FRAGMENT = 1;
    private static final int LECTURES_FRAGMENT = 2;
    private static final int SECTIONS_FRAGMENT = 3;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case PROFILE_FRAGMENT: {fragment = new ProfileFragment(); break;}
            case REGISTERED_FRAGMENT:{fragment = new RegisteredCoursesFragment(); break;}
            case LECTURES_FRAGMENT:{fragment = new LecturesFragment(); break;}
            case SECTIONS_FRAGMENT:{fragment = new SectionsFragment(); break;}
            default: fragment = new ProfileFragment(); break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
