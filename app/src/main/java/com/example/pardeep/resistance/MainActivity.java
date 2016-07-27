package com.example.pardeep.resistance;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add=(Button) findViewById(R.id.add);
        add.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        start_add_info();
                    }
                }
        );


        final Button display=(Button)findViewById(R.id.display);
        display.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {


                        display();

                    }
                }
        );


    }

    public void start_add_info() {
        Intent launch_add_info=new Intent(this,add_info.class);
        startActivity(launch_add_info);
    }

    public void display(){
        Intent i=new Intent(this,warrior_LIST.class);
        startActivity(i);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
