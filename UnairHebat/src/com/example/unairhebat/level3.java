package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class level3 extends Activity{
	
	Intent i;
	
	EditText textdibox;
	ImageView gambar;
	TextView soal;
	Button okebtn;
	
	MediaPlayer audioBackground;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level2_activity);
	
	textdibox = (EditText)findViewById(R.id.editText2);
	gambar = (ImageView)findViewById(R.id.imageView1);
	soal = (TextView)findViewById(R.id.textView1);
	okebtn = (Button)findViewById(R.id.button1);
	
	audioBackground = MediaPlayer.create(this,R.raw.level12);
	
	audioBackground.setLooping(true);
	audioBackground.setVolume(1,1);
	audioBackground.start();
	
	gambar.setImageResource(R.drawable.lv31);
	
	okebtn.setOnClickListener(new View.OnClickListener(){
		String tebakan,jawaban;
		public void onClick(View Arg0) {
			tebakan = ((EditText) textdibox).getText().toString();
			jawaban = "EKSOSKELETON";
			if(tebakan.equals(jawaban)){
				Toast.makeText(getApplicationContext(), "jawabanmu BENAR", Toast.LENGTH_SHORT).show();
				image2();
			}
			else {
				Toast.makeText(getApplicationContext(), "jawabanmu SALAH", Toast.LENGTH_SHORT).show();
			}
		}
	});
	
}


public void image2() {
	
	textdibox.setText("");
	gambar.setImageResource(R.drawable.lv32);
	
	okebtn.setOnClickListener(new View.OnClickListener(){
		String tebakan,jawaban;
		public void onClick(View Arg0) {
			tebakan = ((EditText) textdibox).getText().toString();
			jawaban = "KESEHATAN";
			if(tebakan.equals(jawaban)){
				Toast.makeText(getApplicationContext(), "jawabanmu BENAR", Toast.LENGTH_SHORT).show();
				image3();
			}
			else {
				Toast.makeText(getApplicationContext(), "jawabanmu SALAH", Toast.LENGTH_SHORT).show();
			}
		}
	});
	
}

public void image3() {
	
	textdibox.setText("");
	gambar.setImageResource(R.drawable.lv33);
	
	okebtn.setOnClickListener(new View.OnClickListener(){
		String tebakan,jawaban;
		public void onClick(View Arg0) {
			tebakan = ((EditText) textdibox).getText().toString();
			jawaban = "AMPLIFIER";
			if(tebakan.equals(jawaban)){
				Toast.makeText(getApplicationContext(), "jawabanmu BENAR, level 3 SELESAI", Toast.LENGTH_LONG).show();
				audioBackground.stop();
				Intent i = new Intent (level3.this,tamat.class);
				startActivity(i);
			}
			else {
				Toast.makeText(getApplicationContext(), "jawabanmu SALAH", Toast.LENGTH_SHORT).show();
			}
		}
	});
	
}
	
	public void aksi (View ygDiklik){
		
		switch (ygDiklik.getId()){
		
		case R.id.bKembali:
			i=new Intent(level3.this, setelahlogin.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			audioBackground.stop();
			this.finish();
			break;
			
		}
	}
}