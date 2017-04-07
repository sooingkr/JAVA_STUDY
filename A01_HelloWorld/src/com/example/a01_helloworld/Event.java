package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Event extends Activity implements OnClickListener {

	static Button button11;
	static Button button22;
	static Button button33;
	static TextView tv;
	Button button0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		button11 = (Button)findViewById(R.id.button11);
		button22 = (Button)findViewById(R.id.button22);
		button33 = (Button)findViewById(R.id.button33);
		button0 = (Button)findViewById(R.id.button0);
		tv = (TextView)findViewById(R.id.showview);
		
		
		
		
		myEvent e = new myEvent();
		button11.setOnClickListener(e);
		button22.setOnClickListener(e);
		button33.setOnClickListener(e);
	
		
		button11.setOnClickListener(this); // 내 클래스 객체를 넣는 방법 : 해당 클래스에서 OnClickListenr를 implements해서 onClick을 구현하도록...
		button22.setOnClickListener(this);
		button33.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// 이 부분 작성...
		
	}

	public void myClick(View v){ // xml의 버튼의 onClick 속성으로 지정한 메서드 명
		Button b = (Button)v;
		if(b.getId() == R.id.button0){
			String str  = (String)b.getTag();   // tag 속성은 text 부분에 값 지정이 어려울 수도 있음으로(표시용도사용위해), 값을 가져오기 위해 tag에 값을 지정하고 가져올 수 있다.
		}
	}

}



// 외부클래스로 빼서 이벤트 처리 : 자원에 접근하기가 어려움...(static으로 선언해 접근해야함)
class myEvent implements OnClickListener {

	@Override
	public void onClick(View v) {
		if ( v.getId() == R.id.button11 ){
			Event.tv.setText(Event.tv.getText().toString() + Event.button11.getText());
		}else if (v.getId() == R.id.button22) {
			Event.tv.setText(Event.tv.getText().toString() + Event.button22.getText());
		}else if (v.getId() == R.id.button33){
			Event.tv.setText(Event.tv.getText().toString() + Event.button33.getText());
		}
	}
	
}
