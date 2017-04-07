package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonP extends Activity {

	CheckBox c1;
	ToggleButton t1;
	Switch sw1;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_button_p);

		c1 = (CheckBox) findViewById(R.id.checkBox1);
		t1 = (ToggleButton) findViewById(R.id.button1);
		sw1 = (Switch) findViewById(R.id.switch1);
		tv = (TextView) findViewById(R.id.showP);

		/*
		 * c1.isChecked(){
		 * 
		 * } t1.isChecked(){
		 * 
		 * } sw1.isChecked(){
		 * 
		 * }
		 */

		t1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), buttonView.getText().toString() + (isChecked ? " 체크됨" : " 해제됨"),
						Toast.LENGTH_SHORT).show();
			}
		});

		sw1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), buttonView.getText().toString() + (isChecked ? " 체크됨" : " 해제됨"),
						Toast.LENGTH_SHORT).show();
			}
		});
	
	}

	
}
