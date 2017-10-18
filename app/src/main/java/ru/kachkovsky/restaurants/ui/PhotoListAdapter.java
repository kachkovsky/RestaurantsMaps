package ru.kachkovsky.restaurants.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.kachkovsky.restaurants.R;
import ru.kachkovsky.restaurants.data.bean.Photo;

public class PhotoListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private List<Photo> photos;

    public PhotoListAdapter(Context context, List<Photo> photos) {
        super(context, R.layout.listview_item_image, photos);

        this.context = context;
        this.photos = photos;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
        }

        Picasso
                .with(context)
                .load(photos.get(position).getPhotoReference())
                .fit() // will explain later
                .into((ImageView) convertView);

        return convertView;
    }
}
