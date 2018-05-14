package com.example.user.serverfuerekg;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;;
import android.view.View;


public class MainActivity extends Activity {

//BT Adapter bekommen
private BluetoothAdapter _bluetooth = BluetoothAdapter.getDefaultAdapter();
private static final int REQUEST_DISCOVERABLE = 0x2;// int=10

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        }
public void click(View view)
        {

        _bluetooth.enable();

        Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE); // Make device discoverable
        startActivityForResult(enabler, REQUEST_DISCOVERABLE); // Make device discoverable


        }
public void weiter(View view) {
        Intent start = new Intent(this, Main2Activity.class);
        startActivity(start);
        }

        }