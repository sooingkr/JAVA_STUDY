package com.example.a01_helloworld;
/*
 * 		하나의 화면관리하는 객체가 Activity 이다.
 * 
 * 		- Activity : 한 화면을 담당
 * 		- Service : 화면없이 백단에서 동작되는 것을 담당
 * 		- Content Provider : 데이터 공유
 * 		- Broadcast Receiver : 
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	/*
		onCreate : Activity가 처음 화면에 나타날 때 호출되는 콜백메서드
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // 부모의 메서드를 호출
		setContentView(R.layout.activity_main); // inflate : xml과 java 파일을 연결해주는 명령문
		// 레이아웃상의 컨텐츠를 메모리상에 올리는 역할을 함
		TextView t1 = (TextView)findViewById(R.id.textView1); 
		// xml에서 등록한 컨탠츠가 inflate되어 메모리 어딘가에 올라가 있을 때 해당 주소를 찾아오는 것
		t1.setText("안녕하세요.");
		t1.setTextColor(0xffff00);
		// 안드로이드 디바이스는 콘솔 창이 없음
		// 데이터의 코드진행을 확인하기 위해 Log를 찍어볼 수 있다.
		Log.d("test","안녕하세요"); // tag, 출력할 메시지
		String txt = t1.getText().toString();
		Log.d("test","tv : " + txt); // tag, 출력할 메시지
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
