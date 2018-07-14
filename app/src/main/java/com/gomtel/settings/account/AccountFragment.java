package com.gomtel.settings.account;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gomtel.settings.R;
import com.gomtel.settings.util.CircleImageView;
import com.gomtel.settings.util.SettingsUtil;

/**
 * Created by luojunqing on 2018/7/13.
 */

public class AccountFragment extends Fragment implements View.OnClickListener {

    private View settingsTopView, backView;
    private ImageView iv_head_portrait_top, iv_head_portrait_bottom, iv_back;
    private TextView tv_name, tv_num, account_quit, account_enter;
    private CircleImageView head_portrait;
    private Context mContext;
    private Bitmap headPortrait;

    private String ACCOUNT_NAME = "com.gomtel.settings.account.name";
    private String ACCOUNT_NUM = "com.gomtel.settings.account.number";
    private String ACCOUNT_HEAD = "com.gomtel.settings.account.head";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        backView = view.findViewById(R.id.back_layout);
        iv_back = (ImageView) backView.findViewById(R.id.back);
        iv_back.setOnClickListener(this);

        settingsTopView = view.findViewById(R.id.settings_top_layout);
        iv_head_portrait_top = (ImageView) settingsTopView.findViewById(R.id.iv_head_portrait_top);
        iv_head_portrait_top.setVisibility(View.GONE);
        iv_head_portrait_bottom = (ImageView) settingsTopView.findViewById(R.id.iv_head_portrait_bottom);
        iv_head_portrait_bottom.setVisibility(View.GONE);
        head_portrait = (CircleImageView) settingsTopView.findViewById(R.id.iv_head_portrait);
        head_portrait.setOnClickListener(this);
        tv_name = (TextView) settingsTopView.findViewById(R.id.tv_name);
        tv_num = (TextView) settingsTopView.findViewById(R.id.tv_number);

        tv_name.setText(SettingsUtil.getString(getContext(), ACCOUNT_NAME, ""));
        tv_num.setText(SettingsUtil.getString(getContext(), ACCOUNT_NUM, ""));
        head_portrait.setImageResource(SettingsUtil.getInt(getContext(), ACCOUNT_HEAD, R.drawable.ic_head_empty));

        account_quit = (TextView) view.findViewById(R.id.account_quit);
        account_enter = (TextView) view.findViewById(R.id.account_enter);
        account_quit.setOnClickListener(this);
        account_enter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d("yang", "onClick: v.getId()======" + v.getId());
        switch (v.getId()) {
            case R.id.back:
                SettingsUtil.replaceSettingsMain(this);
                break;
            case R.id.account_enter:
                Toast.makeText(getContext(), "登入账号", Toast.LENGTH_LONG).show();
                account_enter.setVisibility(View.GONE);
                account_quit.setVisibility(View.VISIBLE);
                break;
            case R.id.account_quit:
                Toast.makeText(getContext(), "退出当前账号", Toast.LENGTH_LONG).show();
                /*tv_name.setVisibility(View.GONE);
                tv_num.setVisibility(View.GONE);*/
                tv_name.setText("");
                tv_num.setText("");
                head_portrait.setImageResource(R.drawable.ic_head_empty);
                SettingsUtil.setString(getContext(), ACCOUNT_NAME, String.valueOf(tv_name.getText()));
                SettingsUtil.setString(getContext(), ACCOUNT_NUM, String.valueOf(tv_num.getText()));
                SettingsUtil.setInt(getContext(), ACCOUNT_HEAD, R.drawable.ic_head_empty);
                account_quit.setVisibility(View.GONE);
                account_enter.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_head_portrait:

                head_portrait.setImageResource(R.drawable.head_portrait_2);
                SettingsUtil.setInt(getContext(), ACCOUNT_HEAD, R.drawable.head_portrait_2);
                break;
        }
    }
}
