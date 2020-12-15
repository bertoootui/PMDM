package com.example.alberto_p1_pmdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> implements View.OnLongClickListener {

    Entrenamiento entrenamiento = new Entrenamiento();
    ArrayList<Entrenamiento> listaEntrenamiento;
    private View.OnLongClickListener listener;
    public Adapter(ArrayList<Entrenamiento> listaEntrenamiento) {
        this.listaEntrenamiento = listaEntrenamiento;
    }



    
    @NonNull
    @Override
    public Adapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        view.setOnLongClickListener(this);


        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolderDatos holder, int position) {

            holder.mDistancia.setText(listaEntrenamiento.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return listaEntrenamiento.size();
    }

    @Override
    public boolean onLongClick(View v) {
        if(listener!=null)
        {
            listener.onLongClick(v);
        }



        return false;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

            public TextView mDistancia;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            mDistancia = itemView.findViewById(R.id.txtview);
        }
    }//end ViewHolder
}//end Adapter
