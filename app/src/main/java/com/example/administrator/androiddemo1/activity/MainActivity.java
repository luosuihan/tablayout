package com.example.administrator.androiddemo1.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

import com.example.administrator.androiddemo1.R;

public class MainActivity extends FragmentActivity implements OnTabChangeListener {

	private FragmentTabHost mTabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initHost();
		initTab();
		mTabHost.onTabChanged(TabDb.getTabsTxt()[0]);
	}

	private void initTab() {
		String[] tabs = TabDb.getTabsTxt();
		for (int i = 0; i < tabs.length; i++) {
			TabSpec tabSpec = mTabHost.newTabSpec(TabDb.getTabsTxt()[i]);
			View view = LayoutInflater.from(this).inflate(R.layout.tabs_foot, null);
			((TextView) view.findViewById(R.id.foot_tv)).setText(TabDb.getTabsTxt()[i]);
			((ImageView) view.findViewById(R.id.foot_iv)).setImageResource(TabDb.getTabsImg()[i]);
			tabSpec.setIndicator(view);
			mTabHost.addTab(tabSpec,TabDb.getFramgent()[i],null);
		}
	}
	private void initHost() {
		mTabHost = (FragmentTabHost) findViewById(R.id.main_tab);
		mTabHost.setup(this, getSupportFragmentManager(),R.id.main_view);
		mTabHost.getTabWidget().setDividerDrawable(null);
		mTabHost.setOnTabChangedListener(this);
	}

	@Override
	public void onTabChanged(String arg0) {
		TabWidget tabw = mTabHost.getTabWidget();
		for (int i = 0; i < tabw.getChildCount(); i++) {
			View v = tabw.getChildAt(i);
			TextView tv = (TextView) v.findViewById(R.id.foot_tv); 
			ImageView iv = (ImageView) v.findViewById(R.id.foot_iv);
			if (i == mTabHost.getCurrentTab()) {
				tv.setTextColor(getResources().getColor(R.color.tab_light_color));
				iv.setImageResource(TabDb.getTabsImgLight()[i]);
			}else{
				tv.setTextColor(getResources().getColor(R.color.tab_color));
				iv.setImageResource(TabDb.getTabsImg()[i]);
			}
		}
	}
}
