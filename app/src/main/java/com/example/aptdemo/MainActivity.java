package com.example.aptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.processor.RuntimePermissions;

@RuntimePermissions
class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}