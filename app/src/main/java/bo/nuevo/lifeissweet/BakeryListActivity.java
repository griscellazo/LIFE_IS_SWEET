package bo.nuevo.lifeissweet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import bo.nuevo.lifeissweet.BakeryDetailsActivity;
import bo.nuevo.lifeissweet.Constants;
import bo.nuevo.lifeissweet.R;
import bo.nuevo.lifeissweet.adapters.BakeryListViewAdapter;
import bo.nuevo.lifeissweet.model.Bakery;
import bo.nuevo.lifeissweet.utils.BakeryUtils;

public class BakeryListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_list);
        initViews();
        initToolbar();

        final List<Bakery> bakeryList = BakeryUtils.getBakerys();
        BakeryListViewAdapter adapter = new BakeryListViewAdapter(this, bakeryList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bakery bakery = bakeryList.get(position);
                Intent intent = new Intent(BakeryListActivity.this, BakeryDetailsActivity.class);
                intent.putExtra(Constants.BAKERY_SELECTED, gson.toJson(bakery));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        listview = findViewById(R.id.listViewMyBakerys);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_favorites_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}