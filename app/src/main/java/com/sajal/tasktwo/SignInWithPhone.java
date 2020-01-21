package com.sajal.tasktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;

public class SignInWithPhone extends AppCompatActivity {

    private EditText email;
    private SignInButton googleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_with_phone);

        if (Build.VERSION.SDK_INT>=19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        email=findViewById(R.id.editText);
        email.setHint("Phone");
        googleSignIn = (SignInButton) findViewById(R.id.googleButton);
    }
}
