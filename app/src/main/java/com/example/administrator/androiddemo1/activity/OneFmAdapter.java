package com.example.administrator.androiddemo1.activity;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class OneFmAdapter extends FragmentPagerAdapter {

	private List<Fragment> fmList;
	private FragmentManager fm;

	public OneFmAdapter(FragmentManager fm,List<Fragment> fmList) {
		super(fm);
		this.fm = fm;
		this.fmList = fmList;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fmList.get(arg0%fmList.size());
	}

	@Override
	public int getCount() {
		return fmList.size();
	}
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}
