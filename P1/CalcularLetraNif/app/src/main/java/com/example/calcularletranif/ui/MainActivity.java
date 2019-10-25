package com.example.calcularletranif.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calcularletranif.core.CalcularLetraNif;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edDni = this.findViewById( R.id.edDni );
        edDni.setOnKeyListener( new View.OnKeyListener() {
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                MainActivity.this.calcula();
                return false;
            }
        });

    }

    private void calcula() {
        // Connect components
                EditText edDni = this.findViewById( R.id.edDni );
        TextView lblLetra = this.findViewById( R.id.lblResult
        );
// Reckon the letter and display it
        try {
            int dni = Integer.parseInt( edDni.getText().toString() );
            char letra = CalcularLetraNif.calcularLetraNif( dni );
            lblLetra.setText( Character.toString( letra ) );
        } catch(NumberFormatException fmt)
        {
            lblLetra.setText( R.string.label_default_result );
        }

    }//end calcula
}


