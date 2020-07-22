package com.training.sahibindencars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.training.sahibindencars.adapters.RestaurantAdapter;

public class FireActivity extends AppCompatActivity implements
        View.OnClickListener,
        RestaurantAdapter.OnRestaurantSelectedListener{

    private FirebaseFirestore mFirestore;
    private Toolbar mToolbar;
    private TextView mCurrentSearchView;
    private TextView mCurrentSortByView;
    private RecyclerView mRestaurantsRecycler;
    private ViewGroup mEmptyView;

    private Query mQuery;

    private FilterDialogFragment mFilterDialog;
    private RestaurantAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initFireStore();
    }

    private void initFireStore(){
        mFirestore = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onRestaurantSelected(DocumentSnapshot restaurant) {

    }
}
