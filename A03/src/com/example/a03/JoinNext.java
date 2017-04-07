package com.example.a03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class JoinNext extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_next);
		
		final TextView tv = (TextView)findViewById(R.id.jt);
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int age = intent.getIntExtra("age", 0);
		String address = intent.getStringExtra("address");
		boolean sex = intent.getBooleanExtra("sex", true);
		
		
		Man m = (Man)intent.getSerializableExtra("obj");
		
		
		tv.setText("이름 : " + m.name
					+	"\n나이 : " + m.strAge
					+ "\n주소 : " + m.address
					+ "\n성별 : " + (m.strSex ? "남자" : "여자" )
						
				);
		
	}
	

}
