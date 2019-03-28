package com.robgas.specialists.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robgas.specialists.R;
import com.robgas.specialists.data.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private List<Employee> mData = new ArrayList<>();
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public EmployeeAdapter() {
    }


    public void setData(List<Employee> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        viewHolder.bindTo(mData.get(pos), pos);
        viewHolder.itemView.setOnClickListener((v) -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClickListener(mData.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClickListener(Employee employee);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title1;
        public TextView title2;
        public TextView title3;

        public ViewHolder(View itemView) {
            super(itemView);
            title1 = itemView.findViewById(R.id.title1);
            title2 = itemView.findViewById(R.id.title2);
            title3 = itemView.findViewById(R.id.title3);
        }

        public void bindTo(Employee item, int pos) {
            title1.setText(item.getFirstName() + item.getLastName());
            title2.setText(item.getBirthday());
            title3.setText(item.getSpecialty().get(0).name);

        }
    }
}