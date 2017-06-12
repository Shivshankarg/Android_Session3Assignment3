package com.shivshankar.session3assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonCompute, buttonClear;
    EditText editCardBalance, editInterestRate, editMinimumPayment,
            editInterestPaid, editMonthsReamining, editFinalCardBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        buttonCompute.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

        editCardBalance = (EditText) findViewById(R.id.editCardBalance);
        editInterestRate = (EditText) findViewById(R.id.editRateInterest);
        editMinimumPayment = (EditText) findViewById(R.id.editMinimumPayment);
        editFinalCardBalance = (EditText) findViewById(R.id.editFinalCardBalance);
        editMonthsReamining = (EditText) findViewById(R.id.editMonthsRemaining);
        editInterestPaid = (EditText) findViewById(R.id.editInterestPaid);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonCompute:
                float cardBalance = Float.parseFloat(editCardBalance.getText()
                        .toString());
                float interestRate = Float.parseFloat(editInterestRate.getText()
                        .toString());
                float minimumPayment = Float.parseFloat(editMinimumPayment
                        .getText().toString());

                float data[] = total_floaterest_payable(cardBalance, interestRate,
                        minimumPayment);

                editInterestPaid.setText(data[0] + "");
                editMonthsReamining.setText(data[2] + "");
                editFinalCardBalance.setText(data[1] + "");

                break;

            case R.id.buttonClear:

                editCardBalance.setText("");
                editInterestRate.setText("");
                editMinimumPayment.setText("");
                editInterestPaid.setText("");
                editMonthsReamining.setText("");
                editFinalCardBalance.setText("");
        }

    }

    private float[] total_floaterest_payable(float principal, float rate,
                                             float minimum_payment) {
        float monthlyfloatInterestPaid = 0, monthlyPrinciple = 0, monthlyBalance = 0;

        float data[] = new float[3];
        float count = 0;
        do {
            count++;
            monthlyfloatInterestPaid = Math
                    .round((principal * (rate / (100 * 12))));// 1
            monthlyPrinciple = minimum_payment - monthlyfloatInterestPaid;// 2
            monthlyBalance = principal - monthlyPrinciple;// 3
            principal = monthlyBalance;// 4
            if (count == 1) {
                data[0] = monthlyfloatInterestPaid;
                data[1] = monthlyBalance;
                System.out.println(monthlyfloatInterestPaid + " , "
                        + monthlyBalance);
            }
        } while (monthlyBalance > 0);
        System.out.println(count);

        data[2] = count - 1;

        return data;

    }

}
