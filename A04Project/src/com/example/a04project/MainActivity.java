package com.example.a04project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 첫번째 화면

		// 1. 첫번째화면 Intent => 두번째 화면 : startActivityForResult() 로 보냄
		// 2. 두번째 화면 작업 후 결과값 정보를 담아서 돌아온다. : setResult
		// 3. 첫번째 화면에서는 되돌아온 상태를 onActivityResult() 오버라이딩해 사용
		tv = (TextView) findViewById(R.id.tv);
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), Next.class);
				intent.putExtra("name", "황영롱");
				startActivityForResult(intent, 3); // requestCode : 내가 보낸게 맞는지
													// 확인하기 위한 코드

			}
		});
	}

	// startActivityForResult로 다음화면 전환했을 경우, 다시 되돌아오면 호출되는 콜백메서드이다.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 3 && resultCode == Activity.RESULT_OK) {
			tv.setText("첫번째 화면, 되돌아온 결과 requestCode : " + requestCode + ", resultCode : " + resultCode
							+ ", 받아온데이터 : " + data.getStringExtra("key")
					);
		}
	}
}
