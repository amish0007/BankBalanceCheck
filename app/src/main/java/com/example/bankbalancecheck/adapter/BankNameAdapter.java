package com.example.bankbalancecheck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bankbalancecheck.R;

public class BankNameAdapter extends BaseAdapter {
    String[] banks={};

    public BankNameAdapter(String[] banks) {
        this.banks=banks;
    }

    @Override
    public int getCount() {
        return banks.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_name,parent,false);
        TextView txtBankName = view.findViewById(R.id.txtBankNames);
        txtBankName.setText(banks[position]);
        return view;

    }
}
