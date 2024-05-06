package com.example.bankbalancecheck.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbalancecheck.R;
import com.example.bankbalancecheck.databinding.ActivityGstCalculatorBinding;

public class GstCalculatorActivity extends AppCompatActivity {
    ActivityGstCalculatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGstCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgGstBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.cvGSTCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtGstAmt = binding.edtGSTAmt.getText().toString();
                String edtGSTRate = binding.edtGSTRate.getText().toString();

                if(edtGstAmt.isEmpty())
                {
                    binding.edtGSTAmtLayout.setErrorEnabled(true);
                    binding.edtGSTAmtLayout.setError("Enter Total Amount");
                }
                else if(edtGSTRate.isEmpty())
                {
                    binding.edtGSTRateLayout.setErrorEnabled(true);
                    binding.edtGSTRateLayout.setError("Enter GST Rate");
                }
                else
                {
                    binding.edtGSTAmtLayout.setErrorEnabled(false);
                    binding.edtGSTRateLayout.setErrorEnabled(false);
                    if(binding.rgGst.getCheckedRadioButtonId()== R.id.rbGSTExclusive)
                    {

                        double ExAmt = Double.parseDouble(edtGstAmt);
                        double ExRate = Double.parseDouble(edtGSTRate);

                        double ExclusiveGST = ExAmt*ExRate/100;
                        double PostAmount = ExAmt+ExclusiveGST;

                        ExclusiveGST=Math.floor(ExclusiveGST);
                        PostAmount=Math.floor(PostAmount);
                        binding.txtTotalGST.setText("Total GST");
                        binding.txtTotalGSTAmount.setText("Post-GST Amount");
                        binding.ansTotalGST.setText(""+ExclusiveGST);
                        binding.ansTotalGSTAmount.setText(""+PostAmount);
                    }
                    else
                    {
//                        GST Amount = Original Cost – (Original Cost * (100 / (100 + GST% ) ) )
//                        Net Price = Original Cost – GST Amount

                        double InAmt = Double.parseDouble(edtGstAmt);
                        double InRate = Double.parseDouble(edtGSTRate);

                        double InclussiveGST = InAmt-(InAmt*(100/(100+InRate)));
                        double PreAmount = InAmt-InclussiveGST;

                        InclussiveGST=Math.floor(InclussiveGST);
                        PreAmount=Math.floor(PreAmount);
                        binding.txtTotalGST.setText("Total GST");
                        binding.txtTotalGSTAmount.setText("Pre-GST Amount");
                        binding.ansTotalGST.setText(""+InclussiveGST);
                        binding.ansTotalGSTAmount.setText(""+PreAmount);

                    }
                }
            }
        });


        binding.gstClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edtGSTAmt.setText("");
                binding.edtGSTRate.setText("");
                binding.txtTotalGST.setText("");
                binding.txtTotalGSTAmount.setText("");
                binding.ansTotalGST.setText("");
                binding.ansTotalGSTAmount.setText("");
            }
        });
    }
}