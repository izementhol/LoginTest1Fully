package sdu.cs58.jirawat.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร

    EditText nameEditText,usernameEditText,passwodEditText;
    Button LonginButton;
    String nameString,userSring,passString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initial view ผูกตัวแปร java ให้รู้จักับ element บน xml
        nameEditText =findViewById(R.id.txvname);
        usernameEditText =findViewById(R.id.txtusername);
        passwodEditText =findViewById(R.id.txtpassword);
        LonginButton = findViewById(R.id.bntLogin);

        LonginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ดึงข้อมูล User ป้อนในหน้า UI มาเก็บในตัวแปรชนิด String
                nameString = nameEditText.getText().toString().trim();
                userSring = usernameEditText.getText().toString().trim();
                passString = passwodEditText.getText().toString().trim();
                //ตรวจสอบค่าว่าง
                if ((nameString.length() == 0) || (userSring.length() == 0) || (passString.length() == 0)) {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show();
                }
                //ตรวจสอบการ Login
                if ((userSring.equals("admin")) && (passString.equals("1234"))) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.putExtra("nameString", nameString);
                    startActivity(mainIntent);

                } else {
                    Toast.makeText(getApplicationContext(), "Login Fail!!!", Toast.LENGTH_SHORT).show();
                }
            }
            });//end OnclickListener
            }//end method onCreate
    }//end class