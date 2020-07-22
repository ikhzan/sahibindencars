package com.training.sahibindencars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.sahibindencars.models.Item;

public class AddItemActivity extends AppCompatActivity {

    private EditText nameedittxt, brandedittxt, modeledittxt, countryedittxt, priceedittxt;
    private Button addbtn;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference carRef = mRootRef.child("Cars");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        nameedittxt = findViewById(R.id.nametxt);
        brandedittxt = findViewById(R.id.brandtxt);
        modeledittxt = findViewById(R.id.modeltxt);
        countryedittxt = findViewById(R.id.countrytxt);
        priceedittxt = findViewById(R.id.pricetxt);
        addbtn = findViewById(R.id.addbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               carRef.push().setValue(new Item(nameedittxt.getText().toString(),modeledittxt.getText().toString(),brandedittxt.getText().toString(),priceedittxt.getText().toString(),countryedittxt.getText().toString()));
               finish();
            }
        });
    }
}
