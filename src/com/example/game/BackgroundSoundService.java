package com.example.game;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/*
public class BackgroundSoundService extends Service implements MediaPlayer.OnPreparedListener {
    private static final String ACTION_PLAY = "com.example.action.PLAY";
    MediaPlayer mMediaPlayer = null;

    public int onStartCommand(Intent intent, int flags, int startId) {
        
        if (intent.getAction().equals(ACTION_PLAY)) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.au); // initialize it here
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.prepareAsync(); // prepare async to not block main thread
        }
		return startId;
    }

    /** Called when MediaPlayer is ready /
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	   @Override
	   public void onDestroy() {
	       if (mMediaPlayer != null) mMediaPlayer.release();
	   }

}*/


	
	public class BackgroundSoundService extends Service {
	    private static final String TAG = null;
	    MediaPlayer player;
	    public IBinder onBind(Intent arg0) {

	        return null;
	    }
	    @Override
	    public void onCreate() {
	        super.onCreate();
	        player = MediaPlayer.create(this, R.raw.au);
	        player.setLooping(true); // Set looping
	        player.setVolume(100,100);

	    }
	    public int onStartCommand(Intent intent, int flags, int startId) {
	        player.start();
	        return 1;
	    }

	    public void onStart(Intent intent, int startId) {
	        // TO DO
	    	//player.start();
	    }
	    public IBinder onUnBind(Intent arg0) {
	        // TO DO Auto-generated method
	        return null;
	    }

	    public void onStop() {

	    }
	    public void onPause() {

	    }
	    @Override
	    public void onDestroy() {
	        player.stop();
	        player.release();
	    }

	    @Override
	    public void onLowMemory() {

	    }
	}

