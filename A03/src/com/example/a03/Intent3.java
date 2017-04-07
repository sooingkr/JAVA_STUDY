package com.example.a03;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intent3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent3);
		
		final EditText etName = (EditText)findViewById(R.id.editText1);
		final EditText etAge = (EditText)findViewById(R.id.editText2);
		final EditText etAddress = (EditText)findViewById(R.id.editText3);
		final EditText etSex = (EditText)findViewById(R.id.editText4);
		Button b = (Button)findViewById(R.id.submitButton);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = etName.getText().toString();
				String strAge = etAge.getText().toString();
				String address = etAddress.getText().toString();
				String strSex = etSex.getText().toString();
				
				if ( name.isEmpty() || strAge.isEmpty() || address.isEmpty() || strSex.isEmpty() ){
					Toast.makeText(getApplicationContext(), "정보를 입력하세요", Toast.LENGTH_SHORT).show();
					return;
				}
				
				int age = Integer.valueOf(strAge);
				boolean sex = Boolean.valueOf(strSex);
				
				
				
				Man man = new Man(name, strAge, address, sex);
				
				Intent intent = new Intent(getApplicationContext(), JoinNext.class);
				intent.putExtra("obj",man); // Serializable 명시 필요
				intent.putExtra("name", name);
				intent.putExtra("age", age);
				intent.putExtra("address", address);
				intent.putExtra("sex", sex);
				startActivity(intent);
			}
		});
	}

}
class Man implements Serializable{
	String name;
	String strAge;
	String address;
	boolean strSex;
	
	public Man(String name, String strAge, String address, boolean strSex) {
		this.name = name;
		this.strAge = strAge;
		this.address = address;
		this.strSex = strSex;
	}
}
