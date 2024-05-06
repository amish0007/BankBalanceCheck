package com.example.bankbalancecheck.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheck.databinding.ActivityInterestBinding;

public class InterestActivity extends AppCompatActivity {
    ActivityInterestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInterestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgInterestBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.cvInterestCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtPrincipalAmt = binding.edtPrincipalAmt.getText().toString();
                String edtInterestRate = binding.edtInterestRate.getText().toString();
                String edtIntTime = binding.edtIntTime.getText().toString();

                if(edtPrincipalAmt.isEmpty())
                {
                    binding.edtPrincipalAmtLayout.setErrorEnabled(true);
                    binding.edtPrincipalAmtLayout.setError("Enter Amount");
                }
                else if(edtInterestRate.isEmpty())
                {
                    binding.edtInterestRateLayout.setErrorEnabled(true);
                    binding.edtInterestRateLayout.setError("Enter Interest Rate");
                } else if (edtIntTime.isEmpty())
                {
                    binding.edtIntTimeLayout.setErrorEnabled(true);
                    binding.edtIntTimeLayout.setError("Enter Time Duration");
                }
                else
                {
                    int intAmount = Integer.parseInt(edtPrincipalAmt);
                    float intRate = Float.parseFloat(edtInterestRate);
                    int intYear = Integer.parseInt(edtIntTime);
                    float monthIntRate = intRate/(12*100);
                    int intMonth = intYear*12;
                    double ansIntAmount;

                    ansIntAmount=(intAmount*intRate*intYear)/100;
                    binding.ansInterestAmount.setText(" "+ansIntAmount);
                }

            }
        });
    }
}