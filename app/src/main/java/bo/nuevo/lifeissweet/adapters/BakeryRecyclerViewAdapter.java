package bo.nuevo.lifeissweet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bo.nuevo.lifeissweet.R;
import bo.nuevo.lifeissweet.adapters.BakeryViewHolder;
import bo.nuevo.lifeissweet.callback.BakeryCallback;
import bo.nuevo.lifeissweet.model.Bakery;

public class BakeryRecyclerViewAdapter extends RecyclerView.Adapter<BakeryViewHolder> {

    private List<Bakery> bakeryList;
    private LayoutInflater inflater;
    private BakeryCallback bakeryCallback;

    public BakeryRecyclerViewAdapter(Context context, List<Bakery> bakeryList) {
        this.bakeryList = bakeryList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BakeryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = this.inflater.inflate(R.layout.bakery_list_item, null);
        return new BakeryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BakeryViewHolder bakeryViewHolder, int position) {
        final Bakery bakery = this.bakeryList.get(position);
        bakeryViewHolder.imageView.setImageResource(bakery.getImage());
        bakeryViewHolder.textViewName.setText(bakery.getName());
        bakeryViewHolder.textViewType.setText(bakery.getType());
        bakeryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bakeryCallback != null) {
                    bakeryCallback.onBakeryClick(bakery);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.bakeryList.size();
    }

    public void setBakeryCallback(BakeryCallback bakeryCallback) {
        this.bakeryCallback = bakeryCallback;
    }
}