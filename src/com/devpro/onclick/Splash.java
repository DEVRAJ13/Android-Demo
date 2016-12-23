package com.devpro.onclick;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class Splash extends Activity{
	

MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle DevRajThakur) {
		// TODO Auto-generated method stub
		super.onCreate(DevRajThakur);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
					
				} catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint =new Intent("com.devpro.onclick.MAINACTIVITY");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
