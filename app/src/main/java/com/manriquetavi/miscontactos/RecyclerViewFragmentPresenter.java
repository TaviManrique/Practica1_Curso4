package com.manriquetavi.miscontactos;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        /*
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactoRV();
         */
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorMedia();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();
        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                if (!response.isSuccessful()) {
                    Log.e("Error", "Error " + response.code());
                    Toast.makeText(context, "Error response is not successful", Toast.LENGTH_SHORT).show();

                }
                else {
                    ContactoResponse contactoResponse = response.body();
                    contactos = contactoResponse.getContactos();
                    mostrarContactoRV();
                }
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Error conexion web service intenta de nuevo mas tarde", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION",t.toString());
            }
        });

    }

    @Override
    public void mostrarContactoRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(contactos));
        iRecyclerViewFragment.generarGridLayout();
    }

}
