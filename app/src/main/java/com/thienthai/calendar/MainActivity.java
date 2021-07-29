package com.thienthai.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class MainActivity extends AppCompatActivity {
        TextView tvCalendar;
        EditText pickerCalendar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tvCalendar = (TextView) findViewById(R.id.tvCalendar);
            pickerCalendar = (EditText) findViewById(R.id.edtCalendarPicker);

    //su dung thu viện java
            Calendar calendar = Calendar.getInstance();

            tvCalendar.append(calendar.getTime() + "\n");
            tvCalendar.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/y");
            tvCalendar.append(simpleDateFormat.format(calendar.getTime()) + "\n");

            SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("H:m:s a");

            tvCalendar.append(simpleDateFormatHour.format(calendar.getTime()) + "\n");

            pickerCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PickerCalendar();
                }
            });
        }
        private  void PickerCalendar(){
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DATE);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(year, month, dayOfMonth );
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    pickerCalendar.setText(simpleDateFormat.format(calendar.getTime()));
                }
            },year ,month ,day );
            datePickerDialog.show();
        }
    }