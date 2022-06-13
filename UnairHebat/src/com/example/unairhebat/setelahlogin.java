package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;

public class setelahlogin extends Activity{
	
	Intent i;
	
	MediaPlayer audioBackground;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setelah_login);
		
		audioBackground = MediaPlayer.create(this,R.raw.mike);
		
		audioBackground.setLooping(true);
		audioBackground.setVolume(1,1);
		audioBackground.start();
		
	}
	
	public void aksi (View ygDiklik){
		switch (ygDiklik.getId()){
		
		case R.id.bKembali:
			i=new Intent(setelahlogin.this, MainActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
			
		case R.id.button1:
			i=new Intent(setelahlogin.this, level1.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
			
		case R.id.button2:
			i=new Intent(setelahlogin.this, level2.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
		
			
		case R.id.button5:
			i=new Intent(setelahlogin.this, level3.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
			
		case R.id.button3:
			i=new Intent(setelahlogin.this, elearning.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
		
		case R.id.button6:
			i=new Intent(setelahlogin.this, banksoal.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
		
		case R.id.button4:
			i=new Intent(setelahlogin.this, kuncijawaban.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
			
		}
	}
}