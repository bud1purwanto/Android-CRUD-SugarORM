package com.putraprima.ppmsqliteexamplefirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.putraprima.ppmsqliteexamplefirst.adapter.PengarangAdapter;
import com.putraprima.ppmsqliteexamplefirst.models.Pengarang;

import java.util.ArrayList;
import java.util.List;

public class DaftarPengarang extends AppCompatActivity {
    private PengarangAdapter mAdapter;
    private List<Pengarang> mDaftarPengarang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pengarang);
        mDaftarPengarang = Pengarang.listAll(Pengarang.class);

        RecyclerView recyclerPengarang = (RecyclerView) findViewById(R.id.recyclerPengarang);
        mAdapter = new PengarangAdapter(getApplicationContext(),mDaftarPengarang);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPengarang.setLayoutManager(mLayoutManager);
        recyclerPengarang.setItemAnimator(new DefaultItemAnimator());
        recyclerPengarang.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
