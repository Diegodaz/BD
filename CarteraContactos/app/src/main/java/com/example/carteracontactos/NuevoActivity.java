package com.example.carteracontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carteracontactos.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {
    EditText txtNombre,txtDireccion,txtCorreoElectronico,txtTelefono;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnGuardar = findViewById(R.id.btnGuarda);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id =dbContactos.insertarContacto(txtNombre.getText().toString(),txtDireccion.getText().toString(),txtCorreoElectronico.getText().toString(),txtTelefono.getText().toString());

                if(id >0){
                    Toast.makeText(NuevoActivity.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    limpiar();

                }else{
                    Toast.makeText(NuevoActivity.this,"ERROR AL GUARDAR REGISTRO ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCorreoElectronico.setText("");
        txtTelefono.setText("");
    }
}