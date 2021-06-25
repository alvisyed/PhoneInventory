package com.dynamicdev.phoneinventory.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dynamicdev.phoneinventory.data.PhoneDetail;
import com.dynamicdev.phoneinventory.databinding.PhoneItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class PhoneInventoryAdapter extends BaseAdapter {
    private List<PhoneDetail>phoneDetailList=new ArrayList<>();

    public PhoneInventoryAdapter(List<PhoneDetail> phoneDetailList) {
        this.phoneDetailList = phoneDetailList;
    }

    public PhoneInventoryAdapter() {
    }

    public void setPhoneDetailList(List<PhoneDetail> phoneDetailList) {
        this.phoneDetailList = phoneDetailList;
    }

    @Override
    public int getCount() {
        return phoneDetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return phoneDetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }
private PhoneItemLayoutBinding binding;
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        binding=PhoneItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        PhoneDetail phoneDetail=phoneDetailList.get(position);
        binding.modelTextView.setText(phoneDetail.getModel());
        binding.priceTextView.setText("Price: "+phoneDetail.getPrice());
        binding.yearTextView.setText("Year: "+phoneDetail.getYear());
        return binding.getRoot();
    }
}
