package com.dynamicdev.phoneinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.dynamicdev.phoneinventory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(view->{
            Intent intent =new Intent(this,InventoryDbActivity.class);
            startActivity(intent);
        });
    }
}