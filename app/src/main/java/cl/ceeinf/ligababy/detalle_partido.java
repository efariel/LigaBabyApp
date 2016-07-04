package cl.ceeinf.ligababy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.LoginFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import cl.ceeinf.ligababy.fragments.Login;

public class detalle_partido extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Button btnfoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detalle_partido);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        btnfoto = (Button)findViewById(R.id.new_foto);
        btnfoto.setOnClickListener(this);

        ListView listView = (ListView) findViewById(R.id.listView_goles);
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

        //Lista de las fotos de los partidos

        ListView listView2 = (ListView) findViewById(R.id.listView_fotos);
        ArrayList<Fotos> arrayfotos = new ArrayList<Fotos>();
        Fotos fotos;

        fotos = new Fotos(getResources().getDrawable(R.drawable.img1));
        arrayfotos.add(fotos);

        AdapterFotos adapterFotos = new AdapterFotos(this, arrayfotos);

        listView2.setAdapter(adapterFotos);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                // User chose the "Settings" item, show the app settings UI...
                Intent i = new Intent(detalle_partido.this, Login.class);
                startActivity(i);
                return true;

            /*case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;*/

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "detalle_partido Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cl.ceeinf.ligababy/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "detalle_partido Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cl.ceeinf.ligababy/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(detalle_partido.this, nueva_foto.class);
        startActivity(i);
    }
}
