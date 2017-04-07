package com.example.a07_adapterview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	LayoutInflater lif;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		final Item[] item = {
				new Item("사과","apple"),
				new Item("배","pear"),
				new Item("수박","watermelon"),
				new Item("딸기","strawberry"),
				new Item("포도","grape"),
				new Item("자몽","grapefruit"),
				new Item("바나나","banana"),
				new Item("호박","pumpkin"),
				new Item("오이","cucumber"),	
				new Item("사과","apple"),
				new Item("배","pear"),
				new Item("수박","watermelon"),
				new Item("딸기","strawberry"),
				new Item("포도","grape"),
				new Item("자몽","grapefruit"),
				new Item("바나나","banana"),
				new Item("호박","pumpkin"),
				new Item("오이","cucumber"),	
				new Item("사과","apple"),
				new Item("배","pear"),
				new Item("수박","watermelon"),
				new Item("딸기","strawberry"),
				new Item("포도","grape"),
				new Item("자몽","grapefruit"),
				new Item("바나나","banana"),
				new Item("호박","pumpkin"),
				new Item("오이","cucumber"),	
				new Item("사과","apple"),
				new Item("배","pear"),
				new Item("수박","watermelon"),
				new Item("딸기","strawberry"),
				new Item("포도","grape"),
				new Item("자몽","grapefruit"),
				new Item("바나나","banana"),
				new Item("호박","pumpkin"),
				new Item("오이","cucumber"),	
		};
		
		ListView lv = (ListView)findViewById(R.id.listView1);
		
		//lif = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		MyAdapter adapter = new MyAdapter(getApplicationContext(),  item);
		
		lv.setAdapter(adapter);
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// parent : ListView
				// View : 각 행
				// id : getItemId를 통해 리턴하는 것
				Toast.makeText(getApplicationContext(), item[position].name + " : " + item[position].word , Toast.LENGTH_SHORT).show();
				
				// 1. 다음화면 작성(java, xml)
				// 2. 화면 Activity 를 등록 AndroidManifest.xml
				// 3. Intent 객체 생성해서 화면전환 startActivity();
				
			}
		});
	}

	
}

class Item {
	String name;
	String word;
	
	public Item( String name, String word) {
		super();
		this.name = name;
		this.word = word;
	}
	
}

class MyAdapter extends BaseAdapter {
	LayoutInflater lif;
	Item[] item;
	
	public MyAdapter(Context context,  Item[] item) {
		this.lif = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.item = item;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return item[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = lif.inflate(R.layout.mylayout, null);
		}
		TextView tv1 = (TextView)convertView.findViewById(R.id.textView1);
		TextView tv2 = (TextView)convertView.findViewById(R.id.textView2);
		RelativeLayout ll = (RelativeLayout)convertView.findViewById(R.id.relative);
		if ( position % 2 == 0 ){
			ll.setBackgroundColor(Color.CYAN);
		} else {
			ll.setBackgroundColor(Color.WHITE);
		}
		tv1.setText(item[position].name);
		tv2.setText(item[position].word);
		return convertView;
	}
	
}