package com.example.a06;

import android.app.Activity;
import android.app.FragmentManager.BackStackEntry;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

class Item {
	String name;
	String word;
	public Item(String name, String word) {
		this.name = name;
		this.word = word;
	}
	
}
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 1. 다량의 데이터
		// 2. AdapterView (ListView)
		// 3. Adapter 생성 후 연결 ( 한 행을 디자인한 layout 준비)
		
		
		// 1
		Item item[] = { new Item("사과","apple"),
				new Item("바나나","banana"),
				new Item("배","pear"),
				new Item("딸기","strawberry"),
				new Item("오렌지","orange"),
				new Item("자몽","grapefruit"),
				new Item("포도","grape"),
		};
		
		String str[] = {"사과","딸기","자두","앵두","블루베리","멜론","바나나","키위","사과","딸기","자두","앵두","블루베리","멜론","바나나","키위","사과","딸기","자두","앵두","블루베리","멜론","바나나","키위"};
		String str2[] = {"apple","strawberry","jadu","engdu","blueberry","melon","banana","kiwi","apple","apple","strawberry","jadu","engdu","blueberry","melon","banana","kiwi","apple","apple","strawberry","jadu","engdu","blueberry","melon","banana","kiwi"};
		
		// 2
		ListView lv = (ListView)findViewById(R.id.listView1);
		
		// 3 어댑터 직접 만들기
		MyAdapter ma = new MyAdapter( getApplicationContext(), // 현재화면 제어권자
															R.layout.datalayout,    // 리스트 뷰의 한행의 디자인
															str, str2, item);							   // 다량의 데이터
		
		lv.setAdapter(ma);
		
	} // end of onCreate
} // end of class

class MyAdapter extends BaseAdapter{

	int datalayout;
	String str[];
	String str2[];
	Item[] item;
	LayoutInflater lif; // xml의 레이아웃을 읽어와서 자바에서 사용할 수 있는 객체로 바꾸기 위해 사용
	
	public MyAdapter( Context context, int datalayout, String[] str , String[] str2, Item[] item) {
		this.datalayout = datalayout;
		this.str = str;
		this.str2 = str2;
		this.item = item;
		this.lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// LayoutInflater 객체 얻어오기
	}
	@Override
	public int getCount() { // (필수항목)ListView 에 몇 항목을 보여줄지 설정
		return str.length;
	}

	@Override
	public Object getItem(int position) { // (선택사항) position 번째의 내용을 리턴
		return item[position].name + ":" + item[position].word;
	}

	@Override
	public long getItemId(int position) {	// (선택사항) position번째의 유니크한 id를 리턴
		return position;
	}

	@Override
	// (필수사항)해당 position 번째의 레이아웃에 어떠한 데이터를 보여줄지를 설정.
	public View getView(int position, View convertView, ViewGroup parent) { // ViewGroup parent : ListView(부모), View convertView : 데이터 각 한 행 부분
		// 한 행의 레이아웃에 데이터를 연결
		//TextView tv = (TextView)findViewById(R.id.textView1); 불가능 : Activity의 메서드인대 상속을 안하고 있음으로 사용 불가 따라서 LayoutInflator 필요
		if ( convertView == null ){
			convertView = lif.inflate(datalayout, null); // xml 레이아웃을 객체로 변환
		}		
		TextView tv = (TextView)convertView.findViewById(R.id.textView1);
		TextView tv2 = (TextView)convertView.findViewById(R.id.textView2);
		tv.setText(item[position].name);
		tv2.setText(item[position].name);
		//tv.setText(str[position]);
		//tv2.setText(str2[position]);
		
		return convertView;
	}
	
}