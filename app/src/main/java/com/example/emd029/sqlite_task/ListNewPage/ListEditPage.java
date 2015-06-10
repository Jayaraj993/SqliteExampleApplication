package com.example.emd029.sqlite_task.ListNewPage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.emd029.sqlite_task.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ListEditPage extends AppCompatActivity {
    TextView timeshow,dateshow;
    EditText personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_edit_page);
        Intent intent=getIntent();
        String name=intent.getStringExtra("person name");
        personName= (EditText) findViewById(R.id.PersonName);
        personName.setText(name);


    }
    public void datePicker() {
        Calendar date = Calendar.getInstance();
        //to show current date in the datepicker
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month1=monthOfYear+1;
                dateshow.setText("" + String.valueOf(dayOfMonth) + "/" + String.valueOf(month1) + "/" + String.valueOf(year));

            }
        }, year, month, day);
        datePickerDialog.setTitle("Select a date");
        datePickerDialog.show();
    }

    public void timePicker(){
        final Calendar time=Calendar.getInstance();
        int hour=time.get(Calendar.HOUR);
        final int miniute=time.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String a = String.format("%02d", hourOfDay);
                String b = String.format("%02d", minute);
                timeshow.setText("" + a + ":" + b);
            }
        }, hour, miniute, false);
        timePickerDialog.setTitle("select the time");
        timePickerDialog.show();

    }

    public void dateClickFunction(View view) {
        dateshow= (TextView) findViewById(R.id.dateshow);
        datePicker();
    }
    public void timeClickFunction(View view){
        /*Calendar c1=Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        String time=dateFormat.format(c1.getTime());
        timeshow= (TextView) findViewById(R.id.timeshow);
        timeshow.setText(time);*/
        timeshow= (TextView) findViewById(R.id.timeshow);
        timePicker();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_edit_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
