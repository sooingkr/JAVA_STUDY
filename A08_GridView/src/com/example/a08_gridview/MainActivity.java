package com.example.a08_gridview;

import java.io.Serializable;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 1. 다량의 데이터
		// 2. AdaterView 선언
		// 3. Adapter 생성, 설정 ( 한 셀을 디자인한 layout)
		
		PoketMon[] poketmon = {
				new PoketMon(R.drawable.size1,"size1"),
				new PoketMon(R.drawable.size2,"size2"),
				new PoketMon(R.drawable.size3,"size3"),
				new PoketMon(R.drawable.size4,"size4"),
				new PoketMon(R.drawable.size5,"size5"),
				new PoketMon(R.drawable.size6,"size6"),
		};
		
		final GridView gv = (GridView)findViewById(R.id.gridView1);
		
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.mylayout, poketmon);
		
		gv.setAdapter(adapter);
	}

}

class PoketMon implements Serializable{
	int img;
	String name = "";
	
	public PoketMon(int img, String name) {
		super();
		this.img = img;
		this.name = name;
	}
	 
}

class MyAdapter extends BaseAdapter {

	LayoutInflater lf;
	int mylayout;
	PoketMon[] poketmon;
	
	public MyAdapter(Context applicationContext, int mylayout, PoketMon[] poketmon) {
		this.lf = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mylayout = mylayout;
		this.poketmon = poketmon;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return poketmon.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return poketmon[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = lf.inflate(mylayout, null);
		}
		ImageView img1 = (ImageView) convertView.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) convertView.findViewById(R.id.imageView2);
		img1.setImageResource(poketmon[position].img);
		return convertView;
	}
	
}