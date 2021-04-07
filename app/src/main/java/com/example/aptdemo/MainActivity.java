package com.example.aptdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.apt.demo.AutoClass;
import com.example.processor.annonation.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoClass autoClass = new AutoClass();
	}
}