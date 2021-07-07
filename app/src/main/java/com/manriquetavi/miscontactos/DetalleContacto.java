package com.manriquetavi.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    //private TextView tvNombre;
    //private TextView tvNumero;
    //TextView tvCorreo;
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_detalle);

        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString("url");
        String likes = parametros.getString("likes");

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));
    }
    /*
    public void llamar(View view){
        String numero = tvNumero.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero)));
    }

    public void enviarMail(View view){
        String email = tvCorreo.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"TITULO DEL CHOOSER"));
    }*/
    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }*/
}