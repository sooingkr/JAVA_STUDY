package com.example.a02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.framelayout);

		final Button b1 = (Button) findViewById(R.id.button1);
		final Button b2 = (Button) findViewById(R.id.button2);
		final Button b3 = (Button) findViewById(R.id.button3);

		b1.setVisibility(View.VISIBLE);
		b2.setVisibility(View.INVISIBLE);
		b3.setVisibility(View.INVISIBLE);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				b1.setVisibility(View.INVISIBLE);
				b2.setVisibility(View.VISIBLE);
			}
		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				b2.setVisibility(View.INVISIBLE);
				b3.setVisibility(View.VISIBLE);
			}
		});
	}

}
