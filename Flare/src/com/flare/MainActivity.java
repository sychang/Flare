package com.flare;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity {
	//Declare tab variables:
	ActionBar.Tab homeTab, manualTab, logTab;
	Fragment homeFragment = new HomeFragment();
	Fragment manualFragment = new ManualFragment();
	Fragment logFragment = new LogFragment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Get ActionBar:
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//Set titles for tabs (can also set icons):
		/*homeTab = actionBar.newTab().setIcon(R.drawable.homeTabIcon);*/
		homeTab = actionBar.newTab().setText(getString(R.string.home_tab_title));
		manualTab = actionBar.newTab().setText(getString(R.string.manual_tab_title));
		logTab = actionBar.newTab().setText(getString(R.string.log_tab_title));

		//Set listeners for each tab:
		homeTab.setTabListener(new TabListener(homeFragment));
		manualTab.setTabListener(new TabListener(manualFragment));
		logTab.setTabListener(new TabListener(logFragment));

		//Add tabs to ActionBar:
		actionBar.addTab(homeTab);
		actionBar.addTab(manualTab);
		actionBar.addTab(logTab);
	}
}