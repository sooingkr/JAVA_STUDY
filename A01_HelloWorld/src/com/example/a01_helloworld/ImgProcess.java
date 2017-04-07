package com.example.a01_helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/*
 * 		1. 버튼 클릭해서 다운로드 하는 중엔 누르지 못하게 enable false
 * 		2. 이미지가 변경되고 나면, 버튼을 비활성화를 활성화로 변경
 * 		3. 태극기 이외에도 6개의 이미지가 돌아가며 나오게
 */
public class ImgProcess extends Activity {
	
	Handler handler = new Handler();  // 별도의 쓰레드에서 화면을 변경하려고 할 때 사용된다.
	String[] urls = new String[]{
			"https://cafeptthumb-phinf.pstatic.net/20140826_2/minsseam_1409063115830BpOeg_PNG/korea.png?type=w740",
			"https://cafeptthumb-phinf.pstatic.net/20140826_73/minsseam_1409063115379HHO89_PNG/canada.png?type=w740",
			"https://cafeptthumb-phinf.pstatic.net/20140826_72/minsseam_1409063115656jokHG_PNG/france.png?type=w740",
			"https://cafeptthumb-phinf.pstatic.net/20140826_229/minsseam_1409063115937R8O0i_PNG/mexico.png?type=w740",
			"https://cafeptthumb-phinf.pstatic.net/20140826_279/minsseam_1409063116122Xhfah_PNG/poland.png?type=w740",
			"https://cafeptthumb-phinf.pstatic.net/20140826_37/minsseam_1409063116289y7hzS_PNG/saudi_arabia.png?type=w740"
	};
	int n = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_process);

		final TextView tv = (TextView)findViewById(R.id.ToastView);
		Button b1 = (Button)findViewById(R.id.ToastBtn);
		b1.setOnClickListener(new OnClickListener() {
			int cnt;
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "클릭함", Toast.LENGTH_SHORT).show();
				tv.setText(cnt++ + "");
			}
		});
		
		
		
		// 인터넷에서 이미지 파일을 가져오기
		// 1. 권한을 얻어와야 한다. (권한 설정) <uses-permission android:name="android.permission.INTERNET" />
		// 2. 별도의 쓰레드에서 인터넷에 접속해서 이미지를 다운받아오는 작업을 해야한다.(3.0 버전부턴 의무) : 오래걸리는 작업은 거기서 수행하다 멈춰있으면 사용자의 화면이 정지해 버리니까
		// 3. 쓰레드로 작업한 걸 사용자의 화면을 변경할려면 Handler를 사용해야 한다.(작업 큐에 등록해야함) 
		
		final Button b2 = (Button)findViewById(R.id.downBtn);
		final ImageView iv = (ImageView)findViewById(R.id.imgV);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b2.setEnabled(false); // 다운 중엔 못 누르게 비활성화
				// 버튼 클릭시 웹에서 이미지 파일을 받아와서 화면에 이미지를 변경시켜 주기
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() { // 별도의 쓰레드에서 해야할 작업을 기술
						try {
							
							if ( n > urls.length-1 ){
								n = 0;
							}
							
							URL url = new URL( urls[n++] );
							
							// Internet 접속을 위해 사용되는 URL 객체
							//URL url = new URL("https://cafeptthumb-phinf.pstatic.net/20140826_2/minsseam_1409063115830BpOeg_PNG/korea.png?type=w740");
							InputStream is = url.openStream(); // InputStream을 얻어옴.
							final Bitmap bm = BitmapFactory.decodeStream(is);
							
							//iv.setImageBitmap(bm); // 에러
							// 별도의 쓰레드에서 핸들러를 이용하지 않고 화면을 변경하면 에러가 발생함.
							// 따라서 별도의 쓰레드에서 화면을 변경하고자 한다면 "핸들러"를 사용해야 한다.
							handler.post(new Runnable() { // Runnable : 해야할 작업을 큐에 등록
								 
								@Override
								public void run() {
									iv.setImageBitmap(bm);
									b2.setEnabled(true); // 다시 누를 수 있게 활성화
								}
							}); // post : 수행가능하면 바로 수행해 주세요라는 의미의 메서드
							
							is.close();
						} catch (MalformedURLException e) {
							Log.d("www","URL 경로로 파싱 불가");
						} catch (IOException e) {
							Log.d("www","InputStream 을 열지 못함");
						}
					}
				});
				t.start();
			}
		});
	
	} // end of onCreate

}
