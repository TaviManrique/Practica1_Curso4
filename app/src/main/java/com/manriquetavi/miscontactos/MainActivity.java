package com.manriquetavi.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        setUpViewPager();


        /*
        ArrayList<String> nombresContacto = new ArrayList<>();
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Tavi Manrique","+51 9584708","u201412767@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Edxel Jogues","+51 902641002","u20191a369@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Rodrigo Eyzaguirre","+51 992904564","u201411182@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Samuel Calixto","+51 942874148","u20151B709@upc.edu.pe", R.drawable.photo));
        contactos.add(new Contacto("Bryan Sandoval","+51 941919843","u201510423@upc.edu.pe", R.drawable.photo));
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }*/
        /*
        ListView lstContacto = (ListView) findViewById(R.id.lstContactos);
        lstContacto.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));
        lstContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("Nombre",contactos.get(position).getNombre());
                intent.putExtra("Celular",contactos.get(position).getCelular());
                intent.putExtra("Email",contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });*/
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }


    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.mail);
        tabLayout.getTabAt(1).setIcon(R.drawable.phone);

    }
}