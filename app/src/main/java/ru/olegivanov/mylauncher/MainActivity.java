package ru.olegivanov.mylauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* public static final String YOUTUBE_PACKAGE_NAME = "com.google.android.youtube";
    public static final String YOUTUBE_CLASS_NAME = "com.google.android.youtube.WatchActivity";*/

    public void onClick(View view) { /*
        Button settings = (Button) findViewById(R.id.button1);
        Intent intent = new Intent("com.android.browser");
        startActivity(intent); */
        Intent intent;
        switch (view.getId()) {
            case R.id.settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.opera:/*
                String packageName = "com.opera.browser.classic";
                String className = "com.opera.browser.classic.Browser";
                Intent internetIntent = new Intent(Intent.ACTION_VIEW);
                internetIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                internetIntent.setClassName(packageName, className);
                startActivity(internetIntent);*//*
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.ru"));
                startActivity(intent);*/
                intent = getPackageManager().getLaunchIntentForPackage("com.opera.browser.classic");
                startActivity(intent);

                break;
            case R.id.youtube:
               /* URL url=*/
                intent = new Intent();/*
                intent.setComponent(new ComponentName("com.google.android.youtube", "com.google.android.youtube.WatchActivity"));
                startActivity(intent);*//*
                intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse("http://youtube.com"));
                intent.setClassName(YOUTUBE_PACKAGE_NAME, YOUTUBE_CLASS_NAME);
                startActivity(intent);*/
                intent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(intent);
                break;
            case R.id.dropbox:
                intent = getPackageManager().getLaunchIntentForPackage("com.dropbox.android");
                startActivity(intent);
                break;
            case R.id.coolreader:
                intent = getPackageManager().getLaunchIntentForPackage("org.coolreader");
                startActivity(intent);
                break;
        }
    }



}
