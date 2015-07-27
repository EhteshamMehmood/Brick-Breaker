package com.example.game;

 

import java.util.HashMap;
import java.util.Map;

import com.example.game.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullScrActivity extends Activity {
  

	
	public void gamePlayFunc(View v){

		Intent i=new Intent(this, GameActivity.class);
		startActivity(i);
		
	}
	public void helpFunc(View v){

		Intent i=new Intent(this, HelpActivity.class);
		startActivity(i);
		
	}
	
	public void highScoreFunc(View v){

		Intent i=new Intent(this, HighScoreActivity.class);
		startActivity(i);
		
	}
	
	public void quitFunc(View v){

		//FullScrActivity.class.`
		
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_scr);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
	}
	
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
 
    }
 
};
