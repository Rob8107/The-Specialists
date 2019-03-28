package com.robgas.specialists.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robgas.specialists.R;
import com.robgas.specialists.Utils.ItemClickListener;
import com.robgas.specialists.data.Employee;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private List<Employee> mData = new ArrayList<>();
    private ItemClickListener<Specialty> itemClickListener;

    public EmployeeAdapter() {
    }

    public void setItemClickListener(ItemClickListener<Specialty> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Employee> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        viewHolder.bindTo(mData.get(pos), pos);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title1;
        public TextView title2;
        public TextView title3;

        public ViewHolder(View itemView) {
            super(itemView);
            title1 = (TextView) itemView.findViewById(R.id.title1);
            title2 = (TextView) itemView.findViewById(R.id.title2);
            title3 = (TextView) itemView.findViewById(R.id.title3);
        }

        public void bindTo(Employee item, int pos) {
            title1.setText(item.firstName + item.lastName);
            title2.setText(item.birthday);
            title3.setText(item.specialty.get(0).name);

        }
    }
}