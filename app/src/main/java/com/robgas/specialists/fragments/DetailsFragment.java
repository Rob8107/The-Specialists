package com.robgas.specialists.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.robgas.specialists.R;
import com.robgas.specialists.data.Employee;

import java.util.Objects;

public class DetailsFragment extends Fragment {
    public static String DETAILSKEY = "DetailsFragment";

    public static DetailsFragment getInstance(Employee employee) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DETAILSKEY, employee);
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Employee employee = (Employee) Objects.requireNonNull(getArguments()).getSerializable(DETAILSKEY);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView firstName = view.findViewById(R.id.firstName);
        TextView lastName = view.findViewById(R.id.lastName);
        if (employee == null) {
            Objects.requireNonNull(getActivity()).onBackPressed();
        } else {
            Glide.with(this).load(employee.getAvatrUrl()).into(imageView);
            firstName.setText(employee.getFirstName());
            lastName.setText(employee.getLastName());
        }
    }
}
