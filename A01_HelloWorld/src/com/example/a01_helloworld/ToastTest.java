package com.example.a01_helloworld;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ToastTest extends Activity {
	Point pp = new Point();
	Display d = getWindowManager().getDefaultDisplay();
	Button b1;
	Button b2;
	Button b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
	
		b1 = (Button)findViewById(R.id.one);
		b2 = (Button)findViewById(R.id.two);
		b3 = (Button)findViewById(R.id.three);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Toast입니다.", Toast.LENGTH_SHORT).show();
			}
		});
	
		// Toast 가 뜨는 위치를 제어하고 싶을 때
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast t = Toast.makeText(getApplicationContext(), "위치변경", Toast.LENGTH_SHORT);
				t.show();
				t.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
			}
		});

		
		
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast t = Toast.makeText(getApplicationContext(), "랜덤 위치", Toast.LENGTH_SHORT);
				t.show();
				d.getSize(pp);
				int x = (int)(Math.random() * pp.x);
				int y = (int)(Math.random() * pp.y);
				if ( x < 0 ){
					x = 0;
				}
				if ( x > (pp.x-200) ){
					x = (pp.x-300);
				}
				if ( y < 0 ){
					y = 0;
				}
				if ( y > pp.y-100 ){
					y = pp.y - 200;
				}
				t.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
			}
		});
	}
	
	


}
