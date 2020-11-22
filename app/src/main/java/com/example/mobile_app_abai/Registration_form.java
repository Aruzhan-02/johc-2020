package com.example.mobile_app_abai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration_form extends AppCompatActivity{
    EditText username, password, repassword;
    Button btnReg;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnReg = findViewById(R.id.btnReg);
        DB = new DBHelper(this);

        btnReg.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(Registration_form.this, "Барлық бөлімді толтырыңыз", Toast.LENGTH_SHORT).show();
            else {
                if(pass.equals(repass)) {
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser == false){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert == true){
                            Toast.makeText(this, "Cіз сәтті тіркелдіңіз!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login_Form.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(this, "Тіркелу процесі қате аяқталды", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this, "Бұл қолданушы қосымшаға бұған дейін тіркелген. Қайта кіріңіз", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Құпия сөз сәйкес келмейді", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }




}