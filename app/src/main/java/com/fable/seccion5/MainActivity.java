package com.fable.seccion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView ListaVistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando
        ListaVistas = findViewById(R.id.ListaVistas);

        //Datos a mostrar
        List<String> ListaElementos = new ArrayList<String>();
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

        List<String> ListaNombres = new ArrayList<String>() {{
            add("Yoly");
            add("Arturo");
            add("Magnolia");
            add("Tina");
        }};

        //Adaptador, la forma visual en que se muestran los datos
        ArrayAdapter<String> Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListaElementos);
        //R.layout.support_simple_spinner_dropdown_item

        //Se establece el adaptador en la Lista de Vista
        ListaVistas.setAdapter(Adaptador);

    }
}
