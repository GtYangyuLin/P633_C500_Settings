package com.gomtel.settings.language;

import android.app.Fragment;
import android.content.ContentResolver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gomtel.settings.R;
import com.gomtel.settings.util.SettingsUtil;

/**
 * Created by luojunqing on 2018/7/6.
 */

public class LanguageFragment extends Fragment implements View.OnClickListener {

    private ContentResolver resolver;
    View topPanel, languageCn, languageHk, languageJp, languageEn, languageKo;
    ImageView back, languageCnImage, languageHkImage, languageJpImage, languageEnImage, languageKoImage;
    TextView languageCnTitle, languageCnMessage,
            languageHkTitle, languageHkMessage,
            languageJpTitle, languageJpMessage,
            languageEnTitle, languageEnMessage,
            languageKoTitle, languageKoMessage;
    private String LANGUAGE_CURRENT = "com.gomtel.settings.language";
    private int targt;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.language_fragment, container, false);
        initview(view);
        return view;
    }

    public void initview(View view) {
        topPanel = view.findViewById(R.id.top_panel_layout);
        back = (ImageView) view.findViewById(R.id.top_panel_layout).findViewById(R.id.back);
        back.setOnClickListener(this);

        languageCn = view.findViewById(R.id.language_zh_cn_layout);
        languageCnImage = (ImageView) view.findViewById(R.id.language_zh_cn_layout).findViewById(R.id.iv_settings_item);

        languageHk = view.findViewById(R.id.language_zh_hk_layout);
        languageHkTitle = (TextView) view.findViewById(R.id.language_zh_hk_layout).findViewById(R.id.settings_item_title);
        languageHkMessage = (TextView) view.findViewById(R.id.language_zh_hk_layout).findViewById(R.id.settings_item_name);
        languageHkImage = (ImageView) view.findViewById(R.id.language_zh_hk_layout).findViewById(R.id.iv_settings_item);
        languageHkTitle.setText(R.string.language_page_choose_two);
        languageHkMessage.setText(R.string.language_page_choose_two);

        languageJp = view.findViewById(R.id.language_jp_layout);
        languageJpTitle = (TextView) view.findViewById(R.id.language_jp_layout).findViewById(R.id.settings_item_title);
        languageJpMessage = (TextView) view.findViewById(R.id.language_jp_layout).findViewById(R.id.settings_item_name);
        languageJpImage = (ImageView) view.findViewById(R.id.language_jp_layout).findViewById(R.id.iv_settings_item);
        languageJpTitle.setText(R.string.language_page_choose_three);
        languageJpMessage.setText(R.string.language_page_choose_three);

        languageEn = view.findViewById(R.id.language_en_layout);
        languageEnTitle = (TextView) view.findViewById(R.id.language_en_layout).findViewById(R.id.settings_item_title);
        languageEnMessage = (TextView) view.findViewById(R.id.language_en_layout).findViewById(R.id.settings_item_name);
        languageEnImage = (ImageView) view.findViewById(R.id.language_en_layout).findViewById(R.id.iv_settings_item);
        languageEnTitle.setText(R.string.language_page_choose_four);
        languageEnMessage.setText(R.string.language_page_choose_four);

        languageKo = view.findViewById(R.id.language_ko_layout);
        languageKoTitle = (TextView) view.findViewById(R.id.language_ko_layout).findViewById(R.id.settings_item_title);
        languageKoMessage = (TextView) view.findViewById(R.id.language_ko_layout).findViewById(R.id.settings_item_name);
        languageKoImage = (ImageView) view.findViewById(R.id.language_ko_layout).findViewById(R.id.iv_settings_item);
        languageKoTitle.setText(R.string.language_page_choose_five);
        languageKoMessage.setText(R.string.language_page_choose_five);

        languageCn.setOnClickListener(this);
        languageHk.setOnClickListener(this);
        languageJp.setOnClickListener(this);
        languageEn.setOnClickListener(this);
        languageKo.setOnClickListener(this);

        updateItemImageView(view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                SettingsUtil.replaceSettingsMain(this);
                /*FragmentManager fragmentManager = getActivity().getFragmentManager();
                SettingsFragment settingsFragment = new SettingsFragment();
                fragmentManager.beginTransaction().replace(R.id.full_screen,settingsFragment).commit();*/
                break;
            case R.id.language_zh_cn_layout:
                Log.d("yangyulin", "onClick: language_zh_CN"+view.getId());
                updateItemImageView(view);
                break;
            case R.id.language_zh_hk_layout:
                Log.d("yangyulin", "onClick: language_zh_HK"+view.getId());
                updateItemImageView(view);
                break;
            case R.id.language_jp_layout:
                Log.d("yangyulin", "onClick: language_jp"+view.getId());
                updateItemImageView(view);
                break;
            case R.id.language_en_layout:
                Log.d("yangyulin", "onClick: language_en"+view.getId());
                updateItemImageView(view);
                break;
            case R.id.language_ko_layout:
                Log.d("yangyulin", "onClick: language_ko"+view.getId());
                updateItemImageView(view);
                break;
        }
    }


    public void updateItemImageView(View view) {
        targt = SettingsUtil.getInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_zh_cn_layout);
        Log.d("yangyulin", "updateItemImageView: targt====" + String.valueOf(targt));
        if (view.getId() == R.id.language_zh_cn_layout || targt == R.id.language_zh_cn_layout) {
            Log.d("yangyulin", "updateItemImageView: language_zh_CN");
            languageCnImage.setVisibility(View.VISIBLE);
            languageHkImage.setVisibility(View.GONE);
            languageJpImage.setVisibility(View.GONE);
            languageEnImage.setVisibility(View.GONE);
            languageKoImage.setVisibility(View.GONE);
            SettingsUtil.setInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_zh_cn_layout);
        }
        if (view.getId() == R.id.language_zh_hk_layout || targt == R.id.language_zh_hk_layout) {
            Log.d("yangyulin", "updateItemImageView: language_zh_HK");
            languageCnImage.setVisibility(View.GONE);
            languageHkImage.setVisibility(View.VISIBLE);
            languageJpImage.setVisibility(View.GONE);
            languageEnImage.setVisibility(View.GONE);
            languageKoImage.setVisibility(View.GONE);
            SettingsUtil.setInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_zh_hk_layout);
        }
        if (view.getId() == R.id.language_jp_layout || targt == R.id.language_jp_layout) {
            Log.d("yangyulin", "updateItemImageView: language_jp");
            languageCnImage.setVisibility(View.GONE);
            languageHkImage.setVisibility(View.GONE);
            languageJpImage.setVisibility(View.VISIBLE);
            languageEnImage.setVisibility(View.GONE);
            languageKoImage.setVisibility(View.GONE);
            SettingsUtil.setInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_jp_layout);
        }
        if (view.getId() == R.id.language_en_layout || targt == R.id.language_en_layout) {
            Log.d("yangyulin", "updateItemImageView: language_en");
            languageCnImage.setVisibility(View.GONE);
            languageHkImage.setVisibility(View.GONE);
            languageJpImage.setVisibility(View.GONE);
            languageEnImage.setVisibility(View.VISIBLE);
            languageKoImage.setVisibility(View.GONE);
            SettingsUtil.setInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_en_layout);
        }
        if (view.getId() == R.id.language_ko_layout || targt == R.id.language_ko_layout) {
            Log.d("yangyulin", "updateItemImageView: language_ko");
            languageCnImage.setVisibility(View.GONE);
            languageHkImage.setVisibility(View.GONE);
            languageJpImage.setVisibility(View.GONE);
            languageEnImage.setVisibility(View.GONE);
            languageKoImage.setVisibility(View.VISIBLE);
            SettingsUtil.setInt(this.getContext(), LANGUAGE_CURRENT, R.id.language_ko_layout);
        }
    }
}
