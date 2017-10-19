package sv.edu.udb.taller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        double latitude= 0.00;
        double longitude = 0.00;
        GPSTracker gps= new GPSTracker(MainActivity.this);
         if(gps.canGetLocation()){
              latitude = gps.getLatitude();
              longitude = gps.getLongitude();
         }else{
             gps.showSettingsAlert();
         }

        myWebView.loadUrl("https://www.google.com.sv/maps/" + "@"+latitude+","+longitude+",18.36z");


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alcaldia:
                myWebView.loadUrl("https://www.google.com.sv/maps/@13.7025725,-89.1889297,20z");
                return true;
            case R.id.parque:
                myWebView.loadUrl("https://www.google.com.sv/maps/@13.6896634,-89.2519132,17z");
                return true;
            case R.id.biblioteca:
                myWebView.loadUrl("https://www.google.com.sv/maps/@13.6952169,-89.2044872,17z");
                return true;
            case R.id.universidad:
                myWebView.loadUrl("https://www.google.com.sv/maps/@13.7159087,-89.1558874,17z");
                return true;
            case R.id.turistico:
                myWebView.loadUrl("https://www.google.com.sv/maps/@13.800647,-89.3915324,17z");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
