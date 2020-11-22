package com.example.mobile_app_abai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Form extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, btnReg;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnReg = findViewById(R.id.btnReg);
        DB = new DBHelper(this);



       btnReg.setOnClickListener(v -> {
           Intent intent = new Intent(getApplicationContext(), Registration_form.class);
           startActivity(intent);
       });

       btnLogin.setOnClickListener(v -> {
           String user = username.getText().toString();
           String pass = password.getText().toString();

           if (user.equals("")||pass.equals(""))
               Toast.makeText(this, "Барлық бөлімді толтырыңыз", Toast.LENGTH_SHORT).show();
           else {
               Boolean checkuserpass = DB.checkusernamepassword(user, pass);
               if(checkuserpass==true){
                   Toast.makeText(this, "Cіз өз профильіңізге сәтті кірдіңіз", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                   startActivity(intent);
               }else {
                   Toast.makeText(this, "Қолданушы аты немесе құпия сөз қате терілді", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
}