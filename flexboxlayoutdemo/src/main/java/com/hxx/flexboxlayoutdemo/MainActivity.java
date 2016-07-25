package com.hxx.flexboxlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinner_flexDirection;
    private Spinner mSpinner_flexWrap;
    private Spinner mSpinner_justifyContent;
    private Spinner mSpinner_alignItems;
    private Spinner mSpinner_alignContent;
    private FlexboxLayout mFlexbox_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFlexBox();
        initSpinners();
    }

    private void initSpinners() {
        ArrayAdapter<String> adapterFlexDirection = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapterFlexWrap = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapterJustifyContent = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapterAlignItems = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapterAlignContent = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterFlexDirection.addAll("row", "row-reverse", "column", "column-reverse");
        adapterFlexWrap.addAll("nowrap", "wrap", "wrap_reverse");
        mSpinner_flexDirection.setAdapter(adapterFlexDirection);
        mSpinner_flexDirection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mFlexbox_layout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
                        break;
                    case 1:
                        mFlexbox_layout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW_REVERSE);
                        break;
                    case 2:
                        mFlexbox_layout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_COLUMN);
                        break;
                    case 3:
                        mFlexbox_layout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_COLUMN_REVERSE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mFlexbox_layout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
            }
        });
        mSpinner_flexWrap.setAdapter(adapterFlexWrap);
        mSpinner_flexWrap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mFlexbox_layout.setFlexWrap(FlexboxLayout.FLEX_WRAP_NOWRAP);
                        break;
                    case 1:
                        mFlexbox_layout.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP);
                        break;
                    case 2:
                        mFlexbox_layout.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP_REVERSE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initFlexBox() {
        char[] chars = "我爱北京天安门".toCharArray();
        for (char c : chars) {
            TextView textView = new TextView(this);
            textView.setWidth(200);
            textView.setGravity(Gravity.CENTER);
            textView.setText(c + "");
            mFlexbox_layout.addView(textView);
        }
    }

    private void initView() {
        mSpinner_flexDirection = (Spinner) findViewById(R.id.spinner_flexDirection);
        mSpinner_flexWrap = (Spinner) findViewById(R.id.spinner_flexWrap);
        mSpinner_justifyContent = (Spinner) findViewById(R.id.spinner_justifyContent);
        mSpinner_alignItems = (Spinner) findViewById(R.id.spinner_alignItems);
        mSpinner_alignContent = (Spinner) findViewById(R.id.spinner_alignContent);
        mFlexbox_layout = (com.google.android.flexbox.FlexboxLayout) findViewById(R.id.flexbox_layout);
    }
}
