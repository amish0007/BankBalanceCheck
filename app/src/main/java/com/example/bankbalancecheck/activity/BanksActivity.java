package com.example.bankbalancecheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheck.adapter.BankNameAdapter;
import com.example.bankbalancecheck.databinding.ActivityBanksBinding;

public class BanksActivity extends AppCompatActivity {

    ActivityBanksBinding binding;
    String[] bankNames = {"State Bank of India(SBI)",
                        "HDFC Bank",
                        "Bank Of Baroda(BOB)",
                        "ICICI Bank",
                        "Axis Bank",
                        "Punjab National Bank(PNB)",
                        "Central Bank of India",
                        "IDFC Bank",
                        "Kotak Mahindra Bank",
                        "Yes Bank"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBanksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BankNameAdapter bankNameAdapter = new BankNameAdapter(bankNames);
        binding.lvBankNames.setAdapter(bankNameAdapter);

        binding.lvBankNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BanksActivity.this,BankInfoActivity.class);
                intent.putExtra("BankName",bankNames[position]);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
    }
}