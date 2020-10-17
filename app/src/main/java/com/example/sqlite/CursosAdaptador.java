package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CursosAdaptador extends RecyclerView.Adapter<CursosAdaptador.ViewHolder> {
     public static class ViewHolder extends RecyclerView.ViewHolder{
         private TextView codigo,curso,carrera;
         public ViewHolder(View itemView) {
             super(itemView);
             codigo=(TextView)itemView.findViewById(R.id.tveCodigo);
             curso=(TextView)itemView.findViewById(R.id.tveCurso);
             carrera=(TextView)itemView.findViewById(R.id.tveCarrera);
         }
     }
     public List<CursosModelo> cursoLista;

    public CursosAdaptador(List<CursosModelo> cursoLista) {
        this.cursoLista = cursoLista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.codigo.setText(cursoLista.get(position).getCodigo());
        holder.curso.setText(cursoLista.get(position).getCurso());
        holder.carrera.setText(cursoLista.get(position).getCarrera());

    }

    @Override
    public int getItemCount() {
        return cursoLista.size();
    }
}
