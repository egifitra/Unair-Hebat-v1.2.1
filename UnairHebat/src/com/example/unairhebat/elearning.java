package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class elearning extends Activity{
		
	Intent i;
	
	WebView webviewku;
	WebSettings websettingsku;
	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tampilan_elearning);
		
			webviewku = (WebView)findViewById(R.id.WebView1);
			
			websettingsku = webviewku.getSettings();
			webviewku.setWebViewClient(new WebViewClient());
			
			webviewku.loadUrl("https://hebat.elearning.unair.ac.id/my/");
			
		}
		
		public void aksi (View ygDiklik){
			switch (ygDiklik.getId()){
			case R.id.bKembali:
				i=new Intent(elearning.this, setelahlogin.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(i);
				this.finish();
				break;
			}
		}
}