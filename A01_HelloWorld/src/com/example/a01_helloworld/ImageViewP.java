package com.example.a01_helloworld;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ImageViewP extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view_p);
		
		// 1. 프로젝트 리소스(res)를 가져오기
		// iv.setImageResource(R.drawable.pdf);
		
		// 2. drawable 객체 사용
		//Drawable drawable = getResources().getDrawable(R.drawable.pdf);
		// iv.setImageDrawable(drawable);
		
		// 3. Bitmap 객체 사용 ( Internet에 있는 이미지 얻어올 때 유리)
		// Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.pdf)
		// iv.setImageBitmap(bm);
	}

}
