package com.example.bankbalancecheck.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
        binding.relMutual.setOnClickListener(new View.OnClickListener() {
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
        AlertDialog alertDialog = new AlertDialog.Builder(this).
                setCancelable(false).setTitle("Do you want to exit?").
                setMessage("Bank Balance Check").
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();

    }
}