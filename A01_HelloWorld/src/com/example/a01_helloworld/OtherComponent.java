package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class OtherComponent extends Activity {

	EditText id;
	EditText pwd;
	EditText result2;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_component);

		id = (EditText) findViewById(R.id.id);
		pwd = (EditText) findViewById(R.id.pwd);
		result2 = (EditText) findViewById(R.id.result);
		b = (Button) findViewById(R.id.login);

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String strID = id.getText().toString();
				String strPW = pwd.getTag().toString();
				String result = "";
				if ( !"sooingkr".equals(strID) ){
					result = "ID 가 틀렸습니다. 다시 확인하세요.";
				}else if ( !"1234".equals(strPW) ){
					result = "PWD가 틀렸습니다. 다시 확인하세요.";
				}else{
					result = "로그인 성공";
				}
				result2.setText(result);
			}
		});
	}

}
