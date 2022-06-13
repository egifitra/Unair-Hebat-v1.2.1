package com.example.unairhebat;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class Modul_DB extends SQLiteOpenHelper {
	
	private static String Nama_Database="db_Barang";
	
	public Modul_DB (Context context){
		super(context, Nama_Database, null,1);
	}
	
	public void Buat_Tabel_Login (SQLiteDatabase db){
			db.execSQL("Create Table If Not Exists tbl_user " +
			"(id Integer Primary Key AutoIncrement, nUser Text, nPass Text)");
	}
	
	public void onCreate(SQLiteDatabase db){
	}
		
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
	}

}