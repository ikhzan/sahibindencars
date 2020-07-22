package com.training.sahibindencars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.training.sahibindencars.adapters.ItemAdapter;
import com.training.sahibindencars.models.Item;
import com.training.sahibindencars.services.MyJobService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * @TODO
     * 1. write login page access
     * 2. if login ok show add button else don't show
     * updated at 21-07-2020
     * by ihsan
     * 3. i update shareprefence function to check login
     */

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference carRef = mRootRef.child("Cars");
    private static final String TAG = "MainActivity";
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;
    private ArrayList<Item> cars = new ArrayList<>();
    private Iterable<DataSnapshot> carsSnap;
    private ImageView addimg, loginimg, regimg;
    private FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rc_items);
        mProgressBar = findViewById(R.id.progressBar);
        addimg = findViewById(R.id.addcar);
        loginimg = findViewById(R.id.loginimg);
        regimg = findViewById(R.id.regimg);

        // to write shareprefence
        setPreference();
        SharedPreferences shp = getSharedPreferences("sahibindenpref", MODE_PRIVATE);
        boolean isloggedin = shp.getBoolean("loggedin",false);
        if (isloggedin){
            loginimg.setVisibility(View.GONE);
            addimg.setVisibility(View.VISIBLE);
        }else{
            loginimg.setVisibility(View.VISIBLE);
            addimg.setVisibility(View.GONE);
        }

        carRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    Log.d(TAG, "onDataChange: " + data.getValue(Item.class));
                    cars.add(data.getValue(Item.class));
                }
                mItemAdapter = new ItemAdapter(cars);
                RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(lm);
                mRecyclerView.setAdapter(mItemAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // it is canceled
            }
        });

        addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddItemActivity.class));
            }
        });

        loginimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        regimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setPreference(){
        SharedPreferences shp = getSharedPreferences("sahibindenpref", MODE_PRIVATE);
        SharedPreferences.Editor shpEditor  = shp.edit();
        shpEditor.putString("username","alice");
        shpEditor.putString("password","alice1234");
        //shpEditor.commit();
        shpEditor.apply();
    }

    public void scheduleJob() {
        ComponentName serviceComponent = new ComponentName(getApplicationContext(), MyJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        builder.setMinimumLatency(1 * 1000); // wait at least
        builder.setOverrideDeadline(3 * 1000); // maximum delay
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        builder.setRequiresCharging(false); // we don't care if the device is charging or not
        JobScheduler jobScheduler = getApplicationContext().getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());
    }

}



