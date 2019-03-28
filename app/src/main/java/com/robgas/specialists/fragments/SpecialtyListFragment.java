package com.robgas.specialists.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robgas.specialists.MainActivity;
import com.robgas.specialists.R;
import com.robgas.specialists.SpecialistApp;
import com.robgas.specialists.Utils.DBUtils;
import com.robgas.specialists.adapters.SpecialtyAdapter;
import com.robgas.specialists.data.Employee;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpecialtyListFragment extends Fragment {

    private SpecialtyListViewModel mViewModel;
    private RecyclerView recyclerView;
    private SpecialtyAdapter specialtyAdapter = new SpecialtyAdapter();

    public static SpecialtyListFragment newInstance() {
        return new SpecialtyListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.specialty_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.specialty_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(specialtyAdapter);
        specialtyAdapter.setItemClickListener((item, position) -> {
            if (getActivity() != null) {
                ((MainActivity) getActivity()).openFragment(EmployeeListFragment.newInstance(item.id), true);
            }
        });
        SpecialistApp.Instance().appDb.specialistDao().getSpecialistLiveData().observe(this, specialistEntities -> {
            if (specialistEntities != null) {

                HashSet<Specialty> hs = new HashSet<>();
                List<Employee> employees = DBUtils.getSpecialistMapper2(specialistEntities);
                for (Employee employee : employees) {
                    hs.addAll(employee.specialty);
                }

                ArrayList<Specialty> specialties = new ArrayList<>(hs);
                specialtyAdapter.setData(specialties);
                specialtyAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SpecialtyListViewModel.class);
        // TODO: Use the ViewModel
    }


}
