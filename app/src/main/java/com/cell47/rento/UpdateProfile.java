package com.cell47.rento;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateProfile extends AppCompatActivity {

    private EditText email, phone, pass, confPass;
    private String em, ph;
    private Button btn;
    private DatabaseReference mDataBaseRefadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.password);
        confPass = findViewById(R.id.Cpassword);
        ph = getIntent().getStringExtra("shared");
        btn = findViewById(R.id.update);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().equals(""))
                {
                    FirebaseDatabase.getInstance().getReference().child("users").child(ph).child("Email").setValue(email.getText().toString());
                }
                if(!phone.getText().toString().equals(""))
                {
                    FirebaseDatabase.getInstance().getReference().child("users").child(ph).child("mobile").setValue(phone.getText().toString());
                }
                if(!pass.getText().toString().equals(""))
                {
                    if(pass.getText().toString().equals(confPass.getText().toString()))
                    {
                        try{
                            String passwd = EncryptDecrypt.encrypt(pass.getText().toString());
                            FirebaseDatabase.getInstance().getReference().child("users").child(ph).child("password").setValue(passwd);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        confPass.setError("Confirm password and new password should match");
                    }
                }
                finish();
            }
        });
    }
}
