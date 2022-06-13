package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;


public class kuncijawaban extends Activity{

	Intent i;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kunci_layout);
	
	}
	
	public void aksi (View ygDiklik){
		switch (ygDiklik.getId()){
		case R.id.bKembali:
			i=new Intent(kuncijawaban.this, setelahlogin.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			
			this.finish();
			break;
		}
	}
	
}
