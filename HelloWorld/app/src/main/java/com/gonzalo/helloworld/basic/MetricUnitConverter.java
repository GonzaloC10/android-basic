package com.gonzalo.helloworld.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
    private String sValue;
    private Button btnUnitConverter;
    private Float fValue;
    private Float fOperation;

    public float from;
    public float to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metricconverterunit);
        setTitle(R.string.metric_unit_converter);

        sFrom = (Spinner)findViewById(R.id.select_from);
        sTo = (Spinner)findViewById(R.id.select_to);

        eValue = (EditText)findViewById(R.id.et_value);
        tResult = (TextView)findViewById(R.id.txt_result);
        btnUnitConverter = (Button)findViewById(R.id.btn_converter);

        onSelectUnit();
    }

    private void onSelectUnit() {
        sFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = sFrom.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = sTo.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnUnitConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sValue = eValue.getText().toString();
                if (sValue.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MetricUnitConverter.this);
                    builder.setMessage(R.string.message_alert_empty);
                    builder.setTitle(R.string.message_alert_title);
                    builder.setNeutralButton(R.string.message_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    tResult.setHint("0");
                    fValue = Float.parseFloat(sValue);
                    if (from == 0.0){
                        if (to == 0.0){
                            fOperation = fValue * 1;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Kilómetro - Kilómetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 1.0){
                            fOperation = fValue * 1000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Kilómetro - Metros", Toast.LENGTH_SHORT).show();
                        } else if (to == 2.0){
                            fOperation = fValue * 10000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Kilómetro - Decímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 3.0){
                            fOperation = fValue * 100000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Kilómetro - Centímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 4.0){
                            fOperation = fValue * 1000000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Kilómetro - Milimetro", Toast.LENGTH_SHORT).show();
                        }
                    } else if (from == 1.0){
                        if (to == 0.0){
                            fOperation = fValue / 1000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Metros - Kilómetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 1.0){
                            fOperation = fValue * 1;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Metros - Metros", Toast.LENGTH_SHORT).show();
                        } else if (to == 2.0){
                            fOperation = fValue * 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Metros - Decímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 3.0){
                            fOperation = fValue * 100;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Metros - Centímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 4.0){
                            fOperation = fValue * 1000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Metros - Milimetro", Toast.LENGTH_SHORT).show();
                        }
                    } else if (from == 2.0){
                        if (to == 0.0){
                            fOperation = fValue / 10000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Decímetro - Kilómetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 1.0){
                            fOperation = fValue / 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Decímetro - Metros", Toast.LENGTH_SHORT).show();
                        } else if (to == 2.0){
                            fOperation = fValue * 1;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Decímetro - Decímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 3.0){
                            fOperation = fValue * 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Decímetro - Centímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 4.0){
                            fOperation = fValue * 100;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Decímetro - Milimetro", Toast.LENGTH_SHORT).show();
                        }
                    } else if (from == 3.0){
                        if (to == 0.0){
                            fOperation = fValue / 100000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Centímetro - Kilómetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 1.0){
                            fOperation = fValue / 100;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Centímetro - Metros", Toast.LENGTH_SHORT).show();
                        } else if (to == 2.0){
                            fOperation = fValue / 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Centímetro - Decímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 3.0){
                            fOperation = fValue * 1;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Centímetro - Centímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 4.0){
                            fOperation = fValue * 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Centímetro - Milimetro", Toast.LENGTH_SHORT).show();
                        }
                    } else if (from == 4.0){
                        if (to == 0.0){
                            fOperation = fValue / 1000000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Milímetro - Kilómetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 1.0){
                            fOperation = fValue / 1000;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Milímetro - Metros", Toast.LENGTH_SHORT).show();
                        } else if (to == 2.0){
                            fOperation = fValue / 100;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Milímetro - Decímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 3.0){
                            fOperation = fValue / 10;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Milímetro - Centímetro", Toast.LENGTH_SHORT).show();
                        } else if (to == 4.0){
                            fOperation = fValue * 1;
                            tResult.setText(fOperation.toString());
                            Toast.makeText(getApplicationContext(), "Milímetro - Milímetro", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
