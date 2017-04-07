package com.example.a03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentStudy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_study);
	
		final Button b = (Button)findViewById(R.id.next);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

//				Intent it = new Intent(IntentStudy.this,NextPage.class);  명시적 인텐트 방법
				Intent intent = new Intent("android.intent.action.VIEW"); // 묵시적 인텐트 방법 ( 클래스 이름을 모를 때 manifest에서 name에 지정한 값으로 설정)
				startActivity(intent);
			}
		});
	}

}
