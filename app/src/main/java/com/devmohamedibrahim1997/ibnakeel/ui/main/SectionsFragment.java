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
import com.devmohamedibrahim1997.ibnakeel.adapter.SectionsAdapter;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.AbsenseSection;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.Week;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import java.util.List;
import java.util.Objects;

public class SectionsFragment extends Fragment implements SectionsAdapter.ClickInterface {
    private SectionsAdapter sectionsAdapter;
    private List<AbsenseSection> absenseSections;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sections, container, false);

        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView sectionsRecyclerView = view.findViewById(R.id.sectionsRecyclerview);
        sectionsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        sectionsAdapter = new SectionsAdapter(getContext(),this);
        sectionsRecyclerView.setAdapter(sectionsAdapter);
        sectionsRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromSharedViewModel();
    }

    private void getDataFromSharedViewModel(){
        sharedViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        sharedViewModel.getSuccessResponseLiveData().observe(getViewLifecycleOwner(), data -> {
            absenseSections =  data.getListAbsenseReport().getAbsenseSections();
            sectionsAdapter.setSections(absenseSections);
        });
    }

    @Override
    public void onItemClicked(int position) {
        List<Week> weeks = absenseSections.get(position).getWeeks();
        String courseName = absenseSections.get(position).getCourse().getName();
        courseName = courseName + " - سكشن";

        sharedViewModel.setWeeks(weeks);
        sharedViewModel.setActionBarTitle(courseName);

        sharedViewModel.setWeeks(weeks);
        sharedViewModel.setActionBarTitle(courseName);

        getParentFragmentManager().beginTransaction().add(R.id.main_fragment_container,
                new DetailsFragment()).addToBackStack("tag").commit();
    }
}