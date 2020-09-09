package com.camilo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parameters = getIntent().getExtras();
        String nombre   = parameters.getString(getResources().getString(R.string.pName));
        String phone    = parameters.getString(getResources().getString(R.string.pPhone));
        String email    = parameters.getString(getResources().getString(R.string.pEmail));

        tvName  = (TextView)findViewById(R.id.tvNombre);
        tvPhone = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvName.setText(nombre);
        tvPhone.setText(phone);
        tvEmail.setText(email);

    }

    public void llamar(View view){
        String telefono = tvPhone.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void enviarEmail(View view){
        String email    = tvEmail.getText().toString();
        String subject  = "[Subject]Esta es una prueba";
        String bodyText = "[Body]Esta es una prueba ";
        String mailto   = "mailto:"+email+
                            "?cc=" + "alice@example.com" +
                            "&subject=" + Uri.encode(subject) +
                            "&body=" + Uri.encode(bodyText);

//        Ver mensajes en la consola LogCat
//        Log.println(Log.WARN, "WARN_LOG", mailto);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

//      createChooser Permite elegir con que aplicacion enviamos el email
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}