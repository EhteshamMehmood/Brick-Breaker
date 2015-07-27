package com.example.game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.game.MySQLiteOpenHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.view.Menu;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.game.MyBoundService.LocalBinder;

@SuppressLint("HandlerLeak")
public class HighScoreActivity extends Activity {
	
	private MyBoundService mdbs = null;
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mdbs = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			LocalBinder localBinder = (LocalBinder) service;
			mdbs = localBinder.getService();
		}
	}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score);
		
//		TextView tv = (TextView)findViewById(R.id.textView1);
//		tv.setText("Blue");
		ser();
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Intent i = new Intent(this, MyBoundService.class);
		bindService(i, conn, Context.BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unbindService(conn);
	}
	
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String introduction = (String)msg.obj;
			TextView [] tv = new TextView[3];
			tv[0] = (TextView)findViewById(R.id.textView1);
			tv[1] = (TextView)findViewById(R.id.textView2);
			tv[2] = (TextView)findViewById(R.id.textView3);
			try {
				   JSONObject jsonResponse = new JSONObject(introduction);
				   JSONArray jsonMainNode = jsonResponse.optJSONArray("employee");
				 
				   for (int i = 0; i < 3; i++) {
				    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
				    String name = jsonChildNode.optString("name");
				    String number = jsonChildNode.optString("no");
				    String outPut = name + "  -  " + number;
				    tv[i].setText(outPut);
				   // employeeList.add(createEmployee("employees", outPut));
				   }
				  } catch (JSONException e) {
				   Toast.makeText(getApplicationContext(), "Error" + e.toString(),
				     Toast.LENGTH_SHORT).show();

//					  SQLiteDatabase db = new MySQLiteOpenHelper(getApplicationContext()).getReadableDatabase();
//						String table = SQLDemoContract.tables.StudentEntry.TABLE_NAME;
//						String [] columns = {SQLDemoContract.tables.StudentEntry.COLUMN_NAME_NAME, SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER};
//						String selection = null;
//						String [] selectionArgs = null;
//						String groupBy = null;
//						String having = null;
//						String orderBy = null;
//						Cursor c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
//						int [] to = {android.R.id.text1};
//						String [] from = { SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER};
//						//SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
						//setListAdapter(sca);
				  
				  }
			
	}
	};
	public void ser()
	{
		TextView tv = (TextView)findViewById(R.id.textView1);
		//tv.setText("ajsghdhjkagsdjka");
		Intent intent = null;
			intent = new Intent(this, MyDownloaderIntentService.class);
		intent.putExtra(getResources().getString(R.string.url), "http://slapalot.comule.com");
		intent.putExtra(getResources().getString(R.string.messenger), new Messenger(mHandler));
		startService(intent);
		
	}
	public void useBoundService(View v){
		TextView tv = (TextView)findViewById(R.id.textView1);
		if (mdbs!=null){			
			tv.setText(String.valueOf(mdbs.aVeryComplexAlgorithem()));
		}else{
			Toast.makeText(this, "Service not connected yet", Toast.LENGTH_SHORT).show();
		}
	}

}

