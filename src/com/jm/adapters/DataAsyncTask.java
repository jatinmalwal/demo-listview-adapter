package com.jm.adapters;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

public class DataAsyncTask extends AsyncTask<Integer, Void, String> {

	private Button btnlike;
	private ArrayList<DataModel> dataModels;

	public DataAsyncTask(View v, ArrayList<DataModel> dataModels) {
		btnlike = (Button) v;
		this.dataModels = dataModels;
	}

	@Override
	protected String doInBackground(Integer... params) {
		dataModels.get(params[0]).setLike(!dataModels.get(params[0]).isLike());
		if (dataModels.get(params[0]).isLike()) {
			return "success";
		} else {
			return "failure";
		}
	}

	@Override
	protected void onPostExecute(String result) {

		if (result.equalsIgnoreCase("success")) {

			btnlike.setText("Like");

		} else if (result.equalsIgnoreCase("failure")) {

			btnlike.setText("Unlike");

		}
		
		//Now here I got stuck
		//How can I set visibilty of any other item(like say txtID) of the same position i clicked like  

		super.onPostExecute(result);
	}

}
