package com.example.xyntherys.myapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Spinner spinner;
    private Button buttonOk;
    private Button buttonCancel;
    private TextView finalResult;
    private FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = (EditText) findViewById(R.id.input_number);
        this.spinner = (Spinner) findViewById(R.id.unit_chooser);
        this.buttonOk = (Button) findViewById(R.id.ok_button);
        this.buttonCancel = (Button) findViewById(R.id.clear_button);
        this.finalResult = (TextView) findViewById(R.id.final_result);
        this.actionButton = (FloatingActionButton) findViewById(R.id.info_fab);

        ArrayAdapter<CharSequence> unitList = ArrayAdapter.createFromResource(this, R.array.unit_items,
                android.R.layout.simple_spinner_item);
        unitList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(unitList);

        bindListener();
    }

    private void bindListener() {
        if (this.buttonOk != null) {
            this.buttonOk.setOnClickListener(this);
        }

        if (this.buttonCancel != null) {
            this.buttonCancel.setOnClickListener(this);
        }

        if (actionButton != null) {
            actionButton.setOnClickListener(this);
        }
    }

    public double conversionOutput(String number){
        double output = 0;
        if (number.length() > 0) {
            double intVal = Double.parseDouble(number);
            int position = spinner.getSelectedItemPosition();

            switch (position) {
                case 0:
                    MeterToInch mtoi = new MeterToInch(intVal);
                    output = mtoi.toFormattedString();
                    break;
                case 1:
                    InchToMeter itom = new InchToMeter(intVal);
                    output = itom.getResult();
                    break;
                case 2:
                    CelToFar ctof = new CelToFar(intVal);
                    output = ctof.getResult();
                    break;
                case 3:
                    FarToCel ftoc = new FarToCel(intVal);
                    output = ftoc.getResult();
                    break;
                case 4:
                    KgToLb ktol = new KgToLb(intVal);
                    output = ktol.getResult();
                    break;
                case 5:
                    LbToKg ltok = new LbToKg(intVal);
                    output = ltok.getResult();
                    break;
                default:
                    break;
            }
        }
        return output;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            String number = editText.getText().toString();
            double output;

            if (number.length() > 0) {
                output = conversionOutput(number);
                finalResult.setText(String.valueOf(output));
            } else {
                finalResult.setText("Cannot convert a blank input!");
            }

        } else if (v.getId() == R.id.clear_button) {

            editText.setText("");
            finalResult.setText("");

        } else if (v.getId() == R.id.info_fab) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
