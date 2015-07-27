package com.example.game;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class MyDownloaderIntentService extends IntentService {

	public MyDownloaderIntentService() {
		super("MyDownloaderIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		
		//Toast.makeText(this, "Service not connected yet", Toast.LENGTH_SHORT).show();
		Utils.download(this, arg0);
	}

}
