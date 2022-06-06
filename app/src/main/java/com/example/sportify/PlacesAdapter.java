package com.example.sportify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlacesAdapter extends BaseAdapter {
    private List<Place> placesList;
    private Context context;

    public PlacesAdapter(List<Place> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return placesList.size();
    }

    @Override
    public Object getItem(int position) {
        return placesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return placesList.indexOf(placesList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_view_item, parent,false);
        Place place = placesList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView titleTextView = convertView.findViewById(R.id.item_title);
        TextView descriptionTextView = convertView.findViewById(R.id.item_description);

        imageView.setImageResource(place.getImageResId());
        titleTextView.setText(place.getTitle());
        descriptionTextView.setText(place.getDescription());


        return convertView;
    }
}
