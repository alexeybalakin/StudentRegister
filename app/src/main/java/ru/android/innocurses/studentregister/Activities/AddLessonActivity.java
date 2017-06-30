package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import ru.android.innocurses.studentregister.R;

public class AddLessonActivity extends Activity {
    private EditText etDate;
    private EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        etDate =(EditText) findViewById(R.id.etDate);
        etTime = (EditText)findViewById(R.id.etTime);

    }

    public void setDate(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                etDate.setText(i2 +"."+i1+"."+i);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,dateSetListener,2017, 6, 30);
        datePickerDialog.show();
    }

    public void setTime(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                etTime.setText(i + ":" + i1);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener,12,0, false);
        timePickerDialog.show();
    }

    public void submit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы хотите добавить новый урок?");
        builder.setTitle("Добавление урока");
        builder.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });
        builder.setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
