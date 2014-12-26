package ru.olegivanov.mylauncher;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.VideoView;
/*
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;*/


public class MainActivity extends Activity {
    View fragApp, fragSet;
    Button buttonApp, buttonSet, buttonClose;
    LinearLayout linLay;
    int FragNum = 1;
    boolean ActiveMenu = true;
    ColorStateList color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragApp = (View) findViewById(R.id.fragment_applications);
        fragSet = (View) findViewById(R.id.fragment_settings);
        buttonApp = (Button) findViewById(R.id.applications);
        buttonSet = (Button) findViewById(R.id.settings);
        fragApp.setVisibility(View.VISIBLE);
        fragSet.setVisibility(View.INVISIBLE);
        linLay = (LinearLayout) findViewById(R.id.linearLayout);
        buttonClose = (Button) findViewById(R.id.close);

        String viewSource ="rtsp://46.249.213.93:554/playlists/russia-today_hvga.hpl.3gp";
       /* String videoUrl = getUrlVideoRTSP(viewSource);*/
        VideoView myVideoView = (VideoView) findViewById(R.id.videoView);
        myVideoView.setVideoURI(Uri.parse(viewSource));
        myVideoView.start();

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
        int Id = view.getId();
        switch (Id) {
            case R.id.close:
                if (ActiveMenu) {
                    ActiveMenu = false;
                    fragApp.setVisibility(View.INVISIBLE);
                    fragSet.setVisibility(View.INVISIBLE);
                    linLay.setVisibility(View.INVISIBLE);
                    buttonClose.setText("Развернуть меню");
                }
                else {
                    ActiveMenu = true;
                    linLay.setVisibility(View.VISIBLE);
                    buttonClose.setText("Свернуть меню");
                }

              break;
            case R.id.applications:
                if (FragNum != 1) {
                    FragNum = 1;
                    fragApp.setVisibility(View.VISIBLE);
                    fragSet.setVisibility(View.INVISIBLE);
                    color = buttonApp.getTextColors();
                    buttonApp.setTextColor(buttonSet.getTextColors());
                    buttonSet.setTextColor(color);
                }
                break;
            case R.id.settings:
               // intent = new Intent(MainActivity.this, SettingsActivity.class);
               // startActivity(intent);
               // Button settings = (Button) findViewById(R.id.settings);
               // settings.setVisibility(View.INVISIBLE);
                if (FragNum != 2) {
                    FragNum = 2;
                    fragApp.setVisibility(View.INVISIBLE);
                    fragSet.setVisibility(View.VISIBLE);
                    color = buttonApp.getTextColors();
                    buttonApp.setTextColor(buttonSet.getTextColors());
                    buttonSet.setTextColor(color);
                }
                break;
            case R.id.opera:
            /*  String packageName = "com.opera.browser.classic";
                String className = "com.opera.browser.classic.Browser";
                Intent internetIntent = new Intent(Intent.ACTION_VIEW);
                internetIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                internetIntent.setClassName(packageName, className);
                startActivity(internetIntent);*//*
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.ru"));
                startActivity(intent); */
                intent = getPackageManager().getLaunchIntentForPackage("com.opera.browser.classic");
                startActivity(intent);
                break;
            case R.id.youtube:
             /* URL url= */
                intent = new Intent();
             /* intent.setComponent(new ComponentName("com.google.android.youtube", "com.google.android.youtube.WatchActivity"));
                startActivity(intent);*//*
                intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse("http://youtube.com"));
                intent.setClassName(YOUTUBE_PACKAGE_NAME, YOUTUBE_CLASS_NAME);
                startActivity(intent);  */
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
/*
    public static String getUrlVideoRTSP(String urlYoutube)
    {
        try
        {
            String gdy = "http://gdata.youtube.com/feeds/api/videos/";
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String id = extractYoutubeId(urlYoutube);
            URL url = new URL(gdy + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Document doc = documentBuilder.parse(connection.getInputStream());
            Element el = doc.getDocumentElement();
            NodeList list = el.getElementsByTagName("media:content");///media:content
            String cursor = urlYoutube;
            for (int i = 0; i < list.getLength(); i++)
            {
                Node node = list.item(i);
                if (node != null)
                {
                    NamedNodeMap nodeMap = node.getAttributes();
                    HashMap<String, String> maps = new HashMap<String, String>();
                    for (int j = 0; j < nodeMap.getLength(); j++)
                    {
                        Attr att = (Attr) nodeMap.item(j);
                        maps.put(att.getName(), att.getValue());
                    }
                    if (maps.containsKey("yt:format"))
                    {
                        String f = maps.get("yt:format");
                        if (maps.containsKey("url"))
                        {
                            cursor = maps.get("url");
                        }
                        if (f.equals("1"))
                            return cursor;
                    }
                }
            }
            return cursor;
        }
        catch (Exception ex)
        {
           // Log.e("Get Url Video RTSP Exception======>>", ex.toString());
        }
        return urlYoutube;

    }

    protected static String extractYoutubeId(String url) throws MalformedURLException
    {
        String id = null;
        try
        {
            String query = new URL(url).getQuery();
            if (query != null)
            {
                String[] param = query.split("&");
                for (String row : param)
                {
                    String[] param1 = row.split("=");
                    if (param1[0].equals("v"))
                    {
                        id = param1[1];
                    }
                }
            }
            else
            {
                if (url.contains("embed"))
                {
                    id = url.substring(url.lastIndexOf("/") + 1);
                }
            }
        }
        catch (Exception ex)
        {
          //  Log.e("Exception", ex.toString());
        }
        return id;
    }
*/

}
