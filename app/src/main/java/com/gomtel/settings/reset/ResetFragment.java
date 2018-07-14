package com.gomtel.settings.reset;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gomtel.settings.R;
import com.gomtel.settings.util.SettingsUtil;

/**
 * Created by luojunqing on 2018/7/6.
 */

public class ResetFragment extends Fragment implements View.OnClickListener{

    View topPanel;
    ImageView back;
    TextView resetButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reset_fragment,container,false);
        initView(view);
        return view;
    }
    public void initView(View view){
        topPanel = view.findViewById(R.id.top_panel_layout);
        back = (ImageView) view.findViewById(R.id.top_panel_layout).findViewById(R.id.back);
        back.setOnClickListener(this);

        resetButton = view.findViewById(R.id.tv_reset_button);
        resetButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                //BackHandlerHelper.handleBackPress(this);
                SettingsUtil.replaceSettingsMain(this);
                break;
            case R.id.tv_reset_button:
                Toast.makeText(getContext(),"设备重置",Toast.LENGTH_LONG).show();
                break;
        }
    }

    /*@Override
    public boolean onBackPressed() {
        return  BackHandlerHelper.handleBackPress(this);
    }*/
}

