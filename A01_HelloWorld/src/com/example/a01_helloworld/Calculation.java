package com.example.a01_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Calculation extends Activity {

	Button plus;
	Button minus;
	Button mul;
	Button div;

	TextView num1;
	TextView num2;
	TextView result;

	static int one;
	static int two;
	static int show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculation);

		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		mul = (Button) findViewById(R.id.mul);
		div = (Button) findViewById(R.id.div);

		num1 = (TextView) findViewById(R.id.num1);
		num2 = (TextView) findViewById(R.id.num2);
		result = (TextView) findViewById(R.id.resultCal);

		class MyClickEvent implements OnClickListener {
			@Override
			public void onClick(View v) {
				int id = v.getId();
				
				one = Integer.parseInt( num1.getText().toString() );
				two = Integer.parseInt( num2.getText().toString() );
				switch (id) {
				case R.id.plus:
					show = one + two;
					break;
				case R.id.minus:
					show = one - two;
					break;
				case R.id.mul:
					show = one * two;
					break;
				case R.id.div:
					show = one / two;
					break;
				default:
					break;
				}
				result.setText(show);
			}
		} // end of MyClickEvent
		
		MyClickEvent e = new MyClickEvent();
		plus.setOnClickListener(e);
		minus.setOnClickListener(e);
		mul.setOnClickListener(e);
		div.setOnClickListener(e);
		
	}

}
