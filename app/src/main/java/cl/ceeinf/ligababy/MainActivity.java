package cl.ceeinf.ligababy;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//import com.firebase.client.Firebase;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import cl.ceeinf.ligababy.fragments.tabla_posiciones_1;
import cl.ceeinf.ligababy.fragments.tabla_posiciones_2;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
        inicializarTabs();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView mTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(myToolbar);
        //Firebase myFirebaseRef = new Firebase("https://LigaBaby.firebaseio.com/");

        ListView listView = (ListView) findViewById(R.id.listaPartidos);
        ArrayList<DatosPartidos> arraydatos = new ArrayList<DatosPartidos>();
        DatosPartidos datosPartidos;

        //Introducir los datos
        datosPartidos = new DatosPartidos(getResources().getDrawable(R.drawable.logo1),
                getResources().getDrawable(R.drawable.logo2),
                "River",
                "Boca",
                "4 septiembre",
                "18:00");
        arraydatos.add(datosPartidos);

        datosPartidos = new DatosPartidos(getResources().getDrawable(R.drawable.logo2),
                getResources().getDrawable(R.drawable.logo1),
                "Boca",
                "River",
                "9 septiembre",
                "19:00");
        arraydatos.add(datosPartidos);

        AdapterDatosPartido adapterDatosPartido = new AdapterDatosPartido(this, arraydatos);


        listView.setAdapter(adapterDatosPartido);


        // React to user clicks on item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {

                Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] ",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, detalle_partido.class);

                startActivity(i);
            }
        });

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });
*/

        tabla_posiciones_1 tabla_posiciones1 = new tabla_posiciones_1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentsContainerFrameLayout,
                tabla_posiciones1);
        fragmentTransaction.commit();

        setearBoton();

       /* ListView listViewposiciones = (ListView) findViewById(R.id.lista_tablaposiciones);

        ArrayList<DatosPosiciones> arraydatosposiciones = new ArrayList<DatosPosiciones>();
        DatosPosiciones datosposiciones;

        //Introducir los datos
        datosposiciones = new DatosPosiciones(getResources().getDrawable(R.drawable.logo1),
                "River",
                "13",
                "12",
                "23",
                "7");
        arraydatosposiciones.add(datosposiciones);

        AdapterDatosPosiciones adapterDatosPosiciones = new AdapterDatosPosiciones(this, arraydatosposiciones);

        listViewposiciones.setAdapter(adapterDatosPosiciones);*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                return true;

           /* case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;*/

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



    private void inicializarTabs() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Partidos");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Posiciones");
        tabHost.addTab(spec);
    }



    private void setearBoton() {

        ToggleButton detalleButton = (ToggleButton)
                findViewById(R.id.detalleToggleButton);

        if(detalleButton != null){
            detalleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton,
                                             boolean isOn) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    if(isOn){
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_left,
                                R.anim.slide_out_to_right);
                        fragmentTransaction.replace(R.id.fragmentsContainerFrameLayout,
                                new tabla_posiciones_2());
                    }else{
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
                                R.anim.slide_out_to_left);
                        fragmentTransaction.replace(R.id.fragmentsContainerFrameLayout,
                                new tabla_posiciones_1());
                    }
                    fragmentTransaction.commit();
                }
            });
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
                "Main Page", // TODO: Define a title for the content shown.
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
                "Main Page", // TODO: Define a title for the content shown.
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
}
