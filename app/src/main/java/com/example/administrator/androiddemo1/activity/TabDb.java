package com.example.administrator.androiddemo1.activity;

import com.example.administrator.androiddemo1.R;

public class TabDb {
	/***
	 * 获得底部所有项
	 */
	public static String[] getTabsTxt() {
		String[] tabs = {"首页","交易","地点","我的"};
		return tabs;
	}
	/***
	 * 获得所有碎片
	 */
	public static Class[] getFramgent(){
		Class[] cls = {OneFm.class,TwoFm.class,ThreeFm.class,FourFm.class};
		return cls ;
	}
	/***
	 * 获得所有点击前的图片
	 */
	public static int[] getTabsImg(){
		int[] img = {R.drawable.home1,R.drawable.glod1, R.drawable.xc1,R.drawable.user1};
		return img ;
	}
	/***
	 * 获得所有点击后的图片
	 */
	public static int[] getTabsImgLight(){
		int[] img = {R.drawable.home2,R.drawable.glod2,R.drawable.xc2,R.drawable.user2};
		return img ;
	}
}
