package com.example.pardeep.resistance;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.DatePicker;

/**
 * Created by Pardeep on 1/15/2016.
 */
public class DateSetting implements DatePickerDialog.OnDateSetListener {
    Context context;
    public DateSetting(Context context){
        this.context=context;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


    }
}
