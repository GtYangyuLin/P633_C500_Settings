package com.gomtel.settings.datetime;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gomtel.settings.R;
import com.gomtel.settings.util.NumberPickerView;
import com.gomtel.settings.util.SettingsUtil;

/**
 * Created by luojunqing on 2018/7/10.
 */

public class DateTimeTestFragment extends Fragment implements NumberPickerView.OnScrollListener, NumberPickerView.OnValueChangeListener {

    private NumberPickerView mNumberPickerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numberpick_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mNumberPickerView = (NumberPickerView) view.findViewById(R.id.picker);
        mNumberPickerView.setOnScrollListener(this);
        mNumberPickerView.setOnValueChangedListener(this);


        mNumberPickerView.setDisplayedValues(getTimeArray());
        mNumberPickerView.setMinValue(0);
        mNumberPickerView.setMaxValue(getTimeArray().length - 1);
        Log.e("yang", "initView: setValue"+SettingsUtil.getDatePosition(getTimeArray(),SettingsUtil.getDate()));
        mNumberPickerView.setValue(SettingsUtil.getDatePosition(getTimeArray(),SettingsUtil.getDate()));
        /*mNumberPickerView.setFocusable(true);
        mNumberPickerView.setFocusableInTouchMode(true);*/
    }

    private String[] getTimeArray() {
        String[] time = new String[12 * 60];
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= 59; j++) {
                String hourstr = i < 10 ? "0" + i : i + "";
                String minstr = j < 10 ? "0" + j : j + "";
                time[(i - 1) * 60 + j] = hourstr + ":" + minstr;
            }
        }
        return time;
    }

    @Override
    public void onScrollStateChange(NumberPickerView view, int scrollState) {

    }

    @Override
    public void onValueChange(NumberPickerView picker, int oldVal, int newVal) {

        String[] content = picker.getDisplayedValues();
        if (content != null) {
            Log.d("yang", "onValueChange content : " + content[newVal - picker.getMinValue()]);
            Toast.makeText(getActivity().getApplicationContext(), "oldVal : " + oldVal + " newVal : " + newVal + "\n" +
                    "选中的内容是：" + content[newVal - picker.getMinValue()], Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
