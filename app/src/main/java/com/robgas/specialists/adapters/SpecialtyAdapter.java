package com.robgas.specialists.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robgas.specialists.R;
import com.robgas.specialists.Utils.ItemClickListener;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.List;

public class SpecialtyAdapter extends RecyclerView.Adapter<SpecialtyAdapter.ViewHolder> {
    private ItemClickListener<Specialty> itemClickListener;

    private List<Specialty> mData = new ArrayList<>();

    public SpecialtyAdapter() {

    }

    public void setItemClickListener(ItemClickListener<Specialty> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Specialty> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialty_list_item, parent, false);
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
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void bindTo(Specialty responseItem, int pos) {
            title.setText(responseItem.name);
            itemView.setOnClickListener(v -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(responseItem, pos);
                }
            });
        }
    }

}