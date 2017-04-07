package com.example.showmethemajak;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

public class Game extends Activity {
	Animation anim;
	int[] al = new int[] { R.drawable.size1, R.drawable.size2, R.drawable.size3, R.drawable.size4, R.drawable.size5,
			R.drawable.size6, R.drawable.size7, R.drawable.size8, };
	int[] id = new int[] { R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4,
			R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9,
			R.id.imageButton10, R.id.imageButton11, R.id.imageButton12, R.id.imageButton13, R.id.imageButton14,
			R.id.imageButton15, R.id.imageButton16,

	};
	RotateAnimation rotateAnimation ;
	RotateAnimation rotateAnimation2;
	ScaleAnimation scaleAnimation;
	
	int[] store = new int[2];
	static int cnt = 0;
	HashMap<Integer, Integer> imgArr = new HashMap<Integer, Integer>();
	ImageButton temp;
	 ImageButton temp2;
	ImageButton[] button = new ImageButton[16];

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		for (int i = 0; i < button.length; i++) {
			button[i] = (ImageButton) findViewById(id[i]);
		}

		////////////////////////////////////////
		// 랜덤
		for (int i = 0; i < button.length * 2; i++) {
			int index = (int) (Math.random() * 16);
			ImageButton temp = button[1];
			button[1] = button[index];
			button[index] = temp;
		}
		int j = 0;
		for (int i = 0; i < button.length; i++, j++) {
			if (j > al.length - 1) {
				j = 0;
			}
			button[i].setImageResource(al[j]);
			imgArr.put(button[i].getId(), al[j]);
		}

		/////////////////
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < button.length; i++) {
					button[i].setImageResource(R.drawable.ic_launcher);
				}
			}
		}, 1000);
		////////////////

		class MyEvent implements OnClickListener {

			@Override
			public void onClick(View v) {
				if (cnt == 2)
					cnt = 0;

				int id = v.getId();
				ImageButton btn = (ImageButton) findViewById(id);
				btn.setImageResource(imgArr.get(id));
				store[cnt] = id;
				scaleAnimation = (ScaleAnimation)AnimationUtils.loadAnimation(
						Game.this, R.anim.small); 
				
				if (cnt == 1) {
					/////////////////애니메이션
					if (imgArr.get(store[cnt]).intValue() != imgArr.get(store[cnt - 1]).intValue()) {

						rotateAnimation = (RotateAnimation)AnimationUtils.loadAnimation(
								Game.this,R.anim.rotate);
						rotateAnimation2 = (RotateAnimation)AnimationUtils.loadAnimation(
								Game.this,R.anim.rotate2);
						temp = (ImageButton) findViewById(store[cnt]);
						 temp2 = (ImageButton) findViewById(store[cnt - 1]);
						 
									temp.setAnimation(rotateAnimation);
									temp2.setAnimation(rotateAnimation);
									
									new Handler().postDelayed(new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
										
											temp.setAnimation(rotateAnimation2);
											temp2.setAnimation(rotateAnimation2);;

											temp.setImageResource(R.drawable.ic_launcher);
											temp2.setImageResource(R.drawable.ic_launcher);
											
										}
									},200);
									
									//////////////////애니메이션
						new Handler().postDelayed(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
					
								temp.setImageResource(R.drawable.ic_launcher);
								temp2.setImageResource(R.drawable.ic_launcher);
								
							}
						},900);
						
						
					}
					else if(imgArr.get(store[cnt]).intValue() == imgArr.get(store[cnt - 1]).intValue())
					{
						temp = (ImageButton) findViewById(store[cnt]);
						 temp2 = (ImageButton) findViewById(store[cnt - 1]);
						temp.setAnimation(scaleAnimation);
						temp2.setAnimation(scaleAnimation);
					}
					
				
				}
				cnt++;

			}
			
		} // end of myevent

		MyEvent e = new MyEvent();
		for (int i = 0; i < button.length; i++) {
			button[i].setOnClickListener(e);
		}
		
	}//end onCreate

}
