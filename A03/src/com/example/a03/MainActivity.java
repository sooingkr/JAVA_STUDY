package com.example.a03;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

	Timer timer;
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 시간 끌기 : 아래꺼안해주면 시간끌어지지 않음 why?? onCreate에서 시간끌어바야 화면출력은 onStart->
		// onResume까지 수행 후에 뜨기 때문에
		// 화면을 그리지 않은채로 시간을 지연시키게 된다.
		// 큐에 넣어놓고 작업하도록 예약하는 방식으로 해결가능.

	/*	timer = new Timer(); // 예약하는 객체
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Intent it = new Intent(MainActivity.this, Move.class);
				startActivity(it);
				finish(); // 현재 액티비티를 종료함(뒤로가기 누르면 뜨니까)
				
				// 화면에서 빠져나가 전화등을 해도 3초 후에 실행되게 됨으로 onPause 상태가 되면 취소하도록 해주어야 함.
			}
		}, 3000); // 3초 후에 task 수행
		// 	timer.cancel(); // 앱 화면을 빠져나가게 되는 경우는 3초 후에 수행되면 안됨으로 onPause시 캔슬작업이 필요.
*/
		/////////////////////////////////////////////////////
		
		/*// [ 아래 방법을 더 권장됨 ] : onCreate, onResume 두번 호출되도록 될 수 있음으로 onResume에만 수행하도록 해준다. 그러면 전화와 앱이 onPuase된 후 다시 실행하면 onResume상태로감으로
		 *  정상적으로 3초 뒤 화면전환이 이루어지게 할 수 있다.
		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent it = new Intent(MainActivity.this, Move.class);
				startActivity(it);
				finish(); // 현재 액티비티를 종료함
			}
		}, 3000);*/

	}

	@Override
	protected void onPause() { // 현재 화면의 일부가 가려질 때 호출
		super.onPause(); // 이거 지우면 오류남
//		timer.cancel();
		handler.removeMessages(0); // 예약 작업을 취소함
		// 다시 화면에 들어왔을 때 다시 호출될 수 있도록 해주어야 함 취소해버렸음으로...
	}
	
	@Override
	protected void onResume() { // 현재화면 일부가 가려져 onPause 된 상태에서 다시 앱이 화면에 나타날 때 호출되는 콜백 메서드.
		// TODO Auto-generated method stub
		super.onResume();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent it = new Intent(MainActivity.this, Move.class);
				startActivity(it);
				finish(); // 현재 액티비티를 종료함
			}
		}, 3000);
		// onCreate와 onResume에서 두번 호출이 되므로 두번그려주게됨 따라서 onCreate는 이 작업을 하지 않도록 함.
	}
}
