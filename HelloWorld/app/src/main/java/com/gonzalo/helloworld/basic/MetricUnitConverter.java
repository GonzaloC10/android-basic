package com.gonzalo.helloworld.basic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gonzalo.helloworld.R;

/**
 *
 *  Created by gonzalocondorivillca on 6/27/15.
 *
 */

public class MetricUnitConverter extends Activity{

    private Spinner sFrom,sTo;
    private EditText eValue;
    private TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metricconverterunit);
        setTitle(R.string.metric_unit_converter);

        sFrom = (Spinner)findViewById(R.id.select_from);
        sTo = (Spinner)findViewById(R.id.select_to);

        eValue = (EditText)findViewById(R.id.et_value);
        tResult = (TextView)findViewById(R.id.txt_result);

        sFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), sFrom.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
