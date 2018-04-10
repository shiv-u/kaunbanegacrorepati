package com.androidexample.kbc;

/**
 * Created by shivu on 07-04-2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class Instructions extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private Fragment mVerticalStepperDemoFragment = new VerticalStepperDemoFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Instructions");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;

        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = findViewById(R.id.drawer_layout);

//		mNavigationView = findViewById(R.id.navigation_view);
//	mNavigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            replaceFragment(mVerticalStepperDemoFragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
                    mDrawerLayout.closeDrawer(mNavigationView);
                } else {
                    mDrawerLayout.openDrawer(mNavigationView);
                }
                return true;
            default:
                return false;
        }
    }
    public void details(View view)
    {
        Intent intent = new Intent(this,Details.class);
        startActivity(intent);
    }
//	@Override
//	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//		mDrawerLayout.closeDrawer(mNavigationView);
//		switch (item.getItemId()) {
//			case R.id.item_vertical_stepper:
//				replaceFragment(mVerticalStepperDemoFragment);
//				return true;
//			case R.id.item_vertical_stepper_adapter:
//				replaceFragment(mVerticalStepperAdapterDemoFragment);
//				return true;
//			case R.id.action_alipay_donate:
//				if (AlipayZeroSdk.hasInstalledAlipayClient(this)) {
//					AlipayZeroSdk.startAlipayClient(this, "aehvyvf4taua18zo6e");
//				} else {
//					new AlertDialog.Builder(this)
//							.setTitle(R.string.donate_dialog_title)
//							.setMessage(R.string.donate_dialog_message)
//							.setPositiveButton(android.R.string.ok, null)
//							.setNeutralButton(R.string.doante_dialog_paypal_button, new DialogInterface.OnClickListener() {
//								@Override
//								public void onClick(DialogInterface dialogInterface, int i) {
//									openWebsite("https://paypal.me/fython");
//								}
//							})
//							.show();
//				}
//				return true;
//			case R.id.action_fork_on_github:
//				openWebsite("https://github.com/fython/MaterialStepperView");
//				return true;
//			default:
//				return false;
//		}
//	}

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }



}

