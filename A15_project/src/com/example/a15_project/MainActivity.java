package com.example.a15_project;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		final ImageView imgView = (ImageView)findViewById(R.id.imageView1);
		imgView.setBackgroundResource(R.drawable.frame_animation);
		
		AnimationDrawable frameAnimation = (AnimationDrawable) imgView.getBackground();
		frameAnimation.start();

		final ImageView imgView2 = (ImageView)findViewById(R.id.imageView2);
		imgView.setBackgroundResource(R.drawable.frame_animation2);
		
		AnimationDrawable frameAnimation2 = (AnimationDrawable) imgView.getBackground();
		frameAnimation2.start();

	}

}