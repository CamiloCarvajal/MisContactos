package com.camilo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Studio App Test");
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }


}