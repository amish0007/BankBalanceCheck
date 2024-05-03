package com.example.bankbalancecheck.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityBankInfoBinding;

public class BankInfoActivity extends AppCompatActivity {

    ActivityBankInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String bank = intent.getStringExtra("BankName");
        binding.txtBankName.setText(bank);
    }
}