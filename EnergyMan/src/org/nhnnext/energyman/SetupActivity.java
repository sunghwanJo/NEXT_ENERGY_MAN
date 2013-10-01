package org.nhnnext.energyman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class SetupActivity extends Activity {
	private ArrayAdapter<CharSequence> areaSpin, typeSpin, incomeSpin;	// 면적, 주택 형태, 소득
	private Spinner spinnerArea, spinnerType, spinnerIncome;			// 면적, 주택 형태, 소득 스피너
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_setup);

			Button nextButton = (Button) findViewById(R.id.button_next);
			
			spinnerArea = (Spinner) findViewById(R.id.spinner_area);
			spinnerType = (Spinner) findViewById(R.id.spinner_type);
			spinnerIncome = (Spinner) findViewById(R.id.spinner_income);
		
			areaSpin = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);
			typeSpin = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
			incomeSpin = ArrayAdapter.createFromResource(this, R.array.income, android.R.layout.simple_spinner_item);
		
			areaSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			typeSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			incomeSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
			spinnerArea.setAdapter(areaSpin);
			spinnerType.setAdapter(typeSpin);
			spinnerIncome.setAdapter(incomeSpin);
			
			spinnerArea.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { 
					//Toast.makeText(MainActivity.this, (CharSequence) spinnerArea.getItemAtPosition(position), Toast.LENGTH_LONG).show();
				}
				
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
			});
			
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { 
					//Toast.makeText(MainActivity.this, (CharSequence) spinnerType.getItemAtPosition(position), Toast.LENGTH_LONG).show();
				}
				
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
			});
			
			spinnerIncome.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { 
					//Toast.makeText(MainActivity.this, (CharSequence) spinnerIncome.getItemAtPosition(position), Toast.LENGTH_LONG).show();
				}
				
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
			});
			
			nextButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(getBaseContext(), MainActivity.class);
					startActivity(intent);
					finish();
				}
			});
		}
}
