package com.camilo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadContacts();

        ArrayList<String> nombresContactos = new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContactos.add(contacto.getName());
        }

        ListView lstView = (ListView) findViewById(R.id.lstContactos);
        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));
//      Imprime valores no entendibles
//      lstView.setAdapter(new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactos));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pName),  contactos.get(i).getName());
                intent.putExtra(getResources().getString(R.string.pPhone), contactos.get(i).getPhone());
                intent.putExtra(getResources().getString(R.string.pEmail), contactos.get(i).getEmail());
                startActivity(intent);
            }
        });

    }

    private void loadContacts(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Camilo Carvajal Silva", "314 517 2604", "camilo@neuvoo.com"));
        contactos.add(new Contacto("Fabricio Silva", "927 517 8162", "fabricio.silva@gmail.com"));
        contactos.add(new Contacto("Viviana Zapata Car", "829 729 2604", "viviana@zapata.com"));
        contactos.add(new Contacto("Nancy Carvajal Agudelo", "019 817 2604", ""));
        contactos.add(new Contacto("Daniel Urrego Agudelo", "471 000 2604", "urrego.gmail.com"));
    }
}