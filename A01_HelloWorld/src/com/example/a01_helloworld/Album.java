package com.example.a01_helloworld;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Album extends Activity {

	Button next;
	Button prev;
	ImageView img;
	int n = 0;
	int[] al = new int[3];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_album);
		
		
		al[0] = R.drawable.mario;
		al[1] =R.drawable.bird;
		al[2] =	R.drawable.water; 
		
		next = (Button)findViewById(R.id.next);
		prev = (Button)findViewById(R.id.prev);
		img = (ImageView)findViewById(R.id.albumImg);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if ( v.getId() == R.id.next ){
					n++;
					if ( n > al.length-1 ){
						n = 0;
					}
					
				}
				if ( v.getId() == R.id.prev ){
					n--;
					if ( n < 0 ) n = (al.length - 1);
				}
				img.setImageResource(al[n]);
			}
		});
		
		prev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if ( v.getId() == R.id.next ){
					n++;
					if ( n > al.length-1 ){
						n = 0;
					}
					
				}
				if ( v.getId() == R.id.prev ){
					n--;
					if ( n < 0 ) n = (al.length - 1);
				}
				img.setImageResource(al[n]);
			}
		});
				
	}

}
