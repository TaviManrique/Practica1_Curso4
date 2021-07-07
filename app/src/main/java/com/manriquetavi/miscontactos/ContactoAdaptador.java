package com.manriquetavi.miscontactos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
    ArrayList<Contacto> contactos;
    Activity activity;
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewHolder para que el obtenga cada elemento(los views)
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }
    //Asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(ContactoAdaptador.ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        //holder.imgFoto.setImageResource(contacto.getFoto());
        //holder.tvCardNombre.setText(contacto.getNombre());
        //holder.tvCardCelular.setText(contacto.getCelular());;
        holder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " Likes");
        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url",contacto.getUrlFoto());
                intent.putExtra("likes",contacto.getLikes());
                //intent.putExtra("Celular",contactos.get(position).getCelular());
                //intent.putExtra("Email",contactos.get(position).getEmail());
                activity.startActivity(intent);
                //activity.finish();
            }
        });
        /*holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                holder.tvLikes.setText(constructorContactos.obtenerLikeContacto(contacto) + " Likes");
            }
        });*/
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        //private TextView tvCardNombre;
        //private TextView tvCardCelular;
        private ImageView imgLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgCardFoto);
            //tvCardNombre = (TextView) itemView.findViewById(R.id.tvCardNombre);
            //tvCardCelular = (TextView) itemView.findViewById(R.id.tvCardCelular);
            imgLike = (ImageView) itemView.findViewById(R.id.imgLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
