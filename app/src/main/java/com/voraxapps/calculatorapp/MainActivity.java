package com.voraxapps.calculatorapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView resultsView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }


    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";

    Operation currentOperation;

    int result = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneBtn = findViewById(R.id.oneBtn);
        Button twoBtn = findViewById(R.id.twoBtn);
        Button threeBtn = findViewById(R.id.threeBtn);
        Button fourBtn = findViewById(R.id.fourBtn);
        Button fiveBtn = findViewById(R.id.fiveBtn);
        Button sixBtn = findViewById(R.id.sixBtn);
        Button sevenBtn = findViewById(R.id.sevenBtn);
        Button eightBtn = findViewById(R.id.eightBtn);
        Button nineBtn = findViewById(R.id.nineBtn);
        Button zeroBtn = findViewById(R.id.zeroBtn);
        Button clearBtn = findViewById(R.id.clearBtn);

        ImageButton calcBtn = findViewById(R.id.calcBtn);
        ImageButton addBtn = findViewById(R.id.addBtn);
        ImageButton subtractBtn = findViewById(R.id.subtractBtn);
        ImageButton divideBtn = findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = findViewById(R.id.multiplyBtn);

        resultsView = findViewById(R.id.resultsText);

        resultsView.setText("");


        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsView.setText("0");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });


        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });


        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);

            }
        });


        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });
    }

    void processOperation(Operation operation){
        if (currentOperation != null) {
            if (runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch(currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }
                leftValueStr = String.valueOf(result);
                resultsView.setText(leftValueStr);
            }
        } else {
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;

    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);
    }
}
