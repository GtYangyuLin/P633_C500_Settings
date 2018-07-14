package com.gomtel.settings;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gomtel.settings.reset.ResetFragment;

/**
 * Created by luojunqing on 2018/7/6.
 */

public class SettingsMainActivity extends FragmentActivity{

    private SettingsFragment settingsFragment = new SettingsFragment();
    private ResetFragment resetFragment = new ResetFragment();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_main);
        FragmentManager manager = this.getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_main_layout,new SettingsFragment());
        transaction.commit();
    }
}
