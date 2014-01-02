package com.jm.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class DataAdaptor extends BaseAdapter {

	private Context context;
	private ArrayList<DataModel> dataModels;

	public DataAdaptor(Context context, ArrayList<DataModel> dataModels) {
		this.context = context;
		this.dataModels = dataModels;
	}

	@Override
	public int getCount() {
		return dataModels.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		public TextView txtID;
		public Button btnLike;
	}

	@Override
	public View getView(final int position, View view, ViewGroup viewGroup) {

//		Log.d("Jatin", "position" + position);

		View row = view;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.item_list, viewGroup, false);
			ViewHolder holder = new ViewHolder();
			holder.txtID = ((TextView) row.findViewById(R.id.txt_item_id));
			holder.btnLike = ((Button) row.findViewById(R.id.btn_item_like));
			row.setTag(holder);

			// See Here
			// Doing this just because I have no way of getting these foll.
			// variables in annomous class of btnLike Click Listener without
			// using FINAL
//			holder.btnLike.setId(position); // Doing this to send id I have
											// clicked in liskt view
		}

		ViewHolder holder = (ViewHolder) row.getTag();
		TextView txtID = holder.txtID;
		Button btnLike = holder.btnLike;
		DataModel dataModel = dataModels.get(position);

		txtID.setText(String.valueOf(dataModel.getId()));

		if (dataModel.isLike()) {
			btnLike.setText("Like");
		} else {
			btnLike.setText("Unlike");
		}

		btnLike.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// look carefully here
				Log.d("Jatin", "id" + v.getId());
				new DataAsyncTask(v, dataModels).execute(position);
			}
		});

		return row;
	}

}
