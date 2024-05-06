package com.example.bankbalancecheck.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityMutualFundBinding;

public class MutualFundActivity extends AppCompatActivity {

    ActivityMutualFundBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMutualFundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgMutualBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.mutualClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edtMonInv.setText("");
                binding.edtExpReturn.setText("");
                binding.edtMutualTime.setText("");
            }
        });
        binding.cvMutualCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtMonInv = binding.edtMonInv.getText().toString();
                String edtExpReturn= binding.edtExpReturn.getText().toString();
                String edtMutualTime = binding.edtMutualTime.getText().toString();

                if(edtMonInv.isEmpty())
                {
                    binding.edtMonInvLayout.setErrorEnabled(true);
                    binding.edtMonInvLayout.setError("Enter Monthly Investment");
                }
                else if(edtExpReturn.isEmpty())
                {
                    binding.edtExpReturnLayout.setErrorEnabled(true);
                    binding.edtExpReturnLayout.setError("Enter Expected Return");
                }
                else if(edtMutualTime.isEmpty())
                {
                    binding.edtMutualTimeLayout.setErrorEnabled(true);
                    binding.edtMutualTimeLayout.setError("Enter Time Duration");
                }
                else
                {
                    binding.edtMonInvLayout.setErrorEnabled(false);
                    binding.edtExpReturnLayout.setErrorEnabled(false);
                    binding.edtMutualTimeLayout.setErrorEnabled(false);
                    int p = Integer.parseInt(edtMonInv);
                    double i = Double.parseDouble(edtExpReturn)/100/12;
                    int n = Integer.parseInt(edtMutualTime)*12;
                    //double total = p*((Math.pow(1+i,n-1)-1))*(i+1)/i;
                    double total = p*((Math.pow(1+i,n)-1))*(1+i)/i;
                    int totInv = (p*n);
                    double estRet = total-totInv;

                    binding.ansInvested.setText(""+totInv);
                    binding.ansEstRet.setText(String.format("%.2f",estRet));
                    binding.ansMutualTotal.setText(String.format("%.2f",total));
                }
            }
        });
    }
}
//double total = p*((Math.pow(1+i,n)-1)/i)*(i+1);