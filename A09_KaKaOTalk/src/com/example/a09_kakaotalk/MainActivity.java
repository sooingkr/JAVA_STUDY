package com.example.a09_kakaotalk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Kosta kosta[] = {new Kosta(R.drawable.choihyeonsik,"최현식","0"),
		        new Kosta(R.drawable.daeheejeong,"정대희","0"),
		        new Kosta(R.drawable.deokhwan,"박덕환","0"),
		        new Kosta(R.drawable.hanhyeyeon,"한혜연","0"),
		        new Kosta(R.drawable.jaewoopark,"박재우","0"),
		        new Kosta(R.drawable.jeongdarin,"정다린","0"),
		        new Kosta(R.drawable.jeongjaehwan,"정재환","0"),
		        new Kosta(R.drawable.jeongjinkeun,"정진근","0"),
		        new Kosta(R.drawable.jiyunsik,"지윤식","0"),
		        new Kosta(R.drawable.joboram,"조보람","0"),
		        new Kosta(R.drawable.junghongui,"정홍의","0"),
		        new Kosta(R.drawable.jungyuno,"정윤오","0"),
		        new Kosta(R.drawable.kangseungwon,"강승원","0"),
		        new Kosta(R.drawable.kimjaehyun,"김재현","0"),
		        new Kosta(R.drawable.kimjihyea,"김지혜","0"),
		        new Kosta(R.drawable.kimjihyebb,"김지혜","0"),
		        new Kosta(R.drawable.kimyongrea,"김용래","0"),
		        new Kosta(R.drawable.leedaehyoung,"이대형","0"),
		        new Kosta(R.drawable.leeyoonji,"이윤지","0"),
		        new Kosta(R.drawable.leeyoungmin,"이영민","0"),
		        new Kosta(R.drawable.younggwan,"김영관","0"),
		        new Kosta(R.drawable.minju,"김민주","0"),
		        new Kosta(R.drawable.minsseam,"민쌤","0"),
		        new Kosta(R.drawable.sangsuban,"반상수","0"),
		        new Kosta(R.drawable.seoheyunwoo,"서현우","0"),
		        new Kosta(R.drawable.seongyoon,"송승윤","0"),
		        new Kosta(R.drawable.seongyoon,"송승윤","0"),
		        new Kosta(R.drawable.yoonjuhee,"윤주희","0"),
		};
		
		ListView lv = (ListView)findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), kosta);
		
		lv.setAdapter(adapter);
		
		
		
	} // end of onCreate
} // end of class

class Kosta {
	
	int imgs;
	String name;
	String content;
	
	public Kosta(int imgs, String name, String content) {
		super();
		this.imgs = imgs;
		this.name = name;
		this.content = content;
	}
	
};

class MyAdapter extends BaseAdapter {
	Kosta[] kosta;
	LayoutInflater lf;
	GradientDrawable draw;
	
	public MyAdapter(Context context, Kosta[] kosta) {
		this.kosta = kosta;
		lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		draw = (GradientDrawable)context.getResources().getDrawable(R.drawable.radiusshape);



	}

	@Override
	public int getCount() {
		return kosta.length;
	}

	@Override
	public Object getItem(int position) {
		return kosta[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = lf.inflate(R.layout.mylayout, null);
		}
		
		TextView name = (TextView)convertView.findViewById(R.id.name);
		TextView content = (TextView)convertView.findViewById(R.id.content);
		ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);
		img.setCropToPadding(true);
		
		img.setImageResource( kosta[position].imgs );
		img.setBackground( draw);

		name.setText( kosta[position].name );
		content.setText( kosta[position].content );
		return convertView;
	}

}