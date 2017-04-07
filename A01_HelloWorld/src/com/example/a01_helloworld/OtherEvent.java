package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class OtherEvent extends Activity {

	Button b1;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_event);

		tv = (TextView)findViewById(R.id.tv);
		
		b1 = (Button)findViewById(R.id.touch);
		b1.setOnTouchListener(new OnTouchListener() {
		
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// 터치 : - 다운
				//			 - 업
				//			 - 무브
				
				if ( event.getAction() == MotionEvent.ACTION_DOWN ){
					tv.setText("터치 다운됨");
				}
				if ( event.getAction() == MotionEvent.ACTION_MOVE ){
					tv.setText("터치 무브됨");
				}
				if ( event.getAction() == MotionEvent.ACTION_UP ){
					tv.setText("터치 업됨");
				}
				return false;
			}
		
		});
		
		findViewById(R.id.Click).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tv.setText("클릭됨");
			}
		});
		
		findViewById(R.id.longClick).setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				tv.setText("long Click");
				return false;
			}
		});;
		
		
	}

}
