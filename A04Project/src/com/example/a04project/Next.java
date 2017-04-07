package com.example.a04project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Next extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		// 두번째 화면
		
		Intent intent = getIntent();
		String str = intent.getStringExtra("name");
		
		TextView tv  = (TextView)findViewById(R.id.textViewShow);
		
		tv.setText("두번째 화면, 전달받은 이름 : " + str);
		
		// 빽(뒤로가기)로 되돌아 갔을 때 처리할 값을 저장
		
		setResult( Activity.RESULT_OK ); // resultCode : 진행상태를 표시하는 역할 : 예를들어 첫번째에서 인텐트로 블루투스 켜는걸 요청했는대 안켜졌으면 실패를 결과로 세팅해줌
		
		
		Intent intent2 = new Intent();
		intent2.putExtra("key", "호랑이");
		setResult(Activity.RESULT_OK, intent2);
		
		
	}
}
