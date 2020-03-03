package com.example.appsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
	public DatabaseHelper (@Nullable Context context){
		super (context, "DBCar.sql", null, 1);
	}

	@Override 

	public void onCreate (SQLiteDatabase db){
		db.execSQL("create table tbCarro (idCarro primary key nome_do_carro text, placa text, descricao text, ano text") );

	} 
	
	 @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbCar");
    }

    public boolean insert (CarroBD carro1 ){
    	Carro carro1 = new Carro();
    	SQLiteDatabase db = this.getWritableDatabase();

    	ContentValues contentvalues = new ContentValues();
    	contentvalues.put ("nome_do_carro", carro1.getnome());
    	contentvalues.put ("placa", carro1.getplaca());
    	contentvalues.put ("descricao", carro1.getdescricao());
    	contentvalues.put ("ano", carro1.getano());

    	Long inserido = db.insert("tbCarro", null, contentvalues);

    	if (inserido > 0 ){
    		return true;
    	}else {
    		return false;
    	}

    }
    
}
