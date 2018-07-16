package com.gomtel.settings.datetime;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.gomtel.settings.R;
import com.gomtel.settings.util.LoopView;
import com.gomtel.settings.util.NumberPickerView;
import com.gomtel.settings.util.OnItemSelectedListener;
import com.gomtel.settings.util.SettingsUtil;

import java.util.Arrays;


/**
 * Created by luojunqing on 2018/7/7.
 */

public class DateTimeTestFragment extends Fragment implements View.OnClickListener, NumberPickerView.OnValueChangeListener, CompoundButton.OnCheckedChangeListener, OnItemSelectedListener {

    private final static String TAG = "yangyulin";

    private View topPanel, pickerLayout;

    private ImageView iv_back, iv_dropDownArrow, iv_pullUpArrow;

    private TextView tv_year, tv_date, tv_ap, tv_time;

    private Switch mSwitchNetTime;

    private boolean dateFlag, timeFlag;

    private LoopView dataPicker , apPicker,timePicker;
    //private NumberPickerView dataPicker, apPicker, timePicker;

    /*String[] apValues = new String[]{getActivity().getResources().getString(R.string.time_page_set_am),
            getActivity().getResources().getString(R.string.time_page_set_pm)};*/
    String[] apValues = new String[]{"上午", "下午"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numberpick_fragment, container, false);
        initview(view);
        return view;
    }

    private void initview(View view) {

        topPanel = view.findViewById(R.id.top_panel_layout);
        iv_back = (ImageView) view.findViewById(R.id.top_panel_layout).findViewById(R.id.back);
        iv_back.setOnClickListener(this);

        pickerLayout = view.findViewById(R.id.date_time_pick_layout);

        tv_year = (TextView) view.findViewById(R.id.text_year);
        tv_date = (TextView) view.findViewById(R.id.text_date);
        tv_ap = (TextView) view.findViewById(R.id.text_am_pm);
        tv_time = (TextView) view.findViewById(R.id.text_time);

        mSwitchNetTime = (Switch) view.findViewById(R.id.switch_net_time);

        iv_dropDownArrow = (ImageView) view.findViewById(R.id.iv_timeime_dropdown_arrow);
        iv_pullUpArrow = (ImageView) view.findViewById(R.id.iv_time_pullup_arrow);


        dataPicker = (LoopView) view.findViewById(R.id.pick_date);
        timePicker = (LoopView) view.findViewById(R.id.pick_time);
        apPicker = (LoopView) view.findViewById(R.id.pick_am_pm);

        apPicker.setItems(Arrays.asList(apValues));
        apPicker.setInitPosition(SettingsUtil.getAp());
        apPicker.setNotLoop();
        apPicker.setFocusable(true);
        apPicker.setFocusableInTouchMode(true);


        timePicker.setItems(Arrays.asList(getTimeArray()));
        /*timePicker.setMinValue(0);
        timePicker.setMaxValue(getTimeArray().length - 1);*/
        timePicker.setInitPosition(SettingsUtil.getDatePosition(getTimeArray(), SettingsUtil.getDate()));
        timePicker.setFocusable(true);
        timePicker.setFocusableInTouchMode(true);

        dataPicker.setItems(Arrays.asList(getDateArray(SettingsUtil.getYear())));
        dataPicker.setInitPosition(SettingsUtil.getDaysPosition(getDateArray(SettingsUtil.getYear()), SettingsUtil.getDays()));
        dataPicker.setFocusable(true);
        dataPicker.setFocusableInTouchMode(true);


        updateTextView(SettingsUtil.getDaysPosition(getDateArray(SettingsUtil.getYear()), SettingsUtil.getDays()), SettingsUtil.getAp(), SettingsUtil.getDatePosition(getTimeArray(), SettingsUtil.getDate()));


        mSwitchNetTime.setOnCheckedChangeListener(this);
        iv_dropDownArrow.setOnClickListener(this);
        iv_pullUpArrow.setOnClickListener(this);
        apPicker.setListener(this);
        timePicker.setListener(this);
        dataPicker.setListener(this);
    }

    private void updateTextView(int date, int ap, int time) {
        tv_year.setText(SettingsUtil.getYear() + getActivity().getResources().getString(R.string.time_page_set_year));
        tv_date.setText(getDateArray(SettingsUtil.getYear())[date]);
        tv_ap.setText(apValues[ap]);
        tv_time.setText(getTimeArray()[time]);
    }

    private void updateYearTextView(String str) {
        tv_year.setText(str + getActivity().getResources().getString(R.string.time_page_set_year));
    }

    private void updateDateTextView(int date) {
        //Log.e(TAG, "updateTextView====date======" + getDateArray(SettingsUtil.getYear())[dataPicker.getValue()]);
        tv_date.setText(getDateArray(SettingsUtil.getYear())[date]);
    }

    private void updateApTextView(int ap) {
        //Log.e(TAG, "updateTextView====ap=====" + apValues[apPicker.getValue()]);
        tv_ap.setText(apValues[ap]);
    }

    private void updateTimeTextView(int time) {
        //Log.e(TAG, "updateTextView====time======" + getTimeArray()[timePicker.getValue()]);
        tv_time.setText(getTimeArray()[time]);
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

    private String[] getDateArray(int year) {
        boolean leapYear = isLeapYear(year);
        String[] month_of_day = new String[31 + (leapYear ? 29 : 28) + 31 + 30 + 31 + 30 + 31
                + 31 + 30 + 31 + 30 + 31];
        int index = 0;
        for (int i = 1; i <= 12; i++) {
            int month = i;
            int monthday = 0;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    monthday = 31;
                    break;
                case 2:
                    monthday = (leapYear ? 29 : 28);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    monthday = 30;
                    break;
            }
            for (int j = 1; j <= monthday; j++) {
                String monthStr = i < 10 ? "0" + i : i + "";
                String dateStr = j < 10 ? "0" + j : j + "";

                month_of_day[index++] = monthStr + getActivity().getResources().getString(R.string.time_page_set_month) + dateStr + getActivity().getResources().getString(R.string.time_page_set_day);
            }
        }
        return month_of_day;
    }


    private boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                SettingsUtil.replaceSettingsMain(this);
                break;
            case R.id.iv_time_pullup_arrow:
                pickerLayout.setVisibility(View.VISIBLE);
                iv_dropDownArrow.setVisibility(View.GONE);
                iv_pullUpArrow.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_timeime_dropdown_arrow:
                pickerLayout.setVisibility(View.GONE);
                iv_dropDownArrow.setVisibility(View.VISIBLE);
                iv_pullUpArrow.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onValueChange(NumberPickerView picker, int oldVal, int newVal) {
        String[] content = picker.getDisplayedValues();
        if (content.length == getDateArray(SettingsUtil.getYear()).length) {
            Log.e(TAG, "onValueChange: content===Date======" + content.length);
            int i, n;
            if (0 > NumberPickerView.getDateCircleNumber()) {
                i = oldVal - Math.abs(NumberPickerView.getDateCircleNumber());
                if (Math.abs(i) > getDateArray(SettingsUtil.getYear()).length) {
                    n = (i - (i % getDateArray(SettingsUtil.getYear()).length)) / getDateArray(SettingsUtil.getYear()).length;
                    Log.e(TAG, "onValueChange: n======" + n);
                    updateYearTextView(String.valueOf(getNumberOfYear() - n));
                } else {
                    if (i < 0) {
                        Log.e(TAG, "onValueChange: else");
                        updateYearTextView(String.valueOf(getNumberOfYear() - 1));
                    }
                }
            } else {
                i = oldVal + NumberPickerView.getDateCircleNumber();
                if (i >= getDateArray(SettingsUtil.getYear()).length){
                    updateYearTextView(String.valueOf(getNumberOfYear() + 1));
                }
            }
            updateDateTextView(newVal);
        } else if (content.length == getTimeArray().length) {
            updateTimeTextView(newVal);
        } else if (content.length == apValues.length) {
            updateApTextView(newVal);
        }
    }

    public int getNumberOfYear() {
        String year = String.valueOf(tv_year.getText());
        int yearNumber = Integer.parseInt(year.substring(0, 4));
        return yearNumber;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            pickerLayout.setVisibility(View.GONE);
            iv_dropDownArrow.setVisibility(View.VISIBLE);
            iv_pullUpArrow.setVisibility(View.GONE);
        } else {
            pickerLayout.setVisibility(View.VISIBLE);
            iv_dropDownArrow.setVisibility(View.GONE);
            iv_pullUpArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemSelected(View view,int index) {
        Log.e(TAG, "onItemSelected: index====="+index);
        Log.e(TAG, "onItemSelected: view====="+view);
        if (view.getId() == R.id.pick_date){


            updateDateTextView(index);
        }else if (view.getId() == R.id.pick_time){
            updateTimeTextView(index);
        }else if (view.getId() == R.id.pick_am_pm){
            updateApTextView(index);
        }

    }
}