package com.example.mashinki;

import android.os.Parcel;
import android.os.Parcelable;
public class CartItem implements Parcelable {
    private String name;
    private String description;
    private int quantity;
    private int imageResource;

    public CartItem(String name, String description, int imageResource, int quantity) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    protected CartItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        imageResource = in.readInt();
        quantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(imageResource);
        dest.writeInt(quantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };
}
