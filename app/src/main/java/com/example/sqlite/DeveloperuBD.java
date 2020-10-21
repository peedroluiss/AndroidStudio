package com.example.sqlite;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;

public class DeveloperuBD  extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developeru.bd";
    private static final int VERSION_BD=1;
    private static final  String TABLA_CURSO="CREATE TABLE CURSOS(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public DeveloperuBD(Context context ) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("DROP TABLE IF EXIST"+TABLA_CURSO );
       sqLiteDatabase.execSQL(TABLA_CURSO);
    }

    public void agregarCursos(String codigo, String curso, String carrera){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CURSOS VALUES ('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }
    }

    public List<CursosModelo> mostrarCursos(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM CURSOS", null);
        List<CursosModelo> cursos=new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursos.add(new CursosModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return   cursos;
    }

}
