package com.diegobanol.practica4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HotelsActivity extends AppCompatActivity {

    ListView lstNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        String[] menu = new String[] {getString(R.string.hotel1),getString(R.string.hotel2), getString(R.string.hotel3), getString(R.string.hotel4)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.custom_list_item, menu);

        lstNombres = (ListView) findViewById(R.id.lst);
        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opSelec = (String)parent.getItemAtPosition(position);

                if(opSelec.equals(getString(R.string.hotel1))){
                    Intent hotel1_intent = new Intent(HotelsActivity.this, Hotel1Activity.class);
                    startActivity(hotel1_intent);
                }else if(opSelec.equals(getString(R.string.hotel2))){
                    Intent hotel2_intent = new Intent(HotelsActivity.this, Hotel2Activity.class);
                    startActivity(hotel2_intent);
                }else if(opSelec.equals(getString(R.string.hotel3))){
                    Intent hotel3_intent = new Intent(HotelsActivity.this, Hotel3Activity.class);
                    startActivity(hotel3_intent);
                }else if(opSelec.equals(getString(R.string.hotel4))) {
                    Intent hotel4_intent = new Intent(HotelsActivity.this, Hotel4Activity.class);
                    startActivity(hotel4_intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast toast= Toast.makeText(getApplicationContext(), getString(R.string.about), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
