package ru.olegivanov.mylauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.application:
                finish();
                break;
            case R.id.setting:
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                break;
            case R.id.screen:
                startActivity(new Intent(Settings.ACTION_DISPLAY_SETTINGS));
                break;
            case R.id.date:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.wifi:
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                break;
           /* case R.id.wifiOn:
                Switch sw = (Switch) findViewById(R.id.wifiOn);
                WifiManager wifi = (WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(sw.isChecked());*/



        }
    }

}
