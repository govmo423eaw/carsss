package com.example.mashinki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CarAdapter extends ArrayAdapter<CartItem> {
    private Context context;
    private int resource;

    public CarAdapter(@NonNull Context context, int resource, @NonNull List<CartItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource, null);
        }

        CartItem cartItem = getItem(position);

        if (cartItem != null) {
            ImageView imageView = view.findViewById(R.id.cartItemImageView);
            TextView textView = view.findViewById(R.id.cartItemTextView);

            imageView.setImageResource(cartItem.getImageResource());
            textView.setText(cartItem.getName() + "\n" + cartItem.getDescription() + "\nКоличество: " + cartItem.getQuantity());
        }

        return view;
    }
}
