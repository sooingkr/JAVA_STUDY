package com.example.a05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// AdapterView 종류인 ListView 띄우기
		// 1. 다량의 데이터
		// 2. AdapterView를 선언(ListView, GridView, Gallery, Spinner ...)
		// 3. Adapter 객체 생성 후 연결( 데이터를 어디에 표현할지 설정 후 setAdapter())
		
		
		
		// 1. 다량의 데이터 준비
	/*	String str[] = {"사과", "배", "수박", "딸기", "포도", "오렌지", "귤", "키위", "자몽", "메론", "바나나",
				"사과", "배", "수박", "딸기", "포도", "오렌지", "귤", "키위", "자몽", "메론", "바나나",
				"사과", "배", "수박", "딸기", "포도", "오렌지", "귤", "키위", "자몽", "메론", "바나나",
				"사과", "배", "수박", "딸기", "포도", "오렌지", "귤", "키위", "자몽", "메론", "바나나"};
		*/
		
		
		
		// 2.
		ListView lv = (ListView)findViewById(R.id.listView1);
		
		// 어댑터 생성(어댑터에 데이터를 싣음)
	/*	ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),  // 현재화면의 제어권자
																		android.R.layout.simple_list_item_1, // 표현할 레이아웃(데이터 한칸에 대한 표현 레이아웃)
																		str); // 다량의 데이터
		*/
		
		ArrayAdapter adapter = ArrayAdapter.createFromResource( getApplicationContext(), 
																								R.array.str, // xml 에서 다량의 데이터 가져오기
																								R.layout.mylayout ); // 표현할 레이아웃
		
		
		// 3. 데이터를 담고있는 어댑터를 리스트뷰에 연결
		lv.setAdapter(adapter);
		
		// ListView(View) - Adapter(C) - 대량 데이터(M)         : MVC
		
	}


}
