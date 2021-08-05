package com.example.carteracontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.carteracontactos.adaptadores.ListaContactosAdapter;
import com.example.carteracontactos.db.DbContactos;
import com.example.carteracontactos.db.DbHelper;
import com.example.carteracontactos.entidades.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = findViewById(R.id.listaContactos);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        DbContactos dbContactos = new DbContactos(MainActivity.this);

        listaArrayContactos= new ArrayList<>();
        ListaContactosAdapter adapter = new ListaContactosAdapter((dbContactos.mostrarContactos()));
        listaContactos.setAdapter(adapter);
        /*
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                if (db !=null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA ",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR BASE DE DATOS  ",Toast.LENGTH_LONG).show();

                }


            }
        });*/
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return  true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.menuNuevo:
                nuevoRegistro();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private  void nuevoRegistro(){
        Intent intent = new Intent(this,NuevoActivity.class);
        startActivity(intent);
    }

}