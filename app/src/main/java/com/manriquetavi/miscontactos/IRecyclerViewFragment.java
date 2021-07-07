package com.manriquetavi.miscontactos;

import java.util.ArrayList;

public interface IRecyclerViewFragment {
    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
