package cl.ceeinf.ligababy.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cl.ceeinf.ligababy.AdapterDatosPartido;
import cl.ceeinf.ligababy.AdapterDatosPosiciones;
import cl.ceeinf.ligababy.DatosPartidos;
import cl.ceeinf.ligababy.DatosPosiciones;
import cl.ceeinf.ligababy.Detalle_equipo;
import cl.ceeinf.ligababy.R;
import cl.ceeinf.ligababy.detalle_partido;

public class tabla_posiciones_1 extends ListFragment {

    // Array of strings storing country names
    String[] countries = new String[] {
            "India",
            "Pakistan",
            "Sri Lanka",
            "China",
            "Bangladesh",
            "Nepal",
            "Afghanistan",
            "North Korea",
            "South Korea",
            "Japan"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo1,
            R.drawable.logo2
    };

    // Array of strings to store currencies
    String[] PJ = new String[]{
            "10",
            "12",
            "12",
            "12",
            "12",
            "12",
            "12",
            "11",
            "12",
            "12"
    };
    String[] Pts = new String[]{
            "10",
            "12",
            "12",
            "12",
            "12",
            "12",
            "12",
            "11",
            "12",
            "12"
    };
    String[] GF = new String[]{
            "10",
            "12",
            "12",
            "12",
            "12",

            "12",
            "12",
            "11",
            "12",
            "12"
    };
    String[] GC = new String[]{
            "10",
            "12",
            "12",
            "12",
            "12",
            "12",
            "12",
            "11",
            "12",
            "12"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("PJ", PJ[i]);
            hm.put("GF", GF[i]);
            hm.put("GC", GC[i]);
            hm.put("Pts", Pts[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","PJ","GF","GC","Pts" };

        // Ids of views in item_tabla_posiciones_1
        int[] to = { R.id.flag,R.id.txt,R.id.PJ,R.id.GF,R.id.GC,R.id.Pts};

        // Instantiating an adapter to store each items
        // R.layout.item_tabla_posiciones_1 defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.item_tabla_posiciones_1, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        Toast.makeText(getActivity(), "Item " + pos + " was clicked", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(getActivity(), Detalle_equipo.class);
        startActivity(i);
    }


}
