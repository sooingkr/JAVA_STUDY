package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxP extends Activity {

	CheckBox b1;
	CheckBox b2;
	TextView tv;
	Button submit;
	String txt = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_p);

		b1 = (CheckBox) findViewById(R.id.checkBox1);
		b2 = (CheckBox) findViewById(R.id.checkBox2);
		tv = (TextView) findViewById(R.id.confirm);
		submit = (Button) findViewById(R.id.submit);

		// 체크가 된 상태 읽어오기
		b1.isChecked();
		b1.getText().toString();

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				txt = "";
				if (b1.isChecked()) {
					txt += (b1.getText().toString() + " ");
				}
				if (b2.isChecked()) {
					txt += (b2.getText().toString() + " ");
				}
				tv.setText("선택된 값 : " + txt);
			}
		});

		/*class MyCheckedEvent implements OnCheckedChangeListener {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				Toast.makeText(getApplicationContext(), buttonView.getText() + "버튼" + (isChecked ? " 선택" : " 해제"),
						Toast.LENGTH_SHORT).show();
			}

		}

		MyCheckedEvent p = new MyCheckedEvent();
		b1.setOnCheckedChangeListener(p);
		b2.setOnCheckedChangeListener(p);
*/
		
		b1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), b1.getText() + "버튼" + (isChecked ? "선택" : "해제"),
						Toast.LENGTH_SHORT).show();
			}
		});
		//
		b2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), b2.getText() + "버튼" + (isChecked ? "선택" : "해제"),
						Toast.LENGTH_SHORT).show();
			}
		});

	}

}
