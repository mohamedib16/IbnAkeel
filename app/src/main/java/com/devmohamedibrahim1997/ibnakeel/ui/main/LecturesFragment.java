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
import com.devmohamedibrahim1997.ibnakeel.adapter.LecturesAdapter;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.AbsenseLecture;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.Week;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import java.util.List;
import java.util.Objects;

public class LecturesFragment extends Fragment implements LecturesAdapter.ClickInterface {
    private LecturesAdapter lecturesAdapter;
    private List<AbsenseLecture> absenseLectures;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lectures, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView lecturesRecyclerView = view.findViewById(R.id.lecturesRecyclerView);
        lecturesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        lecturesAdapter = new LecturesAdapter(getContext(),this);
        lecturesRecyclerView.setAdapter(lecturesAdapter);
        lecturesRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromSharedViewModel();
    }

    private void getDataFromSharedViewModel(){
        sharedViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        sharedViewModel.getSuccessResponseLiveData().observe(getViewLifecycleOwner(), data -> {
            absenseLectures = data.getListAbsenseReport().getAbsenseLectures();
            lecturesAdapter.setLectures(absenseLectures);
        });
    }

    @Override
    public void onItemClicked(int position) {
        List<Week> weeks = absenseLectures.get(position).getWeeks();
        String courseName = absenseLectures.get(position).getCourse().getName();
        courseName = courseName + " - محاضرة";

        sharedViewModel.setWeeks(weeks);
        sharedViewModel.setActionBarTitle(courseName);

        getParentFragmentManager().beginTransaction().add(R.id.main_fragment_container,
                new DetailsFragment()).addToBackStack("tag").commit();
    }
}