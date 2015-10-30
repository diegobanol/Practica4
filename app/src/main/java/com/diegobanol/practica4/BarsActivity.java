package com.diegobanol.practica4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BarsActivity extends AppCompatActivity {

    ListView lstNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        String[] menu = new String[] {getString(R.string.bar1),getString(R.string.bar2), getString(R.string.bar3), getString(R.string.bar4)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.custom_list_item, menu);

        lstNombres = (ListView) findViewById(R.id.lst);
        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opSelec = (String) parent.getItemAtPosition(position);

                if(opSelec.equals(getString(R.string.bar1))){
                    Intent bar1_intent = new Intent(BarsActivity.this, Bar1Activity.class);
                    startActivity(bar1_intent);
                }else if(opSelec.equals(getString(R.string.bar2))){
                    Intent bar2_intent = new Intent(BarsActivity.this, Bar2Activity.class);
                    startActivity(bar2_intent);
                }if(opSelec.equals(getString(R.string.bar3))){
                    Intent bar3_intent = new Intent(BarsActivity.this, Bar3Activity.class);
                    startActivity(bar3_intent);
                }else if(opSelec.equals(getString(R.string.bar4))){
                    Intent bar4_intent = new Intent(BarsActivity.this, Bar4Activity.class);
                    startActivity(bar4_intent);
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
