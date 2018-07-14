package com.gomtel.settings;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luojunqing on 2018/7/5.
 */

public class SettingsActivity extends Activity implements View.OnClickListener {

    private String TAG = "yangyulin";

    View settingsTop;
    View volumeProgressBar, brightnessProgressBar;
    View hotSpot, time, language, version, about, reset;
    ImageView volumeSmall, volumeLarge, brightnessSmall, brightnessLarge,
            timeImage, languageImage, versionImage, aboutImage, resetImage;
    TextView hotSpotTitle, hotSpotName, hotSpotNum,
            timeTitle, timeName, timeNum,
            languageTitle, languageName, languageNum,
            versionTitle, versionName, versionNum,
            aboutTitle, aboutName, aboutNum,
            resetTitle, resetName, resetNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_fragment_main);
        init();
    }

    public void init() {
        initTop();
        initMid();
        initProgressBar();
        initItem();
    }

    public void initTop() {
        settingsTop = findViewById(R.id.settings_volume_layout);
    }

    public void initMid() {

    }

    public void initProgressBar() {
        volumeProgressBar = findViewById(R.id.settings_volume_layout);

        brightnessProgressBar = findViewById(R.id.settings_brightness_layout);
        brightnessSmall = (ImageView) findViewById(R.id.settings_brightness_layout).findViewById(R.id.image_small);
        brightnessSmall.setImageResource(R.drawable.ic_brightness_small);
        brightnessLarge = (ImageView) findViewById(R.id.settings_brightness_layout).findViewById(R.id.image_large);
        brightnessLarge.setImageResource(R.drawable.ic_brightness_large);
    }


    public void initItem() {
        hotSpot = findViewById(R.id.settings_hot_spot_layout);


        time = findViewById(R.id.settings_time_layout);
        timeTitle = (TextView) findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_title);
        timeName = (TextView) findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_name);
        timeNum = (TextView) findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_num);
        timeImage = (ImageView) findViewById(R.id.settings_time_layout).findViewById(R.id.iv_settings_item);
        timeTitle.setText(R.string.time_name);
        timeName.setVisibility(View.GONE);
        timeNum.setVisibility(View.GONE);
        timeImage.setVisibility(View.VISIBLE);

        language = findViewById(R.id.settings_language_layout);
        languageTitle = (TextView) findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_title);
        languageName = (TextView) findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_name);
        languageNum = (TextView) findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_num);
        languageImage = (ImageView) findViewById(R.id.settings_language_layout).findViewById(R.id.iv_settings_item);
        languageTitle.setText(R.string.language_name);
        languageName.setVisibility(View.GONE);
        languageNum.setVisibility(View.GONE);
        languageImage.setVisibility(View.VISIBLE);

        version = findViewById(R.id.settings_version_layout);
        versionTitle = (TextView) findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_title);
        versionName = (TextView) findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_name);
        versionNum = (TextView) findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_num);
        versionImage = (ImageView) findViewById(R.id.settings_version_layout).findViewById(R.id.iv_settings_item);
        versionTitle.setText(R.string.version_name);
        versionName.setVisibility(View.GONE);
        versionNum.setVisibility(View.VISIBLE);
        versionImage.setVisibility(View.VISIBLE);
        initabout();
        initreset();
    }
    public void initabout() {
        about = findViewById(R.id.settings_about_layout);
        aboutTitle = (TextView) findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_title);
        aboutName = (TextView) findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_name);
        aboutNum = (TextView) findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_num);
        aboutImage = (ImageView) findViewById(R.id.settings_about_layout).findViewById(R.id.iv_settings_item);
        aboutTitle.setText(R.string.about_name);
        aboutName.setVisibility(View.GONE);
        aboutNum.setVisibility(View.GONE);
        aboutImage.setVisibility(View.VISIBLE);

        about.setOnClickListener(this);
    }

    public void initreset() {
        reset = findViewById(R.id.settings_reset_layout);
        resetTitle = (TextView) findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_title);
        resetName = (TextView) findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_name);
        resetNum = (TextView) findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_num);
        resetImage = (ImageView) findViewById(R.id.settings_reset_layout).findViewById(R.id.iv_settings_item);
        resetTitle.setText(R.string.reset_name);
        resetName.setVisibility(View.GONE);
        resetNum.setVisibility(View.GONE);
        resetImage.setVisibility(View.VISIBLE);

        reset.setOnClickListener(this);
    }

    public void setversionNum(String str) {
        versionNum.setText(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settings_about_layout:
                break;
            case R.id.settings_reset_layout:
                Log.d(TAG, "onClick: R.id.settings_reset"+view.getId());
                break;
        }
    }
}
