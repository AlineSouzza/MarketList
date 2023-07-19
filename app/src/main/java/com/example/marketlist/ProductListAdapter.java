package com.example.marketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private final ArrayList<String> itensList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final TextView textView;
        private final ImageView delete;
        private final ImageView edit;
        private final EditText editText;

        private ProductListActivity activity = new ProductListActivity();
        ViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.cb_item);
            textView = (TextView) itemView.findViewById(R.id.name_product);
            delete = (ImageView) itemView.findViewById(R.id.delete_view);
            edit = (ImageView) itemView.findViewById(R.id.edit_view);
            editText = (EditText) itemView.findViewById(R.id.edit_item);
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getDelete() {
            return delete;
        }

        public ImageView getEdit() {
            return edit;
        }
        public EditText getEditText() {
            return editText;
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
        holder.getDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itensList.remove(holder.getAdapterPosition());

                notifyDataSetChanged();
            }
        });

        holder.getEdit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itensList.get(holder.getAdapterPosition());

                Button saveButton;
                Button cancelButton;

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Edição");
                final View customLayout
                        = LayoutInflater.from(v.getContext()).inflate(
                        R.layout.dialog_edit_item,
                        null);

                builder.setView(customLayout);

                cancelButton = customLayout.findViewById(R.id.cancel_btn);
                saveButton = customLayout.findViewById(R.id.save_button);
                EditText editText = customLayout.findViewById(R.id.edit_item);

                AlertDialog dialog = builder.create();

                editText.setText(itensList.get(holder.getAdapterPosition()));
                dialog.show();

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editItem = editText.getText().toString();
                        itensList.set(holder.getAdapterPosition(), editItem);

                        if (editItem.isEmpty()) return;

                        dialog.dismiss();

                        notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return itensList.size();
    }
}
