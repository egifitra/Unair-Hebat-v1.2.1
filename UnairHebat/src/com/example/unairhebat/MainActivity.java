package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainActivity extends Activity {

	private SQLiteDatabase db;
	private Cursor dbCursor;
	private Modul_DB modulDB;

	MediaPlayer audioBackground;
	
	EditText tUser, tPass, txtUser, txtPass;
	Toast t;
	Intent i;
	AlertDialog.Builder KotakPesan;

	private String strUser, strPass;
	private String strQuery;
	
	Button exitbtn;
	
	protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		audioBackground = MediaPlayer.create(this,R.raw.musicbackground);
		
		audioBackground.setLooping(true);
		audioBackground.setVolume(1,1);
		audioBackground.start();
		
		modulDB = new Modul_DB(this);
		db=modulDB.getWritableDatabase();
		modulDB.Buat_Tabel_Login(db);
		
		tUser = (EditText) findViewById(R.id.eUser);
		tPass = (EditText) findViewById(R.id.ePass);
		
		exitbtn = (Button)findViewById(R.id.button1);
		
	
	}
	

	public void CekUser (SQLiteDatabase db){
		
		strUser=tUser.getText().toString();
		strPass=tPass.getText().toString();
		String xPass;
		
		
		//BELUM ISI USER DAN PASS
		if (strUser.toString().equals("") || strPass.toString().equals(""))
		{
			t= Toast.makeText(getApplication(), "User dan Password Harus Diisi",
			Toast.LENGTH_SHORT);
				t.show();
				tUser.requestFocus();
		}
		
		
		
		else{
			modulDB.onOpen(db);
			modulDB.getReadableDatabase();
			
			strQuery="Select nPass From tbl_user Where nUser='" + strUser + "'";
			dbCursor=db.rawQuery(strQuery, null);
			
			if (dbCursor.getCount()>0)
				{
				dbCursor.moveToFirst();
				xPass = dbCursor.getString(dbCursor.getColumnIndex("nPass"));
				
				
				//LOGI BERHASIL
				if(strPass.toString().equals(xPass))
					{
					t=Toast.makeText(getApplication(), "Login Berhasil",
							Toast.LENGTH_SHORT);
							t.show();
					tUser.setText("");
					tPass.setText("");
					i=new Intent(MainActivity.this,setelahlogin.class);
					i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(i);
					this.finish();
				}
				
				
				//PASS SALAH
				else{
					t=Toast.makeText(getApplication(), "Password Salah",
							Toast.LENGTH_SHORT);
					t.show();
					}
				}
				
			
				//BELUM DAFTAR
				else{
					t=Toast.makeText(getApplication(), "User Belum Terdaftar",
							Toast.LENGTH_SHORT);
					t.show();
					tUser.setText("");
					tPass.setText("");
					tUser.requestFocus();
				}
		}
}
	
	
public void Daftar(final SQLiteDatabase db){

	//membentuk form daftar
	
	LinearLayout form_daftar = new LinearLayout(this);
	form_daftar.setOrientation(LinearLayout.VERTICAL);

	//inisialisasi objek textview pada form daftar
	
	txtUser=new EditText(this);
	form_daftar.addView(txtUser);
	txtUser.setHint("User");
	txtPass=new EditText(this);
	form_daftar.addView(txtPass);
	txtPass.setHint("Password");

	//Menampilkan di kotak dialog
	
	KotakPesan=new AlertDialog.Builder(this);
	KotakPesan.setTitle("Form Daftar");
	KotakPesan.setView(form_daftar);

	
	
KotakPesan.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
	
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		strUser=txtUser.getText().toString();
		strPass=txtPass.getText().toString();
		
		if (strUser.toString().equals("") || strPass.toString().equals("")){
			t= Toast.makeText(getApplication(), "User dan Password Harus Diisi", Toast.LENGTH_SHORT);
					t.show();
			tUser.requestFocus();
		}
		else{
			modulDB.onOpen(db);
			modulDB.getWritableDatabase();
			ContentValues cvData = new ContentValues();
			cvData.put("nUser", strUser);
			cvData.put("nPass", strPass);
			db.insert("tbl_user", null, cvData);
			try{
				t= Toast.makeText(getApplication(), "Data Sukses Disimpan", Toast.LENGTH_SHORT);
						t.show();
				txtUser.setText("");
				txtPass.setText("");
				tUser.requestFocus();
			}catch(Exception e){
				t= Toast.makeText(getApplication(), "Data Gagal Disimpan",
						Toast.LENGTH_SHORT);
				t.show();
				tUser.requestFocus();
			}
		}
	}
});


	KotakPesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.cancel();
			}
		});

		KotakPesan.show();
	}

	public void aksi (View ygDiklik){
		
		
		
		switch (ygDiklik.getId()){
		case R.id.bLogin:
			CekUser(db);
			audioBackground.stop();
			break;
		case R.id.bDaftar:
			Daftar(db);
			break;
		case R.id.button1:
			audioBackground.stop();
			moveTaskToBack(true);
			break;
		
		}
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
	}
*/
}
