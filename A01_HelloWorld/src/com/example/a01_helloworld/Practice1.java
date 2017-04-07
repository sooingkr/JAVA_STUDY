package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Practice1 extends Activity {

	Button button1;
	Button button2;
	Button button3;
	TextView tv ;
	int total = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practice1);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		tv = (TextView)findViewById(R.id.textView1);
		
		// 버튼 클릭 이벤트 달기
		/*button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tv.setText("클릭했습니다.");
			}
		});
		*/
		
		class MyClickEvent implements OnClickListener {

			@Override
			public void onClick(View v) {
				if ( v.getId() == R.id.button1){
					tv.setText("클릭했습니다.");					
				}else if ( v.getId() == R.id.button2 ){
					
					tv.setText("");
				}else if ( v.getId() == R.id.button3 ){
					total += 1;
					tv.setText(total+""); // Text 내에 String을 받기 때문(인자값을 문자열로 작성해야함)
				}
			}
		} // end of MyClickEvent
		
		MyClickEvent event = new MyClickEvent();
		button1.setOnClickListener(event);
		button2.setOnClickListener(event);
		button3.setOnClickListener(event);
	}


}
