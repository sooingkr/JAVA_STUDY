package com.example.a01_helloworld;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class LifeCycle extends Activity {



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life_cycle, menu);
		
		Log.d("LifeCycle", "onCreate"); // tag, message
		/*
		 * 		[	생명주기  ]
		 * 		 onCreate()
		 * 				|
		 * 		 onStart()
		 * 				|
		 * 		 onResume() : onPause로 가려졌던 화면이 없어지고 다시 화면을 띄워줄 때 : onPause에서 저장한 데이터를 복구시켜주는 작업 필요.
		 * 				|
		 * 		 Activity Running
		 * 				|
		 * 		 onPause() : 액티비티 화면의 일부가 가려졌을 때 호출됨 : 현재 상태 저장이 필요.
		 * 				|
		 * 		 onStop() : 액티비티 화면이 다른 화면에 의해 완전히 가려졌을 때 호출됨. 다시 화면으로 돌아갈 떈 onRestart를 거쳐 onStart()를 호출
		 * 				|
		 * 		 onDestroy() : 메모리에서 자원을 해제
		 * 				|
		 * 		 Shut Down
		 * 			
		 * 
		 * 
		 * 
		 * 		Activity LifeCycle 메서드 : on~ ()
		 * 		: 각 메서드에는 super.on~() 자신의 부모메서드를 호출하는 코드(지우면 안됨)
		 * 		
		 * 
		 * 		** 화면을 가로로 돌리면 onPause -> onStop -> onDestroy 한 뒤 onCreate -> onStart -> onResume 순으로 다시 호출해 그려주게 됨.
		 */
		
		return true;
	} // end of onCreate


	
	// onStart
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("LifeCycle","onStart");
	}
	
	// onResume
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("LifeCycle","onResume");
	}
	
	// onPause
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("LifeCycle","onPause");
	}
	
	// onStop
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("LifeCycle","onStop");
	}
} // end of class
