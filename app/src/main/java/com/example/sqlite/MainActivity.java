package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigo, edtCurso, edtCarrera;
    Button btnAgregar, btnMostrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo=(EditText)findViewById(R.id.edtCodigo);
        edtCurso=(EditText)findViewById(R.id.edtCurso);
        edtCarrera=(EditText)findViewById(R.id.edtCarrera);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);

        final DeveloperuBD developeruBD=new DeveloperuBD(getApplicationContext());
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developeruBD.agregarCursos(edtCodigo.getText().toString(),edtCurso.getText().toString(),edtCarrera.getText().toString());
                Toast.makeText(getApplicationContext(),"SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarCursos=new Intent(getApplicationContext(),CursosActivity.class);
                startActivity(mostrarCursos);

            }
        });

    }
}