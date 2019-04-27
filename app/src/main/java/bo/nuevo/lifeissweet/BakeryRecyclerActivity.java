package bo.nuevo.lifeissweet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.util.List;

import bo.nuevo.lifeissweet.BakeryDetailsActivity;
import bo.nuevo.lifeissweet.Constants;
import bo.nuevo.lifeissweet.R;
import bo.nuevo.lifeissweet.adapters.BakeryRecyclerViewAdapter;
import bo.nuevo.lifeissweet.callback.BakeryCallback;
import bo.nuevo.lifeissweet.model.Bakery;
import bo.nuevo.lifeissweet.utils.BakeryUtils;

public class BakeryRecyclerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_recycler);
        initViews();
        initToolbar();

        List<Bakery> bakeryList = BakeryUtils.getBakerys();
        BakeryRecyclerViewAdapter adapter = new BakeryRecyclerViewAdapter(this, bakeryList);
        adapter.setBakeryCallback(new BakeryCallback() {
            @Override
            public void onBakeryClick(Bakery bakery) {
                Intent intent = new Intent(BakeryRecyclerActivity.this, BakeryDetailsActivity.class);
                intent.putExtra(Constants.BAKERY_SELECTED, gson.toJson(bakery));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewMyBakerys);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_list_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}