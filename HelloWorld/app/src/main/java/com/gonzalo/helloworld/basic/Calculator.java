package com.gonzalo.helloworld.basic;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gonzalo.helloworld.R;

import java.util.ArrayList;

/**
 *
 *  Created by gonzalocondorivillca on 6/27/15.
 *
 */

public class Calculator extends Activity {

    private TextView tResultC;

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnSum, btnRest, btnMulti, btnDiv, btnEqual, btnAC;

    private ArrayList<Float> math = new ArrayList<Float>();

    private float m1, m2, temp;

    private int currentOperation = 0;
    private int nextOperation;

    private final static int ADD = 1;
    private final static int SUBTRACT = 2;
    private final static int MULTIPLY =3;
    private final static int DIVISION = 4;
    private final static int EQUALS = 0;
    private final static int CLEAR = 1;
    private final static int DONT_CLEAR = 0;
    private int clearDisplay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        setTitle(R.string.activity_calculator);

        tResultC = (TextView)findViewById(R.id.txt_cResult);

        btnZero  = (Button)findViewById(R.id.btn_value0);
        btnOne   = (Button)findViewById(R.id.btn_value1);
        btnTwo   = (Button)findViewById(R.id.btn_value2);
        btnThree = (Button)findViewById(R.id.btn_value3);
        btnFour  = (Button)findViewById(R.id.btn_value4);
        btnFive  = (Button)findViewById(R.id.btn_value5);
        btnSix   = (Button)findViewById(R.id.btn_value6);
        btnSeven = (Button)findViewById(R.id.btn_value7);
        btnEight = (Button)findViewById(R.id.btn_value8);
        btnNine  = (Button)findViewById(R.id.btn_value9);

        btnSum   = (Button)findViewById(R.id.btn_operation_sum);
        btnRest  = (Button)findViewById(R.id.btn_operation_rest);
        btnMulti = (Button)findViewById(R.id.btn_operation_multi);
        btnDiv   = (Button)findViewById(R.id.btn_operation_div);
        btnEqual = (Button)findViewById(R.id.btn_operation_equal);
        btnAC    = (Button)findViewById(R.id.btn_action_reset);

        tResultC.setKeyListener(DigitsKeyListener.getInstance(true,true));

        registerListeners();
    }

    private void registerListeners() {

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearDisplay == CLEAR) {
                    tResultC.setText("");
                }
                clearDisplay = DONT_CLEAR;
                tResultC.append("9");
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(ADD);
            }
        });

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(SUBTRACT);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(MULTIPLY);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(DIVISION);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(EQUALS);
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tResultC.setText("0");
                m1 = 0;
                m2 = 0;
                math.removeAll(math);
                currentOperation = 0;
                nextOperation = 0;
            }
        });
    }

    private void calcLogic(int operation) {

        math.add(Float.parseFloat(tResultC.getText().toString()));

        if (operation != EQUALS) {
            nextOperation = operation;
        }
        else if  (operation == EQUALS){
            nextOperation = 0;
            //operator=' ';
        }

        switch (currentOperation) {
            case ADD:
                m1 = math.get(0);
                m2 = math.get(1);
                math.removeAll(math);
                math.add(m1 + m2);
                tResultC.setText(String.format("%.1f", math.get(0)));
                break;
            case SUBTRACT:
                m1 = math.get(0);
                m2 = math.get(1);
                math.removeAll(math);
                math.add(m1 - m2);
                tResultC.setText(String.format("%.1f", math.get(0)));
                break;
            case MULTIPLY:
                m1 = math.get(0);
                m2 = math.get(1);
                math.removeAll(math);
                math.add(m1 * m2);
                tResultC.setText(String.format("%.1f", math.get(0)));
                break;
            case DIVISION:
                m1 = math.get(0);
                m2 = math.get(1);
                math.removeAll(math);
                math.add(m1 / m2);
                tResultC.setText(String.format("%.1f", math.get(0)));
                break;
        }

        clearDisplay = CLEAR;
        currentOperation = nextOperation;
        if (operation == EQUALS) {
            m1 = 0;
            m2 = 0;
            math.removeAll(math);
        }

    }
}
