package com.example.sportify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ReservationsAdapter extends BaseAdapter {
    private List<Reservation> reservationsList;
    private Context context;

    public ReservationsAdapter(List<Reservation> reservationsList, Context context) {
        this.reservationsList = reservationsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return reservationsList.size();
    }

    @Override
    public Object getItem(int position) {
        return reservationsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reservationsList.indexOf(reservationsList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_view_reservation, parent,false);
        Reservation reservation = reservationsList.get(position);

        TextView courtTextView = convertView.findViewById(R.id.res_court);
        TextView dateTextView = convertView.findViewById(R.id.res_date);
        TextView timeTextView = convertView.findViewById(R.id.res_time);

        courtTextView.setText(reservation.getCourtName());
        dateTextView.setText(reservation.getDate());
        timeTextView.setText(reservation.getTime());


        return convertView;
    }
}
