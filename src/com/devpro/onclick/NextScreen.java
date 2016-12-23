package com.devpro.onclick;





import android.app.Activity;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;


public class NextScreen extends Activity implements  android.view.View.OnClickListener{
	EditText url;
	WebView ourBrow;
	ProgressBar loadingProgressBar,loadingTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next_activity);
		

		Bundle extras=getIntent().getExtras();
		if(extras==null){
			return;
		}
		String phone=extras.getString("phone");
		
		EditText et=(EditText)findViewById(R.id.etURL);
		et.setText(phone);
		
		ourBrow=(WebView)findViewById(R.id.wvBrowser);
		ourBrow.loadUrl(phone);
		ourBrow=(WebView)findViewById(R.id.wvBrowser);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		ourBrow.setWebViewClient(new ourViewClient());
        
		
		ImageButton go = (ImageButton) findViewById(R.id.bGo);
		
		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		
loadingProgressBar=(ProgressBar)findViewById(R.id.progressbar_Horizontal); 
        
        ourBrow.setWebChromeClient(new WebChromeClient() {
        	public void onProgressChanged(WebView wb, int newProgress) {

        		   super.onProgressChanged(wb, newProgress);


        		   loadingProgressBar.setProgress(newProgress);
        		   //loadingTitle.setProgress(newProgress);
        		   // hide the progress bar if the loading is complete

        		   if (newProgress == 100) {
        		   loadingProgressBar.setVisibility(View.GONE);
        		   
        		   } else{
        		   loadingProgressBar.setVisibility(View.VISIBLE);
        		   
        		   }

        		   
	}
        });
        
	}
	
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater blowUp=getMenuInflater();
		 blowUp.inflate(R.menu.main,menu);
		 return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.forward:
			if(ourBrow.canGoForward())
			ourBrow.goForward();
			break;
		case R.id.backward:
			if(ourBrow.canGoBack())
			ourBrow.goBack();
			break;
		case R.id.reload:
			ourBrow.reload();
			break;
		case R.id.chistory:
			ourBrow.clearHistory();
			break;
		case R.id.aboutus:
			break;	
		
		}
		return false;
	}
       
	
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()){
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			ourBrow.loadUrl(theWebsite);
            break;
	}
	
	
	
	}
	}
	

