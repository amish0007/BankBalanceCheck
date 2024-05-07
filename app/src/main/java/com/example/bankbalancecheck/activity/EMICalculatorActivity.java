package com.example.bankbalancecheck.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheck.databinding.ActivityEmicalculatorBinding;

public class EMICalculatorActivity extends AppCompatActivity {
    ActivityEmicalculatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmicalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgEmiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.emiClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edtLoanAmt.setText("");
                binding.edtIntRate.setText("");
                binding.edtTime.setText("");
            }
        });
        binding.cvEmiCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtLoanAmt = binding.edtLoanAmt.getText().toString();
                String edtIntRate = binding.edtIntRate.getText().toString();
                String edtTime = binding.edtTime.getText().toString();

                if(edtLoanAmt.isEmpty())
                {
                    binding.edtLoanAmtLayout.setErrorEnabled(true);
                    binding.edtLoanAmtLayout.setError("Enter Loan Amount");
                }
                else if(edtIntRate.isEmpty())
                {
                    binding.edtIntRateLayout.setErrorEnabled(true);
                    binding.edtIntRateLayout.setError("Enter Interest Rate");
                }
                else if(edtTime.isEmpty())
                {
                    binding.edtTimeLayout.setErrorEnabled(true);
                    binding.edtTimeLayout.setError("Enter Time Duration");
                }
                else
                {
                    binding.edtLoanAmtLayout.setErrorEnabled(false);
                    binding.edtIntRateLayout.setErrorEnabled(false);
                    binding.edtTimeLayout.setErrorEnabled(false);

                    int amounts = Integer.parseInt(edtLoanAmt);
                    float rates = Float.parseFloat(edtIntRate);
                    int years = Integer.parseInt(edtTime);
                    float monthlyRate = rates/12/100;
                    int months = years*12;
                    double totalIntAmt;
                    double totalPay;

                    Double emi = (amounts*monthlyRate*Math.pow(1+monthlyRate,months)/(Math.pow(1+monthlyRate,months)-1));
                    emi=Math.floor(emi);
                    totalIntAmt = emi*months-amounts;
                    totalPay=totalIntAmt+amounts;

                    binding.ansIntAmount.setText(""+totalIntAmt);
                    binding.ansTotInterest.setText(""+rates+"%");
                    binding.ansTotPayAmount.setText(""+totalPay);
                }
            }
        });
    }
}