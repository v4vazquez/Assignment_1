package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistrationPage extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button btn3;
    private EditText password, password2, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        //the button below links to the landing screen
        btn3=(Button)findViewById(R.id.btn_Reg);
        btn3.setOnClickListener(new MyLstner3());
    //the lines below are used for the validation
        final EditText email = (EditText)findViewById(R.id.Reg_Email);
        final EditText password = (EditText)findViewById(R.id.Reg_pass1);
        final EditText password2 = (EditText)findViewById(R.id.Reg_pass2);






            //lines of code below creates the dropdown to select your major
            Spinner s = (Spinner) findViewById(R.id.spin);
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(RegistrationPage.this, parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

    }



    //the lines of code below are used to display the calendar
    public void datePicker(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }


    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }

    private static class DatePickerFragment extends DialogFragment{
        public Dialog onCreateDialog(Bundle savedInstanceDate){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(),year,month,day);
        }
    }

    private class MyLstner3 implements View.OnClickListener {
        public void onClick(View view) {
            //Once a user registers, it links them to the landing page
            //Intent intent3 = new Intent(RegistrationPage.this, LandingScreen.class);
            //startActivity(intent3);

            //below is the string to check the minimum password
            EditText passText = (EditText)findViewById(R.id.Reg_pass1);
            String password = passText.getText().toString();
            if(TextUtils.isEmpty(password) || password.length() < 6){
                passText.setError("Your password needs to be 6 characters minimum");
            }

            //below is the string to check the email that is a montclair email
            EditText emailText = (EditText) findViewById(R.id.Reg_Email);
            String email = emailText.getText().toString();
                if(TextUtils.isEmpty(email) || !email.contains("montclair.edu")){
                    emailText.setError("Your emailaddress must be a Montclair University email");
                    return;
                }

        }


    }

}


