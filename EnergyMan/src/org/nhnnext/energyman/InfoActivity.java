package org.nhnnext.energyman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class InfoActivity extends Activity {

ListView listView;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		listView = (ListView) findViewById(R.id.listInfo);
		listView.setAdapter(new FoodAdapter(this));
	}
	
	class FoodAdapter extends BaseAdapter {
		private final Context context;
		
		public FoodAdapter(Context context) {
			this.context = context;
		}
		
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int position) {
			return new Object();
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if(position == 0) view = inflater.inflate(R.layout.main_item, parent, false);
		else view = inflater.inflate(R.layout.list_item, parent, false);

		return view;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		
		return true;
	}
}
