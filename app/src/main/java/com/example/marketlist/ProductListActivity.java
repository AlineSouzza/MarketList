package com.example.marketlist;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ArrayList<String> itensList;
    private ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ImageView imageView = findViewById(R.id.image_view);
        EditText editText = findViewById(R.id.edit_text);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoItem = editText.getText().toString();

                if (novoItem.isEmpty()) return;

                itensList.add(novoItem);

                editText.getText().clear();

                adapter.notifyDataSetChanged();
            }
        });

        itensList = new ArrayList<String>();

        adapter = new ProductListAdapter(itensList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(adapter);
    }
}