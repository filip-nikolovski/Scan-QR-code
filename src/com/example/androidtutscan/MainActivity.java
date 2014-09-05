package com.example.androidtutscan;

import com.google.zxing.client.android.CaptureActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b1;
	//static String contents;

	public static final int REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		

		////////////////////////////////////////////////////////////////////////
		b1 = (Button) findViewById(R.id.submit);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						CaptureActivity.class);
				// Intent intent = new
				// Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});
		
		
		
		
	}
	
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == 1) { // nekade e resultcode == RESULT_OK
				// Handle successful scan
				String capturedQrValue = intent.getStringExtra("RESULT");
				//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				Toast.makeText(MainActivity.this,
						"Scan Result:" + capturedQrValue, Toast.LENGTH_SHORT)
						.show();

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Toast.makeText(MainActivity.this,
						"Scan unsseccfull", Toast.LENGTH_SHORT)
						.show();
			}
		} else {

		}

	}

	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	

}


