package com.training.sahibindencars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LoginActivity";
    private EditText usernameedittxt, passeditxt;
    private Button loginbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameedittxt = findViewById(R.id.usernameedittxt);
        passeditxt = findViewById(R.id.passedittxt);
        loginbtn = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();

        Log.d(TAG, "onCreate: " + mAuth.getCurrentUser().getEmail());

        loginbtn.setOnClickListener(this);

//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!TextUtils.isEmpty(usernameedittxt.getText().toString())&& !TextUtils.isEmpty(passeditxt.getText().toString())){
//                    SharedPreferences shp = getSharedPreferences("sahibindenpref", MODE_PRIVATE);
//                    if (shp.getString("username","somth").equalsIgnoreCase(usernameedittxt.getText().toString())
//                                && shp.getString("password","somth").equalsIgnoreCase(passeditxt.getText().toString())){
//                        SharedPreferences.Editor shpEditor  = shp.edit();
//                        shpEditor.putBoolean("loggedin",true);
//                        shpEditor.apply();
//                        // get current user on db
//                        // FirebaseUser currentUser = mAuth.getCurrentUser();
//                    }else{
//                        Toast.makeText(getApplicationContext(),"username or password wrong",Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.loginbtn){
            String email = usernameedittxt.getText().toString();
            String password = passeditxt.getText().toString();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();

                        Log.d(TAG, "onComplete: current user ?  " + user.getEmail());
                        SharedPreferences shp = getSharedPreferences("sahibindenpref", MODE_PRIVATE);
                        SharedPreferences.Editor shpEditor  = shp.edit();
                        shpEditor.putBoolean("loggedin",true);

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }else
                        Log.d(TAG,"Failed " + task.getException());
                }
            });
        }
    }

    private void loginUser(View view){
        Log.d(TAG, "loginUser: ");
    }
}
