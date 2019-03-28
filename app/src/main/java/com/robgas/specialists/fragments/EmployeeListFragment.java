package com.robgas.specialists.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robgas.specialists.R;
import com.robgas.specialists.SpecialistApp;
import com.robgas.specialists.Utils.DBUtils;
import com.robgas.specialists.adapters.EmployeeAdapter;
import com.robgas.specialists.data.Employee;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListFragment extends Fragment {
    public static final String EXTRA_SPECIALTY_ID = "EXTRA_SPECIALTY_ID";
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter = new EmployeeAdapter();

    public static EmployeeListFragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_SPECIALTY_ID, id);
        EmployeeListFragment employeeListFragment = new EmployeeListFragment();
        employeeListFragment.setArguments(bundle);
        return employeeListFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.employee_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.specialty_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(employeeAdapter);
        employeeAdapter.setItemClickListener((item, position) -> {
            if (getActivity() != null) {
//                    ((MainActivity) getActivity()).openFragment();
            }
        });

        int specialtyId = -1;
        if (getArguments() != null && getArguments().containsKey(EXTRA_SPECIALTY_ID)) {
            specialtyId = getArguments().getInt(EXTRA_SPECIALTY_ID, -1);
        }


        if (specialtyId != -1) {
            int finalSpecialtyId = specialtyId;
            SpecialistApp.Instance().appDb.specialistDao().getSpecialistLiveData().observe(this, specialistEntities -> {
                if (specialistEntities != null) {
                    List<Employee> data = DBUtils.getSpecialistMapper2(specialistEntities);
                    ArrayList<Employee> employes = new ArrayList<>();
                    for (Employee item : data) {
                        if (item.specialty.contains(new Specialty(finalSpecialtyId))) {
                            employes.add(item);
                        }
                    }

                    employeeAdapter.setData(employes);
                    employeeAdapter.notifyDataSetChanged();
                }
            });
        }

    }

}
