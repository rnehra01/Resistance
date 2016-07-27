package com.example.pardeep.resistance;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.database.Cursor;
import com.example.pardeep.resistance.add_info;

public class warrior_LIST extends AppCompatActivity {
    String warrior_name;
    String warrior_alliance;
    String warrior_species;
    String warrior_planet;
    String warrior_date;
    String warrior_gender;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior__list);

        int count=0;
        Warrior_db DOP=new Warrior_db(ctx);
        final Cursor CR=DOP.getInformation(DOP);




            CR.moveToFirst();
            do {
                count++;
            }while(CR.moveToNext());


        try {
        String [] warLIST=new String[count];
        String [] warALLYlist=new String[count];
        String [] warSEXlist=new String[count];
        int i=0;
        CR.moveToFirst();
        do {
            warLIST[i]=CR.getString(0);
            warALLYlist[i]=CR.getString(1);
            warSEXlist[i]=CR.getString(5);
            i++;
        }while(CR.moveToNext());


        ListAdapter adapter=new custom_warriorAdapter(this,warLIST,warALLYlist,warSEXlist);
        ListView warrior_LIST=(ListView)findViewById(R.id.warrior_LIST);
        warrior_LIST.setAdapter(adapter);

        warrior_LIST.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        warrior_name=String.valueOf(parent.getItemAtPosition(position));
                        CR.moveToFirst();
                        boolean check_status=false;
                        do {
                            if ((warrior_name.toUpperCase()).equals(CR.getString(0))){
                                check_status=true;
                                warrior_alliance=CR.getString(1);
                                warrior_species=CR.getString(2);
                                warrior_planet=CR.getString(3);
                                warrior_date=CR.getString(4);
                                warrior_gender=CR.getString(5);
                            }

                        }while (CR.moveToNext());

                        if (check_status){
                            Show_detailsClicked();
                        }
                    }
                }
        );

    }catch (CursorIndexOutOfBoundsException e){Toast.makeText(getBaseContext(),"Please add a warrior FIRST" ,Toast.LENGTH_LONG).show();}

    }





    public void Show_detailsClicked(){
        Intent intent=new Intent(this,war_infoDisplay.class);
        intent.putExtra("name", warrior_name);
        intent.putExtra("alliance", warrior_alliance);
        intent.putExtra("species",warrior_species);
        intent.putExtra("planet",warrior_planet);
        intent.putExtra("date", warrior_date);
        intent.putExtra("gender",warrior_gender);
        Bundle extras=new Bundle();
        extras.putString("status","Hello Sir!");
        intent.putExtras(extras);
        startActivity(intent);
    }







}
