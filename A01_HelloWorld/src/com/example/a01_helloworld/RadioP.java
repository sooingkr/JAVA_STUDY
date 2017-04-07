package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioP extends Activity {

	RadioGroup rg;
	TextView tv;
	Button b;
	///////////////////
	RadioButton r0;
	RadioButton r1;
	RadioButton r2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_p);

		rg = (RadioGroup)findViewById(R.id.radioGroup1);
		tv = (TextView)findViewById(R.id.RadioResult);
		b = (Button)findViewById(R.id.RadioSubmit);
		/////////////////////
		
		r0 = (RadioButton)findViewById(R.id.radio0);
		r1 = (RadioButton)findViewById(R.id.radio1);
		r2 = (RadioButton)findViewById(R.id.radio2);
		
		///////////////////
		rg.getCheckedRadioButtonId(); // 선택된 버튼이 없으면 -1 , 선택된게 있으면 id값 리턴
	
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int id = rg.getCheckedRadioButtonId();
				if ( id == -1 ){
					tv.setText("제대로 선택해라");
				}
				RadioButton r = (RadioButton)findViewById(id);
				tv.setText(r.getText() + "을 선택함");
				/*String sel = "선택좀해봐!";
				if ( id == R.id.radio0){
					sel = "사과";
				}else if ( id == R.id.radio1 ){
					sel = "포도";
				}else if (id == R.id.radio2 ){
					sel = "딸기";
				}*/
			}
		});
		
		
		//////////////
		
		class MyEvent implements OnCheckedChangeListener {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), buttonView.getText() + "을 " + (isChecked ? "선택됨" : "해제됨"), Toast.LENGTH_SHORT).show();
				Log.d("Toast",buttonView.getText() + "을 " + (isChecked ? "선택됨" : "해제됨"));
			}
			
		}
		MyEvent e = new MyEvent();
		r0.setOnCheckedChangeListener(e);
		r1.setOnCheckedChangeListener(e);
		
		
	} // end of create

	
} // end of class
