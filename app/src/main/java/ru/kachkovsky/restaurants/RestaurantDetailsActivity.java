package ru.kachkovsky.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.kachkovsky.restaurants.data.bean.Result;
import ru.kachkovsky.restaurants.ui.PhotoListAdapter;

public class RestaurantDetailsActivity extends AppCompatActivity {

    public static final String ACTIVITY_INTENT_BUNDLE_KEY = "ACTIVITY_INTENT_BUNDLE_KEY";

    private ImageView imageViewIcon;
    private TextView textViewName;
    private TextView textViewDescription;
    private ListView listDays;
    private ListView listPhotos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_rest_details);

        imageViewIcon = (ImageView) findViewById(R.id.imageViewIcon);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        listDays = (ListView) findViewById(R.id.listDays);
        listPhotos = (ListView) findViewById(R.id.listPhotos);

        Bundle bundleExtra = getIntent().getExtras();
        Result result = (Result) bundleExtra.getSerializable(ACTIVITY_INTENT_BUNDLE_KEY);
        textViewName.setText(result.getName());
        textViewDescription.setText(result.getVicinity());
        if (result.getOpeningHours() != null && result.getOpeningHours().getWeekdayText() != null) {
            listDays.setAdapter(new ArrayAdapter<>(this, R.layout.item_hours, R.id.textViewHours, result.getOpeningHours().getWeekdayText()));
        }
        if (result.getIcon() != null) {
            Picasso.with(this.getApplicationContext())
                    .load(result.getIcon())
                    .into(imageViewIcon);
        }
        if (result.getPhotos() != null) {
            //listPhotos.setAdapter(new PhotoListAdapter(this, result.getPhotos()));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
