package com.fable.seccion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView ListaVistas;
    private List<String> ListaElementos;
    private List<String> ListaNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando
        ListaVistas = findViewById(R.id.ListaVistas);

        //Datos a mostrar
        ListaElementos = new ArrayList<String>();
        ListaElementos.add("Fabián");
        ListaElementos.add("Leidy");
        ListaElementos.add("Amparo");
        ListaElementos.add("Manuela");
        ListaElementos.add("Yoly");
        ListaElementos.add("Arturo");
        ListaElementos.add("Magnolia");
        ListaElementos.add("Tina");
        ListaElementos.add("Pachita");
        ListaElementos.add("R2");
        ListaElementos.add("Paz");
        ListaElementos.add("Muñeca");
        ListaElementos.add("Chelsea");

        ListaNombres = new ArrayList<String>() {{
            add("Yoly");
            add("Arturo");
            add("Magnolia");
            add("Tina");
        }};

        //Adaptador, la forma visual en que se muestran los datos
        ArrayAdapter<String> Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListaElementos);
        //R.layout.support_simple_spinner_dropdown_item

        //Se establece el adaptador en la Lista de Vistas
        ListaVistas.setAdapter(Adaptador);

        ListaVistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Presionado: " + ListaElementos.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //Se enlaza el adaptador personalizado
        Adaptador oAdaptador = new Adaptador(this, R.layout.lista_items, ListaElementos);
        ListaVistas.setAdapter(oAdaptador);
    }
}