package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CursosActivity extends AppCompatActivity {

   private RecyclerView recyclerViewCurso;
   private CursosAdaptador cursosAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        recyclerViewCurso=(RecyclerView)findViewById(R.id.recyclerCursos);
        recyclerViewCurso.setAdapter(cursosAdaptador);

    }
    public List<CursosModelo> obtenerCursos(){
        List<CursosModelo> curso=new ArrayList<>();
        curso.add(new CursosModelo("DE100", "Android Studio 3.0", "Sistemas"));
        curso.add(new CursosModelo("DE200", "JAVA WEB", "Sistemas"));
        return curso;
    }

}

