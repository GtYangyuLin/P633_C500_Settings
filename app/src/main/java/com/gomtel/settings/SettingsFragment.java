package com.gomtel.settings;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gomtel.settings.util.SettingsUtil;

/**
 * Created by luojunqing on 2018/7/6.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private String TAG = "yangyulin";
    FragmentManager fragmentManager;
    private String ACCOUNT_NAME = "com.gomtel.settings.account.name";
    private String ACCOUNT_NUM = "com.gomtel.settings.account.number";
    private String ACCOUNT_HEAD = "com.gomtel.settings.account.head";

    View settingsTopView;
    View volumeProgressBar, brightnessProgressBar;
    View hotSpotView, timeView, languageView, versionView, aboutView, resetView;

    ImageView iv_headPortrait;
    TextView tv_name, tv_num;
    TextView tv_volume_title,tv_brightness_title;

    ImageView iv_volumeSmall, iv_volumeLarge, iv_brightnessSmall, iv_brightnessLarge,
            timeImage, languageImage, versionImage, aboutImage, resetImage;
    TextView hotSpotTitle, hotSpotName, hotSpotNum,
            timeTitle, timeName, timeNum,
            languageTitle, languageName, languageNum,
            versionTitle, versionName, versionNum,
            aboutTitle, aboutName, aboutNum,
            resetTitle, resetName, resetNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment_main, container, false);
        init(view);
        return view;
    }

    public void init(View view) {
        initTop(view);
        initMid(view);
        initProgressBar(view);
        initItem(view);
    }

    public void initTop(View view) {
        settingsTopView = view.findViewById(R.id.settings_top_layout);
        iv_headPortrait = (ImageView) view.findViewById(R.id.settings_top_layout).findViewById(R.id.iv_head_portrait);
        tv_name = (TextView) view.findViewById(R.id.settings_top_layout).findViewById(R.id.tv_name);
        tv_num = (TextView) view.findViewById(R.id.settings_top_layout).findViewById(R.id.tv_number);

        tv_name.setText(SettingsUtil.getString(getContext(), ACCOUNT_NAME, "Eiffel"));
        tv_num.setText(SettingsUtil.getString(getContext(), ACCOUNT_NUM, "18513146145"));
        iv_headPortrait.setImageResource(SettingsUtil.getInt(getContext(), ACCOUNT_HEAD, R.drawable.head_portrait));

        iv_headPortrait.setOnClickListener(this);
    }

    public void initMid(View view) {

    }

    public void initProgressBar(View view) {
        volumeProgressBar = view.findViewById(R.id.settings_volume_layout);
        iv_volumeLarge = (ImageView) volumeProgressBar.findViewById(R.id.image_large);
        iv_volumeLarge.setImageResource(R.drawable.ic_volume_large);
        iv_volumeSmall = (ImageView) volumeProgressBar.findViewById(R.id.image_small);
        iv_volumeSmall.setImageResource(R.drawable.ic_volume_small);
        tv_volume_title= (TextView) volumeProgressBar.findViewById(R.id.tv_title);
        tv_volume_title.setText(R.string.volume);

        brightnessProgressBar = view.findViewById(R.id.settings_brightness_layout);
        iv_brightnessSmall = (ImageView) brightnessProgressBar.findViewById(R.id.image_small);
        iv_brightnessSmall.setImageResource(R.drawable.ic_brightness_small);
        iv_brightnessLarge = (ImageView) brightnessProgressBar.findViewById(R.id.image_large);
        iv_brightnessLarge.setImageResource(R.drawable.ic_brightness_large);
        tv_brightness_title= (TextView) brightnessProgressBar.findViewById(R.id.tv_title);
        tv_brightness_title.setText(R.string.brightness);


    }


    public void initItem(View view) {
        hotSpotView = view.findViewById(R.id.settings_hot_spot_layout);


        timeView = view.findViewById(R.id.settings_time_layout);
        timeTitle = (TextView) view.findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_title);
        timeName = (TextView) view.findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_name);
        timeNum = (TextView) view.findViewById(R.id.settings_time_layout).findViewById(R.id.settings_item_num);
        timeImage = (ImageView) view.findViewById(R.id.settings_time_layout).findViewById(R.id.iv_settings_item);
        timeTitle.setText(R.string.time_name);
        timeName.setVisibility(View.GONE);
        timeNum.setVisibility(View.GONE);
        timeImage.setVisibility(View.VISIBLE);
        timeView.setOnClickListener(this);

        languageView = view.findViewById(R.id.settings_language_layout);
        languageTitle = (TextView) view.findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_title);
        languageName = (TextView) view.findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_name);
        languageNum = (TextView) view.findViewById(R.id.settings_language_layout).findViewById(R.id.settings_item_num);
        languageImage = (ImageView) view.findViewById(R.id.settings_language_layout).findViewById(R.id.iv_settings_item);
        languageTitle.setText(R.string.language_name);
        languageName.setVisibility(View.GONE);
        languageNum.setVisibility(View.GONE);
        languageImage.setVisibility(View.VISIBLE);
        languageView.setOnClickListener(this);

        versionView = view.findViewById(R.id.settings_version_layout);
        versionTitle = (TextView) view.findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_title);
        versionName = (TextView) view.findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_name);
        versionNum = (TextView) view.findViewById(R.id.settings_version_layout).findViewById(R.id.settings_item_num);
        versionImage = (ImageView) view.findViewById(R.id.settings_version_layout).findViewById(R.id.iv_settings_item);
        versionTitle.setText(R.string.version_name);
        versionName.setVisibility(View.GONE);
        versionNum.setVisibility(View.VISIBLE);
        versionImage.setVisibility(View.VISIBLE);
        initabout(view);
        initreset(view);
    }

    public void initabout(View view) {
        aboutView = view.findViewById(R.id.settings_about_layout);
        aboutTitle = (TextView) view.findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_title);
        aboutName = (TextView) view.findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_name);
        aboutNum = (TextView) view.findViewById(R.id.settings_about_layout).findViewById(R.id.settings_item_num);
        aboutImage = (ImageView) view.findViewById(R.id.settings_about_layout).findViewById(R.id.iv_settings_item);
        aboutTitle.setText(R.string.about_name);
        aboutName.setVisibility(View.GONE);
        aboutNum.setVisibility(View.GONE);
        aboutImage.setVisibility(View.VISIBLE);

        aboutView.setOnClickListener(this);
    }

    public void initreset(View view) {
        resetView = view.findViewById(R.id.settings_reset_layout);
        resetTitle = (TextView) view.findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_title);
        resetName = (TextView) view.findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_name);
        resetNum = (TextView) view.findViewById(R.id.settings_reset_layout).findViewById(R.id.settings_item_num);
        resetImage = (ImageView) view.findViewById(R.id.settings_reset_layout).findViewById(R.id.iv_settings_item);
        resetTitle.setText(R.string.reset_name);
        resetName.setVisibility(View.GONE);
        resetNum.setVisibility(View.GONE);
        resetImage.setVisibility(View.VISIBLE);

        resetView.setOnClickListener(this);
    }

    public void setversionNum(String str) {
        versionNum.setText(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settings_language_layout:
                SettingsUtil.replaceLanguage(this);
                break;
            case R.id.settings_time_layout:
                SettingsUtil.replaceTimeDate(this);
                break;
            case R.id.settings_about_layout:
                SettingsUtil.replaceTest(this);
                break;
            case R.id.settings_reset_layout:
                Log.d(TAG, "onClick: R.id.settings_reset" + view.getId());
                SettingsUtil.replaceReset(this);
                break;
            case R.id.iv_head_portrait:
                Log.d(TAG, "onClick: R.id.settings_reset" + view.getId());
                SettingsUtil.replaceAccount(this);
                break;
        }
    }
}
