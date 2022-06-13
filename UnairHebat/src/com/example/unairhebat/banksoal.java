package com.example.unairhebat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class banksoal extends Activity{

	Intent i;
	
	WebView webviewku;
	WebSettings websettingsku;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banksoal_layout);
	
		webviewku = (WebView)findViewById(R.id.WebView1);
		
		websettingsku = webviewku.getSettings();
		webviewku.setWebViewClient(new WebViewClient());
		
		webviewku.loadUrl("https://drive.google.com/drive/folders/0B3ywpPw2QkTWTjEwWE5lWEFpd0E?resourcekey=0-XBbqTj2vxfRSI27GRmRwWw");
		
		
	}
	
	public void aksi (View ygDiklik){
		switch (ygDiklik.getId()){
		case R.id.bKembali:
			i=new Intent(banksoal.this, setelahlogin.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(i);
			
			this.finish();
			break;
		}
	}
	
}
