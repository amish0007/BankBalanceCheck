package com.example.bankbalancecheck.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityBankInfoBinding;

public class BankInfoActivity extends AppCompatActivity {

    ActivityBankInfoBinding binding;

    String[] SBI={"09223766666","09223866666","1800 1234",
            "https://www.google.com/maps/search/state+bank+of+india+atm+near+by+me/@21.2085023,72.8418881,14z/data=!3m1!4b1?entry=ttu",
            "https://www.bankbazaar.com/ifsc-code/state-bank-of-india.html"};

    String[] HDFC={"1800-270-3333","1800-270-3355","1800 202 6161",
                    "https://www.google.com/maps/search/hdfc+atm+near+by+me/@21.2085798,72.8418881,14z/data=!3m1!4b1?entry=ttu",
                    "https://www.bankbazaar.com/ifsc-code/hdfc-bank.html"};

    String[]  BOB={"8468001111","8468001122","1800 5700",
                    "https://www.google.com/maps/search/Bank+of+Baroda+atm+near+by+me/@21.2086573,72.8418881,14z/data=!3m1!4b1?entry=ttu",
                    "https://www.bankbazaar.com/ifsc-code/bank-of-baroda.html"};

    String[]  ICICI={"9594 612 612","9594613613","1800 1080",
                    "https://www.google.com/maps/search/ICICI+atm+near+by+me/@21.2087348,72.8418881,14z/data=!3m1!4b1?entry=ttu",
                    "https://www.bankbazaar.com/ifsc-code/icici-bank.html"};

    String[]  AXIS={"18004195959","1800-419-6969","1800 103 5577",
    "https://www.google.com/maps/search/axis+atm+near+by+me/@21.2088123,72.8418881,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/axis-bank.html"};

    String[]  PNB={"1800 180 2223","1800-180-2223","1800 1800",
    "https://www.google.com/maps/search/punjab+national+bank+atm+near+by+me/@21.2088899,72.841888,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/punjab-national-bank.html"};

    String[]  COI={"9555244442","95551 44441","1800 3030",
    "https://www.google.com/maps/search/Central+Bank+of+India+atm+near+by+me/@21.2089674,72.841888,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/central-bank-of-india.html"};

    String[]  IDFC={"1800 2700 720","1800 419 4332","1800 10888",
    "https://www.google.com/maps/search/idfc+atm+near+by+me/@21.2090449,72.841888,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/idfc-first-bank.html"};

    //Kotak Same Number
    String[]  Kotak={"1800 274 0110","1800 274 0110","1860 266 2666",
    "https://www.google.com/maps/search/Kotak+Mahindra+Bank+atm+near+by+me/@21.2091224,72.841888,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/kotak-mahindra-bank.html"};

    //Yes Same Number
    String[]  YES={"09223920000","1800 1200","1800 1200",
    "https://www.google.com/maps/search/Yes+Bank+atm+near+by+me/@21.2092775,72.841888,14z/data=!3m1!4b1?entry=ttu",
    "https://www.bankbazaar.com/ifsc-code/yes-bank.html"};
    String[][] mainlist = {SBI,HDFC,BOB,ICICI,AXIS,PNB,COI,IDFC,Kotak,YES};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String bank = intent.getStringExtra("BankName");
        int banks = intent.getIntExtra("index",0);
        binding.txtBankName.setText(bank);

        binding.relBankBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balanceIntent = new Intent(Intent.ACTION_CALL);
                balanceIntent.setData(Uri.parse("tel:"+mainlist[banks][0]));
                startActivity(balanceIntent);
            }
        });
        binding.relMiniStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miniStatIntent = new Intent(Intent.ACTION_CALL);
                miniStatIntent.setData(Uri.parse("tel:"+mainlist[banks][1]));
                startActivity(miniStatIntent);
            }
        });
        binding.relCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customerIntent = new Intent(Intent.ACTION_CALL);
                customerIntent.setData(Uri.parse("tel:"+mainlist[banks][2]));
                startActivity(customerIntent);
            }
        });
        binding.relLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                locationIntent.setData(Uri.parse(""+mainlist[banks][3]));
                startActivity(locationIntent);
            }
        });
        binding.relIFSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                locationIntent.setData(Uri.parse(""+mainlist[banks][4]));
                startActivity(locationIntent);
            }
        });
    }
}