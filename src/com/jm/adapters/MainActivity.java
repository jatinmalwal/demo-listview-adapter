package com.jm.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<DataModel> dataModels;
	private ListView listView;
	private DataAdaptor dataAdaptor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		// fill default values
		dataModels = new ArrayList<DataModel>();
		for (int i = 0; i < 40; i++) {
			dataModels.add(new DataModel(i, false));
		}
		
		listView=((ListView)findViewById(R.id.list));
		dataAdaptor=new DataAdaptor(this, dataModels);
		
		listView.setAdapter(dataAdaptor);
	}

}
