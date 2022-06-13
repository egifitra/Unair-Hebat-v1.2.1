package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;


public class tamat extends Activity{

	Intent i;
	
	MediaPlayer audioBackground;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tamat_layout);
	
		audioBackground = MediaPlayer.create(this,R.raw.tamm);
		
		audioBackground.setLooping(true);
		audioBackground.setVolume(1,1);
		audioBackground.start();
		
	}
	
	public void aksi (View ygDiklik){
		switch (ygDiklik.getId()){
		case R.id.bKembali:
			i=new Intent(tamat.this, setelahlogin.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
		}
	}
	
}