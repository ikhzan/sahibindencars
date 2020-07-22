package com.training.sahibindencars.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.training.sahibindencars.R;
import com.training.sahibindencars.models.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private ArrayList<Item> cars;
    private static final String TAG = "ItemAdapter";

    public ItemAdapter(ArrayList<Item> cars){
        this.cars = cars;
        Log.d(TAG, "ItemAdapter: " + cars.size());
    }

    @NonNull
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.item_detail;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        view.setFocusable(true);
        return new ItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder car size: " + cars.size());
        Item item = cars.get(position);
        holder.modeltxt.setText(item.getModel());
        holder.countrytxt.setText(item.getCountry());
        holder.pricetxt.setText(item.getPrice());
        holder.brandtxt.setText(item.getBrand());
        holder.nametxt.setText(item.getName());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference spaceRef = storage.getReference();
        StorageReference rootRef = spaceRef.getRoot();
        spaceRef.getPath();

        switch (item.getBrand()){
            case "mercy":
                Picasso.get().load(R.drawable.mercy).into(holder.imageView);
                break;
            case "bmw":
                Picasso.get().load(R.drawable.bmw).into(holder.imageView);
                break;
            case "audi":
                Picasso.get().load("https://www.legitreviews.com/wp-content/uploads/2015/01/Audi-Logo.jpg").into(holder.imageView);
                break;
            case "toyota":
                Picasso.get().load("https://2.bp.blogspot.com/-LKH6ZjJg2ss/UR5DiI4rBZI/AAAAAAAAB8w/a1KVvxIyPoU/s1600/toyota-logo+(1).jpg").into(holder.imageView);
                break;
            case "hyundai":
                Picasso.get().load("https://listcarbrands.com/wp-content/uploads/2015/09/Hyundai-logo.jpg").into(holder.imageView);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt, brandtxt, modeltxt, pricetxt, countrytxt;
        ImageView imageView;

        public ItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nametxt = itemView.findViewById(R.id.nametxt);
            brandtxt = itemView.findViewById(R.id.brandtxt);
            modeltxt = itemView.findViewById(R.id.modeltxt);
            pricetxt = itemView.findViewById(R.id.pricetxt);
            countrytxt = itemView.findViewById(R.id.countrytxt);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
