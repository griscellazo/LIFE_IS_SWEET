package bo.nuevo.lifeissweet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bo.nuevo.lifeissweet.R;
import bo.nuevo.lifeissweet.model.Bakery;

public class BakeryListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Bakery> bakeryList;

    public BakeryListViewAdapter(Context context, List<Bakery> bakeryList) {
        this.context = context;
        this.bakeryList = bakeryList;
    }


    @Override
    public int getCount() {
        return this.bakeryList.size();
    }

    @Override
    public Bakery getItem(int position) {
        return this.bakeryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.bakeryList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.bakery_list_item_hrizontal, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewPokemon);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            viewHolder.textViewType = vista.findViewById(R.id.textViewType);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Bakery bakery = this.bakeryList.get(position);
        viewHolder.imageView.setImageResource(bakery.getImage());
        viewHolder.textViewName.setText(bakery.getName());
        viewHolder.textViewType.setText(bakery.getType());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}
