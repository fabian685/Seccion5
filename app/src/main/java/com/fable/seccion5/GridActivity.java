package com.fable.seccion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView VistaRejilla;
    private List<String> ListaElementos;

    private Adaptador oAdaptador;

    private int Contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //Instanciando
        VistaRejilla = findViewById(R.id.VistaRejilla);

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
        ListaElementos.add("Bryan");
        ListaElementos.add("Jennifer");
        ListaElementos.add("Sindy");
        ListaElementos.add("LeidyM");
        ListaElementos.add("Jonathan");
        ListaElementos.add("Sahily");
        ListaElementos.add("Miguel");
        ListaElementos.add("GatoB");
        ListaElementos.add("GatoL");

        VistaRejilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Presionado: " + ListaElementos.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //Se enlaza el adaptador personalizado
        //Adaptador oAdaptador = new Adaptador(this, R.layout.rejilla_items, ListaElementos);
        oAdaptador = new Adaptador(this, R.layout.rejilla_items, ListaElementos);
        VistaRejilla.setAdapter(oAdaptador);

        registerForContextMenu(VistaRejilla);
    }

    //Se infla el layout del menú opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater MenuI = getMenuInflater();
        MenuI.inflate(R.menu.barra_menu_accion, menu);
        return true;
    }

    //Se manejan los eventos clic en el menú de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ItemAgregar:
                //Se añade nuevo nombre
                this.ListaElementos.add("Agregado N°" + (++Contador));
                //Se notifica al adaptador del cambio
                this.oAdaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Se infla layout del menú contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater CMenuI = getMenuInflater();

        AdapterView.AdapterContextMenuInfo Info=(AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(this.ListaElementos.get(Info.position));

        CMenuI.inflate(R.menu.menu_contexto, menu);
    }

    //Se maneja clic sobre el menú contexto
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.ItemBorrar:
                //Se borra el nombre
                //this.ListaElementos.add("Agregado N°" + (++Contador));
                this.ListaElementos.remove(Info.position);
                //Se notifica al adaptador del cambio
                this.oAdaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
