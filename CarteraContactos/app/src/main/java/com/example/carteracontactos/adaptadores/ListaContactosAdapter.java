package com.example.carteracontactos.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carteracontactos.R;
import com.example.carteracontactos.entidades.Contactos;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {
    ArrayList<Contactos> listaContactos;
    public  ListaContactosAdapter(ArrayList<Contactos> listaContactos){
        this.listaContactos=listaContactos;
    }
    @NonNull

    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto,null,false);
        return  new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ContactoViewHolder holder, int position) {
        holder.viewNombre.setText(listaContactos.get(position).getNombre());
        holder.viewDireccion.setText(listaContactos.get(position).getDireccion());
        holder.viewCorreo.setText(listaContactos.get(position).getCorreo_electronico());
        holder.viewTelefono.setText(listaContactos.get(position).getTelefono());


    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewDireccion,viewCorreo,viewTelefono;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNomnbre);
            viewDireccion = itemView.findViewById(R.id.viewDireccion);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
        }
    }
}
