package com.example.tugas3_akb11_mochamadrifqi_10116470;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Gallery extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};

    private RecyclerAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_gallery);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images);
        recyclerView.setAdapter(adapter);

    }
}
