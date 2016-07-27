package com.example.pardeep.resistance;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Calendar;

public class add_info extends Activity{

    private EditText WarriorName;
    Warrior_db dbHandler;
    Context ctx=this;
    String ALLIANCEstatus,Speciesstatus,Planetstatus,Datestatus,Genderstatus;
    Spinner WarriorSpecies;
    ArrayAdapter<CharSequence> adapter;
    Spinner Lastplanet;
    ArrayAdapter<CharSequence> adapter2;
    Spinner Gender;
    ArrayAdapter<CharSequence> adapter3;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    boolean checked;
    int date_check=0;
    public static  int check=0;

    public void radiobuttonSTATUS(View view){

        checked=((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.black_alliance:
                if (checked){
                    ALLIANCEstatus="DARK";
                }
                break;
            case R.id.white_alliance:
                if (checked){
                    ALLIANCEstatus="LIGHT";
                }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_info);




        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        WarriorName=(EditText)findViewById(R.id.WarriorName);
        final Button save_info=(Button)findViewById(R.id.save_info);
        save_info.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String warrior_name = WarriorName.getText().toString();
                        if (warrior_name.equals("")||warrior_name.trim().equals("")){
                           Toast.makeText(getBaseContext(),"Please enter Warrior name",Toast.LENGTH_SHORT).show();
                        }

                        else if (!checked){
                            Toast.makeText(getBaseContext(),"Please select Alliance",Toast.LENGTH_SHORT).show();
                        }

                        else if (Speciesstatus.equals("Select Species of Warrior")){
                            Toast.makeText(getBaseContext(),"Please select Species of Warrior",Toast.LENGTH_SHORT).show();
                        }

                        else if (Planetstatus.equals("Select last Planet")){
                            Toast.makeText(getBaseContext(),"Please select Planet where warrior was LAST spotted",Toast.LENGTH_SHORT).show();
                        }



                        else if (Genderstatus.equals("Select Gender of Warrior")){
                            Toast.makeText(getBaseContext(),"Please select Gender of Warrior",Toast.LENGTH_SHORT).show();
                        }

                        else if (date_check==0){
                            Toast.makeText(getBaseContext(),"Please select suitable date",Toast.LENGTH_SHORT).show();
                        }

                        else{
                        Warrior_db DB = new Warrior_db(ctx);
                        DB.addWarrior(DB, warrior_name.toUpperCase(), ALLIANCEstatus, Speciesstatus,Planetstatus,Datestatus,Genderstatus);
                        Toast.makeText(getBaseContext(), "Warrior Saved", Toast.LENGTH_SHORT).show();
                            check=1;
                        finish();}
                    }

                }
        );




        WarriorSpecies=(Spinner)findViewById(R.id.Warriorspecies);
        adapter=ArrayAdapter.createFromResource(this, R.array.warriorSpecies, android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        WarriorSpecies.setAdapter(adapter);
        WarriorSpecies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Speciesstatus = parent.getItemAtPosition(position) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Lastplanet=(Spinner)findViewById(R.id.Lastplanet);
        adapter2=ArrayAdapter.createFromResource(this,R.array.lastplanet,android.R.layout.simple_dropdown_item_1line);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Lastplanet.setAdapter(adapter2);
        Lastplanet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planetstatus = parent.getItemAtPosition(position) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Gender=(Spinner)findViewById(R.id.Gender);
        adapter3=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_dropdown_item_1line);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Gender.setAdapter(adapter3);
        Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Genderstatus = parent.getItemAtPosition(position) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }





    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        Datestatus=dateView.getText().toString();
        date_check=1;
    }




}






