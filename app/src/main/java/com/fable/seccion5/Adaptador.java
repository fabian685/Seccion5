package com.fable.seccion5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context Contexto;
    private int Plantilla;
    private List<String> Nombres;

    public Adaptador(Context Contexto, int Plantilla, List<String> Nombres) {
        this.Contexto = Contexto;
        this.Plantilla = Plantilla;
        this.Nombres = Nombres;
    }

    @Override
    public int getCount() {
        return this.Nombres.size();
    }

    @Override
    public Object getItem(int Posicion) {
        return this.Nombres.get(Posicion);
    }

    @Override
    public long getItemId(int ID) {
        return ID;
    }

    @Override
    public View getView(int Posicion, View ConvertView, ViewGroup viewGroup) {

        //Se copia la vista
        View v = ConvertView;

        //Se infla la vista que ha llegado con el layout
        LayoutInflater PlantillaI = LayoutInflater.from(this.Contexto);
        v = PlantillaI.inflate(R.layout.lista_items, null);

        //Se trae el valor actual de la posición
        String NombreActual = Nombres.get(Posicion);
        //NombreActual = (String)getItem(Posicion);

        //Se referencia el elemento a modificar y se rellena
        TextView VistaTexto = v.findViewById(R.id.VistaTexto);
        VistaTexto.setText(NombreActual);

        //Se devuelve la vista inflada y modificada con los datos
        return  v;
    }
}
