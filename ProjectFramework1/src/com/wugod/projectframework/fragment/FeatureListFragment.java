package com.wugod.projectframework.fragment;

import java.util.ArrayList;
import java.util.List;

import com.wugod.projectframework.R;
import com.wugod.projectframework.widget.DividerItemDecoration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.method.ArrowKeyMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeatureListFragment extends Fragment {
	public final String TAG = this.getClass().getSimpleName();

	RecyclerView recyclerView;
	List<String> dataStrings;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_feature_list, container,
				false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		init(getView());
		recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView
				.getContext()));
		dataStrings = new ArrayList<String>();
		loadData();
		FeatureListAdapter adapter = new FeatureListAdapter(getActivity(),
				dataStrings);
		recyclerView.setAdapter(adapter);
		recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
				DividerItemDecoration.VERTICAL_LIST));
	}

	private void loadData() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 20; i++) {
			dataStrings.add("item" + i);
		}
	}

	private void init(View parentView) {
		// TODO Auto-generated method stub

		recyclerView = (RecyclerView) parentView
				.findViewById(R.id.recyclerview);
	}

	class FeatureListAdapter extends Adapter<MyViewHolder> {
		Context c;
		List<String> list;

		public FeatureListAdapter(Context c, List<String> list) {
			// TODO Auto-generated constructor stub
			this.c = c;
			this.list = list;
		}

		@Override
		public int getItemCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, int position) {
			// TODO Auto-generated method stub

			holder.titleText.setText(list.get(position));
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			// TODO Auto-generated method stub
			MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(
					getActivity()).inflate(R.layout.item_fearure_list, parent,
					false));
			return myViewHolder;
		}
	}

	class MyViewHolder extends ViewHolder {
		TextView titleText;

		public MyViewHolder(View view) {
			super(view);
			// TODO Auto-generated constructor stub
			titleText = (TextView) view.findViewById(R.id.titleText);
		}

	}
}
