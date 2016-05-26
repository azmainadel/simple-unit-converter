package com.example.xyntherys.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.input_number) EditText editText;
    @BindView(R.id.unit_chooser) Spinner spinner;
    @BindView(R.id.ok_button) Button buttonOk;
    @BindView(R.id.clear_button) Button buttonCancel;
    @BindView(R.id.final_result) TextView finalResult;
    @BindView(R.id.info_fab) FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // new comments

        ArrayAdapter<CharSequence> unitList = ArrayAdapter.createFromResource(this, R.array.unit_items,
                android.R.layout.simple_spinner_item);
        unitList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(unitList);

        bindListener();
    }

    //just another Comment

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

    public String conversionOutput(String number){
        String output = "\0";
        Converter converter = null;
        if (number.length() > 0) {
            double intVal = Double.parseDouble(number);
            int position = spinner.getSelectedItemPosition();
            switch (position) {
                case 0:
                    converter = new MeterToInch(intVal);
                    break;
                case 1:
                    converter = new InchToMeter(intVal);
                    break;
                case 2:
                    converter = new CelToFar(intVal);
                    break;
                case 3:
                    converter = new FarToCel(intVal);
                    break;
                case 4:
                    converter = new KgToLb(intVal);
                    break;
                case 5:
                    converter = new LbToKg(intVal);
                    break;
                default:
                    break;
            }
        }

        if (converter != null) {
            return converter.toFormattedString();
        }

        return "";
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            String number = editText.getText().toString();
            String output;

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
