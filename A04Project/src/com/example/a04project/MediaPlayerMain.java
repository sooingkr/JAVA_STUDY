package com.example.a04project;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaPlayerMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_player_main);

		// [ 안드로이드의 소리는 "긴 소리" , "짧은 소리"에 따라 두가지로 나뉜다.
		// 기준 : 16MB
		// - 긴소리 : MediaPlayer : ex)배경음
		// - 짧은소리 : SoundPool : ex)총소리

		// 짧은 소리 재생
		final SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0); // 0
																				// :
																				// 음질
																				// 기본값
		// 최대 음악 개수, 타입, 음질
		final int soundID1 = sp.load(this, R.raw.gun, 1);
		final int soundID2 = sp.load(this, R.raw.cat, 1);

		final Button b1 = (Button) findViewById(R.id.b1);
		final Button b2 = (Button) findViewById(R.id.b2);
		final Button b3 = (Button) findViewById(R.id.b3);
		final Button b4 = (Button) findViewById(R.id.b4);
		final Button b5 = (Button) findViewById(R.id.b5);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundID1, // 로딩해놓은 음악파일 -> return 실패시 0 성공시 해당 파일의id를 반환
						1, // 왼쪽 볼륨 : 0.0f(작은) ~ 1.0f(큰)
						1, // 오른쪽 볼륨
						0, // 우선순위 : int
						0, // 반복횟수 : 0(노반복), -1(무한반복), 양의정수 : 반복 횟수
						1); // 재생속도(몇배속) : 0.5f ~ 2.0f
			}
		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundID1, // 로딩해놓은 음악파일
						1, // 왼쪽 볼륨 : 0.0f(작은) ~ 1.0f(큰)
						0, // 오른쪽 볼륨
						0, // 우선순위 : int
						0, // 반복횟수 : 0(노반복), -1(무한반복), 양의정수 : 반복 횟수
						2.0f); // 재생속도(몇배속) : 0.5f ~ 2.0f
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundID1, // 로딩해놓은 음악파일
						0, // 왼쪽 볼륨 : 0.0f(작은) ~ 1.0f(큰)
						1, // 오른쪽 볼륨
						0, // 우선순위 : int
						0, // 반복횟수 : 0(노반복), -1(무한반복), 양의정수 : 반복 횟수
						0.5f); // 재생속도(몇배속) : 0.5f ~ 2.0f
			}
		});
	}

}
