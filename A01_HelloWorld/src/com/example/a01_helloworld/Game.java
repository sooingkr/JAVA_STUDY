package com.example.a01_helloworld;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class Game extends Activity {

	ImageView iv;
	Button bUp;
	Button bDown;
	Button bLeft;
	Button bRight;
	int num = 10;
	Point p;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		iv = (ImageView) findViewById(R.id.starImg);
		bUp = (Button) findViewById(R.id.up);
		bDown = (Button) findViewById(R.id.down);
		bLeft = (Button) findViewById(R.id.left);
		bRight = (Button) findViewById(R.id.right);

		// 화면의 크기 얻어오기
		Display d = getWindowManager().getDefaultDisplay();
		p = new Point();
		d.getSize(p); // p에 x, y 다 받아옴
		
		bUp.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float y = iv.getY()-num;
				if ( y < 0 ) y = 0;
				iv.setY(y);
				
				return false; // 하위 이벤트에 전달하겠다.
			}
		}); // end of bUp

		bDown.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float y = iv.getY() + num;
				if ( y > p.y ) y = p.y - 100;
				iv.setY(y);
				return false; // 하위 이벤트에 전달하겠다.
			}
		}); // end of bDown

		bLeft.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = iv.getX() - num;
				if ( x < 0 ) x = 0;
				iv.setX( x );
				return false; // 하위 이벤트에 전달하겠다.
			}
		}); // end of bLeft

		bRight.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = iv.getX() + num;
				if ( x > p.x ) x= p.x - 100;
				iv.setX(x);
				return false; // 하위 이벤트에 전달하겠다.
			}
		}); // end of bUp

	}

}
