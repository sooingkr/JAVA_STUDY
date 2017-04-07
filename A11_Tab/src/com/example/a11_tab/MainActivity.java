package com.example.a11_tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity { // TabActivity 상속 필요(TabHost 제어하려면)

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		// TabHost 얻어오기
		// TabActivity를 상속받아야 얻어올 수 있음
		TabHost host = getTabHost();
		
		// Widget 생성
		TabHost.TabSpec tabs;
		tabs = host.newTabSpec("tag1"); // 태그
		tabs.setIndicator("One"); // 라벨(탭 제목)
		
		// 각 탭에 인텐트를 통해 화면 전환이 이루어 지도록 함
		Intent intent1 = new Intent(getApplicationContext(), FirstActivity.class); // 첫번째 화면으로 이동
		tabs.setContent(intent1); // 해당 탭이 보여줄 내용에 intent를 넣어줌
		host.addTab(tabs); // 전체 TabHost에 적용
		
		tabs = host.newTabSpec("tag2"); // 태그
		tabs.setIndicator("Two"); // 라벨
		Intent intent2 = new Intent(getApplicationContext(), SecondActivity.class); // 두번째 화면으로 이동
		tabs.setContent(intent2);
		host.addTab(tabs); // 전체 TabHost에 적용
		
		tabs = host.newTabSpec("tag3"); // 태그
		tabs.setIndicator("Three"); // 라벨
		
		Intent intent3 = new Intent(getApplicationContext(), ThiredActivity.class); // 세번째 화면으로 이동
		tabs.setContent(intent3);
		host.addTab(tabs); // 전체 TabHost에 적용
		
		
	} // end of onCreate
} // end of class