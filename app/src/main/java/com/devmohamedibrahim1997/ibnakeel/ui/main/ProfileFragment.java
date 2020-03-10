package com.devmohamedibrahim1997.ibnakeel.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.databinding.FragmentProfileBinding;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import java.util.Objects;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding profileBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);
        return profileBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromSharedViewModel();
    }

    private void getDataFromSharedViewModel(){
        SharedViewModel sharedViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        sharedViewModel.getSuccessResponseLiveData().observe(getViewLifecycleOwner(), data -> {
            profileBinding.userName.setText(data.getStName());
            profileBinding.levelTextView2.setText(data.getLevel().getName());
            profileBinding.depTextView2.setText(data.getDepartment().getName());
            profileBinding.totalHoursTextView2.setText(String.valueOf(data.getHours()));
            profileBinding.totalGpaTextView2.setText(String.valueOf(data.getGpa()));
            profileBinding.totalGradeTextView2.setText(data.getGrade());
            profileBinding.doctorName2.setText(data.getStudentAutomaticRegister().getDoctorRegisterName());
            profileBinding.staffName2.setText(data.getStudentAutomaticRegister().getStaffRegisterName());
        });
    }
}