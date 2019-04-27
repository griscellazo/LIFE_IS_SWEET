package bo.nuevo.lifeissweet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import bo.nuevo.lifeissweet.model.Bakery;

public class BakeryDetailsActivity extends AppCompatActivity {

    private ImageView bakeryImage;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typeTextView;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_details);
        initViews();

        Bakery bakery = this.gson.fromJson(getIntent().getStringExtra(Constants.BAKERY_SELECTED), Bakery.class);

        fillBakeryData(bakery);
    }

    // Esto ya saben!
    private void initViews() {
        this.bakeryImage = findViewById(R.id.pokemonImage);
        this.nameTextView = findViewById(R.id.nameTextView);
        this.idTextView = findViewById(R.id.idTextView);
        this.typeTextView = findViewById(R.id.typeTextView);
    }

    private void fillBakeryData(Bakery bakery) {
        this.bakeryImage.setImageResource(bakery.getImage());
        this.nameTextView.setText(bakery.getName());
        this.idTextView.setText(String.valueOf(bakery.getId()));
        this.typeTextView.setText(bakery.getType());
    }
}