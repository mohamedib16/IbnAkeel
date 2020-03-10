package com.devmohamedibrahim1997.ibnakeel.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.adapter.RegisterCoursesAdapter;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.CoursesToRegisterLevel1;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import java.util.List;

public class RegisteredCoursesFragment extends Fragment {

    private RegisterCoursesAdapter registerCoursesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registered_courses, container, false);

        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView registeredCoursesRecyclerView = view.findViewById(R.id.registeredCoursesRecyclerView);
        registeredCoursesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        registeredCoursesRecyclerView.setHasFixedSize(true);
        registerCoursesAdapter = new RegisterCoursesAdapter(getContext());
        registeredCoursesRecyclerView.setAdapter(registerCoursesAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromSharedViewModel();
    }

    private void getDataFromSharedViewModel(){
        SharedViewModel sharedViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        sharedViewModel.getSuccessResponseLiveData().observe(getViewLifecycleOwner(), data -> {
            List<CoursesToRegisterLevel1> coursesToRegisterLevel1 = data.getStudentAutomaticRegister().getCoursesToRegisterLevel1();
            registerCoursesAdapter.setRegisteredCourses(coursesToRegisterLevel1);
        });
    }
}
