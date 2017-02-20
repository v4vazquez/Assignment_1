package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    @Override

    //Lines of code below create the buttons that will put the user into the UI that is connected to the buttons
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links the first button for the forgetpassword UI
        btn1=(Button)findViewById(R.id.btn_forgetpassword_MA);
        btn1.setOnClickListener(new MyLstner());

        //links the second button for the Registration UI
        btn2=(Button)findViewById(R.id.btn_register_MA);
        btn2.setOnClickListener(new MyLstner2());

        //links the third button for the Landing Page UI
        btn3=(Button)findViewById(R.id.btn_login);
        btn3.setOnClickListener(new MyLstner3());

    }

    //lines of code below gives an intent for the buttons in the OnCreate bundle class for the forgotten password UI
    private class MyLstner implements View.OnClickListener {
        public void onClick(View view) {
            //Links forgotpassword.
            Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
                    startActivity(intent);

        }
    }
    //lines of code below gives an intent for the buttons in the onCreate bundle class for the Registration Page UI
    private class MyLstner2 implements View.OnClickListener {
        public void onClick(View view){
            Intent intent2 = new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(intent2);
        }
    }

    private class MyLstner3 implements View.OnClickListener{
        public void onClick(View view){
            Intent intent3 = new Intent(MainActivity.this, LandingScreen.class);
                startActivity(intent3);
        }
    }

}
