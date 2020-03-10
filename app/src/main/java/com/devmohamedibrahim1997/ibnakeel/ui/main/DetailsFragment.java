package com.devmohamedibrahim1997.ibnakeel.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.adapter.DetailsAdapter;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import java.util.Objects;

public class DetailsFragment extends Fragment{

    private DetailsAdapter detailsAdapter;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        initRecyclerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromSharedViewModel();
    }

    private void getDataFromSharedViewModel(){
        sharedViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        sharedViewModel.getWeeksLiveData().observe(getViewLifecycleOwner(), weeks -> detailsAdapter.setWeeks(weeks));
    }

    private void initRecyclerView(View view) {
        RecyclerView detailRecyclerView = view.findViewById(R.id.details_recyclerview);
        detailRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailRecyclerView.setHasFixedSize(true);

        detailsAdapter = new DetailsAdapter(getContext());
        detailRecyclerView.setAdapter(detailsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sharedViewModel.setActionBarTitle("app_name");
    }
}
