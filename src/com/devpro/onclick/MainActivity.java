package com.devpro.onclick;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity  {
    EditText url;
    WebView ourBrow;
    
	private EditText phone;
	private Button next;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
	
	   context=this.getApplicationContext();
		phone=(EditText)findViewById(R.id.editInp);
		next=(Button)findViewById(R.id.nextBtn);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myIntent=new Intent(context,NextScreen.class);
				
				myIntent.putExtra("phone",phone.getText().toString());
				startActivity(myIntent);
			}
		});
		
		
		
	}


		
	}


