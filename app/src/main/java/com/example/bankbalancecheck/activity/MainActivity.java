package com.example.bankbalancecheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheck.EMICalculatorActivity;
import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int[] image={R.drawable.emi,R.drawable.ifsc_micr,R.drawable.gst,R.drawable.sip};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
    }
}