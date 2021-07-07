package com.manriquetavi.miscontactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvContactos = (RecyclerView) v.findViewById(R.id.rvContacto);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaContatos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Tavi Manrique","+51 9584708","u201412767@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Edxel Jogues","+51 902641002","u20191a369@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Rodrigo Eyzaguirre","+51 992904564","u201411182@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Samuel Calixto","+51 942874148","u20151B709@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Bryan Sandoval","+51 941919843","u201510423@upc.edu.pe", R.drawable.photo));

    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager glm = GridLayoutManager(this,2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
