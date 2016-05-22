package cl.ceeinf.ligababy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Detalle_equipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        ListView listView = (ListView) findViewById(R.id.listView_goleadores);
        ArrayList<DatosGoles> arraydatos = new ArrayList<DatosGoles>();
        DatosGoles datosGoles;

        //Introducir los datos
        datosGoles = new DatosGoles(getResources().getDrawable(R.drawable.logo1),
                "Claudio");
        arraydatos.add(datosGoles);
        datosGoles = new DatosGoles(getResources().getDrawable(R.drawable.logo1),
                "Alex");
        arraydatos.add(datosGoles);
        datosGoles = new DatosGoles(getResources().getDrawable(R.drawable.logo1),
                "Maximiliano");
        arraydatos.add(datosGoles);
        datosGoles = new DatosGoles(getResources().getDrawable(R.drawable.logo1),
                "Camila");
        arraydatos.add(datosGoles);
        datosGoles = new DatosGoles(getResources().getDrawable(R.drawable.logo1),
                "Esteban");
        arraydatos.add(datosGoles);

        AdapterDatosGoles adapterDatosGoles = new AdapterDatosGoles(this, arraydatos);


        listView.setAdapter(adapterDatosGoles);




    }

}
