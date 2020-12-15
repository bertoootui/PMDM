package com.example.alberto_p1_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Entrenamiento entrenamiento = new Entrenamiento();

    ArrayList<Entrenamiento> listaEntrenamiento;
    RecyclerView recycler;
    RecyclerView.Adapter adaptador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaEntrenamiento = new ArrayList<>();
        Button btAdd = (Button) this.findViewById( R.id.butañadir );
        recycler = findViewById(R.id.recyclerid);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);


        //llenar ArrayList




        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onAdd();
            }
        });
        adaptador = new Adapter(listaEntrenamiento);
        
        recycler.setAdapter(adaptador);



    }

    private void onAdd() {


        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle("Añadir entrenamieto");


        View v = getLayoutInflater().inflate(R.layout.custom_alertdialog, null);
        builder.setView(v);
        final EditText txtfecha  = (EditText) v.findViewById(R.id.txtfecha);
        final EditText txttiempo = (EditText) v.findViewById(R.id.txtTiempo);
        final EditText txtdistancia = (EditText) v.findViewById(R.id.txtDistancia);

        builder.setPositiveButton( "+", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                entrenamiento = new Entrenamiento();

                String fecha = txtfecha.getText().toString();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
               Date fechaDate = null;
                try {
                   fechaDate = formato.parse(fecha);
                }
                catch (ParseException ex) {
                    Toast t = Toast.makeText(getApplicationContext(), "Valor no válido",Toast.LENGTH_LONG);
                    t.show();
                    entrenamiento.setFecha(fechaDate);
                }


                String tiempo = txttiempo.getText().toString();
                Double tiempo2= Double.valueOf(tiempo);
                entrenamiento.setTiempo(tiempo2);


                String distancia = txtdistancia.getText().toString();
                Double disntacia2 = Double.valueOf(distancia);
                entrenamiento.setDistancia(disntacia2);
                listaEntrenamiento.add(entrenamiento);


                MainActivity.this.updateStatus();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();




    }


    private void updateStatus() {
        TextView txtNum = (TextView) this.findViewById( R.id.lblNum );
        txtNum.setText( Integer.toString( this.adaptador.getItemCount() ) );
    }



}//edn class