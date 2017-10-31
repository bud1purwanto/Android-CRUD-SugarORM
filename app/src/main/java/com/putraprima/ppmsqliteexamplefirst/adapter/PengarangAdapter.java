package com.putraprima.ppmsqliteexamplefirst.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.putraprima.ppmsqliteexamplefirst.DaftarPengarang;
import com.putraprima.ppmsqliteexamplefirst.DetailPengarang;
import com.putraprima.ppmsqliteexamplefirst.R;
import com.putraprima.ppmsqliteexamplefirst.models.Pengarang;

import java.util.List;

/**
 * Created by root on 10/30/17.
 */

public class PengarangAdapter extends RecyclerView.Adapter<PengarangAdapter.PengarangViewHolder>{
    private Context context;
    private List<Pengarang> listPengarang;

    public PengarangAdapter(Context context, List<Pengarang> listPengarang) {
        this.context = context;
        this.listPengarang = listPengarang;
    }

    @Override
    public PengarangAdapter.PengarangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengarang,parent,false);
        return new PengarangAdapter.PengarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PengarangAdapter.PengarangViewHolder holder, int position) {
        final Pengarang pengarang = listPengarang.get(position);
        holder.namaPengarang.setText(pengarang.getNama());
        holder.namaPengarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),pengarang.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DetailPengarang.class);
                i.putExtra("pengarangId",pengarang.getId());
                view.getContext().startActivity(i);
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),pengarang.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarPengarang.class);
                i.putExtra("pengarangId",pengarang.getId());
                Long idPen = i.getLongExtra("pengarangId",0L);
                Pengarang deletePen = Pengarang.findById(Pengarang.class,idPen);
                deletePen.delete();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPengarang.size();
    }

    public class PengarangViewHolder extends RecyclerView.ViewHolder {
        public TextView namaPengarang;
        public Button btndelete, btnupdate;
        public PengarangViewHolder(View itemView) {
            super(itemView);
            namaPengarang = itemView.findViewById(R.id.namaPengarang);
            btndelete = itemView.findViewById(R.id.button);
            btnupdate = itemView.findViewById(R.id.buttonUpdate);
        }
    }
}
