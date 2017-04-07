package com.example.a01_helloworld;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ImgReadFromPhone extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_read_from_phone);
		
		ImageView iv = (ImageView)findViewById(R.id.haha);
		
		// 스마트폰의 이미지 읽어오기 => 핸드폰으로부터 가져오는 것임으로 권한 설정이 필요하다.(보안상)
		Bitmap bm = BitmapFactory.decodeFile("/mnt/sdcard/");
		iv.setImageBitmap(bm); // 읽어온 이미지 파일 출력
	}

}
