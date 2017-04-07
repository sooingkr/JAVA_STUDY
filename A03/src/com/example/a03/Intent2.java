package com.example.a03;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Intent2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent2);

		Button b1 = (Button) findViewById(R.id.b1);
		Button b2 = (Button) findViewById(R.id.b2);
		Button b3 = (Button) findViewById(R.id.b3);
		Button b4 = (Button) findViewById(R.id.b4);
		Button b5 = (Button) findViewById(R.id.b5);
		Button b6 = (Button) findViewById(R.id.b6);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 전화 다이얼
				// 전화는 권한이 필요함 메니페스트에 권한 설정
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-3604-7237")); // 전화번호를 함께보냄
				startActivity(intent);
			}
		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 전화걸기
				Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:010-3604-7237"));
				startActivity(intent);
			}
		});
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 웹브라우저
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://cafe.naver.com/minsseam1"));
				startActivity(intent);
				
			}
		});
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 문자 전송
				Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:010-3604-7237"));
				startActivity(intent);
			}
		});
		b5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 이메일
				Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:sooingkr@naver.com"));
				startActivity(intent);
			}
		});
		
		b6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 지도 띄우기
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.478537,126.886133")); // 위도, 경도
				startActivity(intent);
			}
		});

	}
}
