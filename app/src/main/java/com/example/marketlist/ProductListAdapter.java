package com.example.marketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private ArrayList<String> itensList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final TextView textView;
        ViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.cb_item);
            textView = (TextView) itemView.findViewById(R.id.name_product);
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public ProductListAdapter(ArrayList<String> itensList) {
        this.itensList = itensList;
    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(itensList.get(position));
    }

    @Override
    public int getItemCount() {
        return itensList.size();
    }
}
