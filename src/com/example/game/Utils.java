package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
//import org.apache.commons.io.IOUtils;

public class Utils {
	
	public static InputStream downloadFromURL(String urlString){
		InputStream retval = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//URLConnection ucon = url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			retval = con.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retval;
	}
	
	public static String getAsStringFromURL(String urlString){
		String retval = "";
		InputStream is = null;
		if ((is = downloadFromURL(urlString)) != null){
			try {
				retval = new BufferedReader(new InputStreamReader(is)).readLine();//String(IOUtils.toByteArray(is));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retval;
		
	}
	
//	private static String convertStreamToString(InputStream is) {
//	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//	    StringBuilder sb = new StringBuilder();
//
//	    String line = null;
//	    try {
//	        while ((line = reader.readLine()) != null) {
//	            sb.append(line + "\n");
//	        }
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            is.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return sb.toString();
//	}
//	
	public static void download(Context c, Intent i){
		String urlString = i.getStringExtra(c.getResources().getString(R.string.url));
		Messenger messenger = (Messenger)i.getExtras().get(c.getResources().getString(R.string.messenger));
		String introduction = Utils.getAsStringFromURL(urlString);
		Message message = Message.obtain();
		message.obj = introduction;
		try {
			messenger.send(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
