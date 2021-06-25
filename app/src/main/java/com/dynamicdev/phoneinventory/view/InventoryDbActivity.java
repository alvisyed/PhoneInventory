package com.dynamicdev.phoneinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.dynamicdev.phoneinventory.R;
import com.dynamicdev.phoneinventory.data.DataBase;
import com.dynamicdev.phoneinventory.data.PhoneDetail;
import com.dynamicdev.phoneinventory.databinding.ActivityInventoryDbBinding;
import com.dynamicdev.phoneinventory.view.adapter.PhoneInventoryAdapter;

import java.util.List;

public class InventoryDbActivity extends AppCompatActivity {
    private ActivityInventoryDbBinding binding;
    private DataBase db;
    private PhoneInventoryAdapter phoneInventoryAdapter = new PhoneInventoryAdapter();
    private PhoneDetail.Manufacture setManufacture= PhoneDetail.Manufacture.APPLE;
    private String[] option={
            PhoneDetail.Manufacture.APPLE.name(),
            PhoneDetail.Manufacture.SAMSUNG.name(),
            PhoneDetail.Manufacture.GOOGLE.name()};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInventoryDbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db=new DataBase(this);
        readPhoneDetail();
        binding.phoneListview.setAdapter(phoneInventoryAdapter);
        binding.manufactureSpinner.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_item,R.id.manufacture_name,option));
        binding.manufactureSpinner.setSelection(0);
        binding.manufactureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setManufacture = PhoneDetail.Manufacture.valueOf(option[position]);}
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });



                binding.confirmButton.setOnClickListener(view -> {
                   String model= binding.modelEdittext.getText().toString().trim();
                    int year=Integer.parseInt(binding.yearEdittext.getText().toString());
                  int price=  Integer.parseInt(binding.priceEdittext.getText().toString());
                    //String model, int year, double price, Manufacture manufacture
                    PhoneDetail newPhoneDetail =new PhoneDetail(model,year,price,setManufacture);
                    db.insertPhoneDetail(newPhoneDetail);
                });
    }
    private void readPhoneDetail(){
        List<PhoneDetail> phoneDetailList = db.getPhoneDetail();
        phoneInventoryAdapter.setPhoneDetailList(phoneDetailList);
    }
}
