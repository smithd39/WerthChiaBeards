package com.relldesigns.werthchiabeards;


import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnTest = (Button) findViewById(R.id.btnCalc);
		btnTest.setEnabled (false);

		btnTest.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				//declare, find and cast various edit texts 
				final EditText etPlain = (EditText) findViewById(R.id.editText1); //name
				EditText etEmail = (EditText) findViewById(R.id.editText2); //email
				EditText etNumber = (EditText) findViewById(R.id.etNumber); //widgets
				CheckBox chkMember = (CheckBox) findViewById(R.id.chkBox); //checkbox
				
				//etNumber has inputType of number -- user should only be able to type in numbers 

				Integer numInteger = Integer.valueOf(etNumber.getText().toString());

				//getText from editTexts -- need to use toString 
				String strPlain = etPlain.getText().toString();
				String strNumber = etNumber.getText().toString();
				double widgetCost = 49.99;

				// convert the text from etNumber to an integer variable 
				double intNumber = Double.parseDouble(strNumber);

				if(chkMember.isChecked()){
					intNumber = intNumber * widgetCost;
					intNumber = intNumber - (30.0/100*intNumber);
				}
				else {			
					intNumber *= widgetCost;

				}
			

				//declare, find and cast various a textview to display the results 
				TextView tvResult = (TextView) findViewById(R.id.tvResult);
					
				//prepare output
				String strResult="$ ";		
				//strResult = "Plain: " + strPlain +"\n";
				strResult += Double.toString(intNumber); //"Twice the number: " +
				//convert back to a string to concatenate

				//display result
				
				tvResult.setText(String.format("$%.2f",intNumber));	

				
			}//end onClick method
			
		}); //end OnClickListener
		
		final EditText etNumber = (EditText) findViewById(R.id.etNumber); //widgets
		etNumber.addTextChangedListener (new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				Button btnTest = (Button) findViewById(R.id.btnCalc);

				if(etNumber.getText().toString().length()> 0)
				{
					btnTest.setEnabled(true);
				}
				else{
					btnTest.setEnabled(false);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

		});

		CheckBox chkMember = (CheckBox) findViewById(R.id.chkBox); //checkbox
		chkMember.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				TextView tvResult = (TextView) findViewById(R.id.tvResult); 
				tvResult.setText("");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

