package com.example.marketlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<String> itensList = new ArrayList<String>();
        itensList.add("Feijão");
        itensList.add("Feijão");
        itensList.add("Feijão");
        itensList.add("Feijão");
        itensList.add("Feijão");

        ProductListAdapter adapter = new ProductListAdapter(itensList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(adapter);
    }
}