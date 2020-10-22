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
    Button btnAgregar, btnMostrar, btnbuscar, btnEditar, btnEliminar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo=(EditText)findViewById(R.id.edtCodigo);
        edtCurso=(EditText)findViewById(R.id.edtCurso);
        edtCarrera=(EditText)findViewById(R.id.edtCarrera);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);
        btnbuscar=(Button) findViewById(R.id.btnBuscar);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);

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

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CursosModelo cursos=new CursosModelo();
                developeruBD.buscarCursos(cursos,edtCodigo.getText().toString());
                edtCurso.setText(cursos.getCurso());
                edtCarrera.setText(cursos.getCarrera());

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developeruBD.editarCursos(edtCodigo.getText().toString(), edtCurso.getText().toString(),edtCarrera.getText().toString());
                Toast.makeText(getApplicationContext(), "SE MODIFICO CORRECTAMENTE ", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               developeruBD.eliminarCursos(edtCodigo.getText().toString());
               Toast.makeText(getApplicationContext(),"SE ELIMINO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

    }
}