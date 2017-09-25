package com.example.administrator.androiddemo1.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.administrator.androiddemo1.R;

public class OneFm extends Fragment implements OnPageChangeListener {

	private View view;
	private RadioGroup rg_;
	private ViewPager vp_;
	private HorizontalScrollView hv_;
	private List<Fragment> newsList = new ArrayList<Fragment>();
	private OneFmAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fm_one, container,false);
			rg_ = (RadioGroup) view.findViewById(R.id.one_rg);
			vp_ = (ViewPager) view.findViewById(R.id.one_view);
			hv_ = (HorizontalScrollView) view.findViewById(R.id.one_hv);
			rg_.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int id) {
					vp_.setCurrentItem(id);
				}
			});
			initTab(inflater);
			initView();
		}
		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeView(view);
		}
		return view;
	}
	private void initView() {
		//luosuihan
		List<HTab> hTabs = HTabDb.getSelected();
		for (int i = 0; i < hTabs.size(); i++) {
			OneFm1 fm1 = new OneFm1();
			Bundle bundle = new Bundle();
			bundle.putString("name", hTabs.get(i).getName());
			fm1.setArguments(bundle);
			newsList.add(fm1);
		}
		adapter = new OneFmAdapter(getActivity().getSupportFragmentManager(),newsList);
		vp_.setAdapter(adapter);
		vp_.setOffscreenPageLimit(2);
		vp_.setCurrentItem(0);
		vp_.setOnPageChangeListener(this);
	}
	private void initTab(LayoutInflater inflater) {
		List<HTab> hTabs = HTabDb.getSelected();
		for (int i = 0; i < hTabs.size(); i++) {
			RadioButton rbButton  = (RadioButton) inflater.inflate(R.layout.tab_rb, null);
			rbButton.setId(i);
			rbButton.setText(hTabs.get(i).getName());
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			rg_.addView(rbButton,params);
		}
		rg_.check(0);
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	@Override
	public void onPageSelected(int id) {
		setTab(id);
	}
	private void setTab(int id) {
		RadioButton rbButton = (RadioButton) rg_.getChildAt(id);
		rbButton.setChecked(true);
		int left = rbButton.getLeft();
		int width = rbButton.getMeasuredWidth();
		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int screenWidth = metrics.widthPixels;
		int len = left + width / 2 - screenWidth / 2;
		hv_.smoothScrollTo(len, 0);
	}
}
