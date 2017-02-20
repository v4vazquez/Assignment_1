package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class ForgotPassword extends AppCompatActivity {
private Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btn4=(Button)findViewById(R.id.btn_Submit);
        btn4.setOnClickListener(new MyLstner4());

}
    private class MyLstner4 implements View.OnClickListener{
        public void onClick(View view){
            Intent intent4 = new Intent(ForgotPassword.this, LandingScreen.class);
            startActivity(intent4);
        }
    }
}
