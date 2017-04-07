package com.example.a14_seekbar;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	SeekBar sb;
	ImageView iv;
	Point size; // 스크린의 사이즈
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Display display = getWindowManager().getDefaultDisplay();
		size = new Point();
		display.getSize(size);
		
		final TextView tv = (TextView)findViewById(R.id.textView1);
		iv = (ImageView)findViewById(R.id.imageView1);
		
		sb = (SeekBar)findViewById(R.id.seekBar1);
		sb.setMax(50);
		
		final Button b = (Button)findViewById(R.id.button1);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) { // 썸네일에서 손을 땠을 때 호출되는 메서드
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) { // 썸네일에 손을 댔을 때 호출되는 메서드
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // 값이 변경되었을 때 호출되는 메서드 
//				tv.setText("onProgressChanged");
//				Log.d("seekBar","onProgressChanged");
				tv.setText("값 : " + progress);
				
			}
		});
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 예약걸어주기
				
				handler.post(r);
			}
		});
	}

	Handler handler = new Handler();
	Runnable r = new Runnable(){
		public void run() {
			if ( sb.getProgress() < sb.getMax() ){
				sb.setProgress(sb.getProgress() + 1);
				iv.setX(iv.getX()+1);
				iv.setY(iv.getY() - 0.5f);
				
				if ( iv.getX() < size.x && iv.getY() < size.y) {
					handler.postDelayed(r, 80);
				} else {
					Log.d("화면 끝까지 왔음. 종료", null);
				}
				
			}
		};
	};
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		handler.removeCallbacks(r);
	}
}