package com.example.botonletranif.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.botonletranif.R;
import com.example.botonletranif.core.CalcularLetraNIF;

public class MainActivity  extends AppCompatActivity {
    EditText edDni = this.findViewById( R.id.edDni );
    TextView lblLetra = this.findViewById( R.id.lblResult);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edDni = this.findViewById( R.id.edDni );


    }


    private void calcula(View x) {
        // Connect components
    edDni = this.findViewById(R.id.edDni);
// Reckon the letter and display it
        try {
            if(edDni.getText().toString().isEmpty())
            {
                lblLetra.setText("No se ha introducido un dni");


            }
            else{
            int dni = Integer.parseInt( edDni.getText().toString() );
            char letra = CalcularLetraNIF.calcularLetraNif( dni );
            lblLetra.setText( Character.toString( letra ) );}
        } catch(NumberFormatException fmt)
        {
            lblLetra.setText( R.string.label_default_result );
        }

    }//end calcula

}
