package org.nhnnext.energyman;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class GoalActivity extends Activity {

	TextView goalText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acivity_goal);
		
		SeekBar goalSeek = (SeekBar) findViewById(R.id.seekBar1);
		goalText = (TextView) findViewById(R.id.textViewGoal);
		
		goalSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				goalText.setText(arg1 + "kWh");
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
