package com.example.a04project;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaPlayer2 extends Activity {
	MediaPlayer mp;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	int position; // 노래의 재생중인 위치 ms단위

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_player2);

		b1 = (Button) findViewById(R.id.bb1);
		b2 = (Button) findViewById(R.id.bb2);
		b3 = (Button) findViewById(R.id.bb3);
		b4 = (Button) findViewById(R.id.bb4);

		// 주로 긴 음악을 재생할 때 사용한다. 16MB 이상
		b1.setEnabled(true); // 시작버튼만 클릭할 수 있도록 (맨처음)
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 재생
				b1.setEnabled(false); // 시작 또 못하도록
				b2.setEnabled(true);
				b3.setEnabled(false); // 재시작도 비활성화
				b4.setEnabled(true);
				// mp.isPlaying(); // 현재 재생중인지 여부를 리턴

				mp = MediaPlayer.create(getApplicationContext(), R.raw.ddd);
				mp.setLooping(false); // 반복재생 안함

				mp.start();

			}
		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 일시 정지
				b2.setEnabled(false); // 일시정지 꺼지고
				b1.setEnabled(true); // 시작 가능
				b3.setEnabled(true);
				b4.setEnabled(true);
				position = mp.getCurrentPosition(); // 어디까지 노래가 진행됐는지를 가지고
													// 옴(재시작시 이 위치부터 시작하기 위해
													// 기억해둠)
				mp.pause();
			}
		});
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 재시작
				b1.setEnabled(false); // 시작 또 못하도록
				b2.setEnabled(true);
				b3.setEnabled(false); // 재시작도 비활성화
				b4.setEnabled(true);

				mp.seekTo(position); // 멈췄던 지점으로 이동 후
				mp.start();
			}
		});

		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 종료
				b1.setEnabled(true);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				mp.stop();
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// 화면의 일부가 가려졌을 때 호출되는 콜백 메서드
		if (mp != null) {
			mp.stop(); // 시작누르지 않은 상태에서 호출될 시 이 부분없으면 NullPointException 발생 가능
			b1.setEnabled(true);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
		}
	}
}
