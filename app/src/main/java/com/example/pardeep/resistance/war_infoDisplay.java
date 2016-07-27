package com.example.pardeep.resistance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;



public class war_infoDisplay extends Activity {
    TextView warNameDISPLAY;
    TextView warAllianceDISPLAY;
    TextView warSpeciesDISPLAY;
    TextView warPlanetDISPLAY;
    TextView warDateDISPLAY;
    TextView warGenderDISPLAY;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_info_display);
        RelativeLayout war_info_display=(RelativeLayout)findViewById(R.id.war_info_display);

        Intent intent=getIntent();
        String nameDisplay=intent.getStringExtra("name").toUpperCase();
        warNameDISPLAY=(TextView)findViewById(R.id.warNameDISPLAY);
        warNameDISPLAY.setText(nameDisplay);
        warAllianceDISPLAY=(TextView)findViewById(R.id.warAllianceDISPLAY);
        warAllianceDISPLAY.setText(intent.getStringExtra("alliance"));
        textView3=(TextView)findViewById(R.id.textView3);

        if (warAllianceDISPLAY.getText().toString().equals("LIGHT")){
            war_info_display.setBackgroundResource(R.drawable.light);
            textView3.setText("Survives");
        }

        else {
            war_info_display.setBackgroundResource(R.drawable.dark);
            textView3.setText("Rules");

        }


        warSpeciesDISPLAY=(TextView)findViewById(R.id.warSpeciesDISPLAY);
        warSpeciesDISPLAY.setText(intent.getStringExtra("species"));
        warPlanetDISPLAY=(TextView)findViewById(R.id.warPlanetDISPLAY);
        warPlanetDISPLAY.setText(intent.getStringExtra("planet"));
        warDateDISPLAY=(TextView)findViewById(R.id.warDateDISPLAY);
        warDateDISPLAY.setText(intent.getStringExtra("date"));
        warGenderDISPLAY=(TextView)findViewById(R.id.warGenderDISPLAY);
        warGenderDISPLAY.setText(intent.getStringExtra("gender"));
        Bundle bundle=intent.getExtras();
        String status=bundle.getString("status");
        Toast toast=Toast.makeText(this,status,Toast.LENGTH_SHORT);
        toast.show();

    }


}
