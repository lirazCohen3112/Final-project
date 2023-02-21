package com.example.finalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;
import com.example.finalproject.client.MenuClientActivity;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SingActivity extends AppCompatActivity {

    private MaterialTextView sing_LBL_infa;
    private MaterialButton sing_BTN_sing;
    private MaterialButton sing_BTN_user;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing);

        findViews();

        mAuth = FirebaseAuth.getInstance();

        sing_BTN_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singIn();
            }
        });

        sing_BTN_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });
    }

    private void findViews() {
        sing_LBL_infa = findViewById(R.id.sing_LBL_infa);
        sing_BTN_sing = findViewById(R.id.sing_BTN_sing);
        sing_BTN_user = findViewById(R.id.sing_BTN_user);
    }

    private void singIn() {

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
               // .setLogo(R.drawable.headache)
                .build();
        signInLauncher.launch(signInIntent);

    }

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse r = result.getIdpResponse();
        String massage = result.toString();
        Log.d("pttt" , result.getIdpResponse().getProviderType() + "\n" + result.getIdpResponse());
    }

    private void updateUI() {
        FirebaseUser user = mAuth.getCurrentUser();
        String str = "USER: \n";
        if(user != null){
            str += "\n" + user.getUid();
            str += "\n" + user.getDisplayName();
            str += "\n" + user.getPhoneNumber();
        }
        sing_BTN_sing.setText(str);

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(user.getPhoneNumber().equals("+972520123456"))
        {
           openMenuActivity ();
        }
        if(currentUser != null && !user.getPhoneNumber().equals("+972520123456")){
            openMenuClientActivity ();
        }
    }

    private void openMenuActivity (){
        Intent intent = new Intent(SingActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void openMenuClientActivity (){
        Intent intent = new Intent(SingActivity.this, MenuClientActivity.class);
        startActivity(intent);
        finish();
    }
}
