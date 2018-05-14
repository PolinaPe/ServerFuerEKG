package com.example.user.serverfuerekg;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.UUID;

public class Main2Activity extends AppCompatActivity {
    private BluetoothServerSocket _serverSocket;
    private BluetoothAdapter _bluetooth= BluetoothAdapter.getDefaultAdapter();
    BluetoothSocket socket = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "probet", Toast.LENGTH_SHORT).show();
        new Thread() {
            public void run() {
                connect();

            }

        }.start();
        Toast.makeText(this, "gestrtet", Toast.LENGTH_SHORT).show();
    }

    protected void connect() {
        try {
			/* Create BT service
			 * param£ºserver name¡¢UUID
			 */

            _serverSocket = _bluetooth.listenUsingRfcommWithServiceRecord("EKG",
                    UUID.fromString("a60f35f0-b93a-11de-8a39-08002009c666"));


            // ClientSocket zustimmen
            socket = _serverSocket.accept();
            Toast.makeText(this, "kann nicht verbinden", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
    }
    /* Die Daten eintippen und absenden */
    public void onSendButtonClicked(View view) {
        while(true){
        try{
            if (socket != null) {
                Toast.makeText(this, "daten schicken", Toast.LENGTH_SHORT).show();
                OutputStream outputStream = socket.getOutputStream();
                ArrayList<String> list = new ArrayList<String>();
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("140");
                list.add("100");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("220");
                list.add("20");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("140");
                list.add("100");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                list.add("120");
                for (String s: list){
                byte[] b = s.getBytes(); // Daten in byte Collection
                outputStream.write(b); // Daten reinschreiben
                    Thread.sleep(3000);
               }
            }

            }

        catch (IOException e) {
            Log.e("Can't send Date", "", e);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
    protected void onDestroy() {
        super.onDestroy();
        if (socket != null) {
            try {
                // Server schliessen
                socket.close();
            } catch (IOException e) {
                Toast.makeText(this, "Server kann nicht geschlossen werden", Toast.LENGTH_SHORT).show();
            }
        }
    }

}


