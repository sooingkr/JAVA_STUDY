package com.example.calculationproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button plus;
	Button minus;
	Button mul;
	Button div;

	EditText num1;
	EditText num2;
	TextView result;

	int one;
	int two;
	int show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		mul = (Button) findViewById(R.id.mul);
		div = (Button) findViewById(R.id.div);

		num1 = (EditText) findViewById(R.id.num1);
		num2 = (EditText) findViewById(R.id.num2);
		result = (TextView) findViewById(R.id.resultCal);

		class MyClickEvent implements OnClickListener {
			@Override
			public void onClick(View v) {
				int id = v.getId();

				one = Integer.parseInt(num1.getText().toString());
				two = Integer.parseInt(num2.getText().toString());

				if ( v.getId() == R.id.plus ){
					show = one + two;
				} else if ( v.getId() == R.id.minus){
					show = one - two;
				} else if (v.getId() == R.id.mul ){
					show = one * two;
				} else if (v.getId() == R.id.div){
					show = one / two;
				}
			
				
				result.setText(show+"");
			}
		} // end of MyClickEvent

		MyClickEvent e = new MyClickEvent();
		plus.setOnClickListener(e);
		minus.setOnClickListener(e);
		mul.setOnClickListener(e);
		div.setOnClickListener(e);

	}
}
