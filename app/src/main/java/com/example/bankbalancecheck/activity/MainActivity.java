package com.example.bankbalancecheck.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                exit();
            }
        });
        binding.relBankSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BanksActivity.class);
                startActivity(intent);
            }
        });
        binding.relEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EmiIntent = new Intent(MainActivity.this, EMICalculatorActivity.class);
                startActivity(EmiIntent);
            }
        });
        binding.relSIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mutualIntent = new Intent(MainActivity.this,MutualFundActivity.class);
                startActivity(mutualIntent);
            }
        });
        binding.relGST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gstIntent = new Intent(MainActivity.this, GstCalculatorActivity.class);
                startActivity(gstIntent);
            }
        });
        binding.relInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interestIntent = new Intent(MainActivity.this, InterestActivity.class);
                startActivity(interestIntent);
            }
        });
    }
    void exit()
    {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.exit_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        TextView txtYes = dialog.findViewById(R.id.txtYes);
        TextView txtNo = dialog.findViewById(R.id.txtNo);

        txtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}