package com.forum44.ankieter;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.forum44.ankieter.parametry;

public class MainActivity extends Activity {

	public int a = 0;
	public String f;
	public int sekund = 1000 * 1 * 10; // co jaki przedzia³ czasu
	private LocationManager locationManager;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ListView mainListView = (ListView) findViewById( R.id.mainListView );

		String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
				"Jupiter", "Saturn", "Uranus", "Neptune", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
				"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn",
				"Uranus", "Neptune" };

		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll(Arrays.asList(planets));

		// Create ArrayAdapter using the planet list.
		ArrayAdapter listAdapter = new ArrayAdapter<String>(this,
				R.layout.simplerow, planetList);

		// Add more planets. If you passed a String[] instead of a List<String>
		// into the ArrayAdapter constructor, you must not add more items.
		// Otherwise an exception will occur.
		// listAdapter.add( "Ceres" );
		// listAdapter.add( "Pluto" );
		// listAdapter.add( "Haumea" );
		// listAdapter.add( "Makemake" );
		// listAdapter.add( "Eris" );

		// a to lista
		// Set the ArrayAdapter as the ListView's adapter.
		// mainListView.setAdapter( listAdapter );
		 
	}

	@Override
	protected void onStart() {
	    super.onStart();
	    
	    
	    locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
	    locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 0, 0,locationListener); 

	}
	 
	@Override
	protected void onStop() {
		 locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
	    locationManager.removeUpdates(locationListener);
	    super.onStop();
	}
	
	
	
	private LocationListener locationListener = new LocationListener() {
        public void onStatusChanged(String provider, int status, Bundle extras) {}
 
        public void onProviderEnabled(String provider) {}
 
        public void onProviderDisabled(String provider) {}
 
        public void onLocationChanged(Location location) {
           
            //showAdditionalInfo(location);
           /* if (savedLocation == null)
                savedLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);*/
        }
    };
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void sprawdz(View v) {

		Button b = (Button) findViewById(R.id.button2);
		b.setEnabled(false);

		Timer zegarek;

		zegarek = new Timer();

		zegarek.schedule(new TimerTask() {
			@Override
			public void run() {
				timerMethod();
			}

		}, 0, sekund);

	}

	public void wroc(View v) {
		setContentView(R.layout.activity_main);
	}

	public void nastepny(View v) {
		setContentView(R.layout.drugieokno);
	}

	private void timerMethod() {
		this.runOnUiThread(doSomething);
	}

	// uruchompowtarzany watek
	private Runnable doSomething = new Runnable() {
		public void run() {

			TextView t = (TextView) findViewById(R.id.cyfry);

			t.setText("" + a);
			a++;

			
			new Thread(new Runnable() {

				public void run() {
					lokalizacja lokalizuj = new lokalizacja();
					lokalizuj.zapisz_pozycje(locationManager);
				}
			}).start();

		}

	};

	
	
	 
	
	
	
	public void pokaz(View v) {
		/*TextView t = (TextView) findViewById(R.id.producent);
		parametry test = new parametry();
		t.setText(test.napis);*/
	}

	public void kliknij(View v) {
		/*TextView t = (TextView) findViewById(R.id.daneimei);
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	
		
		String szImei = TelephonyMgr.getDeviceId();
		t.setText(szImei);

		
		t1.setText(Build.MANUFACTURER);

		t2.setText(Build.MODEL);*/

	}

	// pozycje z GPS i WIFII
	public void podajpozycje(View v) {

	/*	getLocationManager();

		showLocation();*/

	}

	// pokaz pozycje;
	private void showLocation() {
	/*	StringBuilder latitudeStr = new StringBuilder("Latitude:\n");
		StringBuilder longitudeStr = new StringBuilder("Longitude:\n");
		for (String providerStr : locationManager.getAllProviders()) {
			Location location = locationManager
					.getLastKnownLocation(providerStr);
			if (location != null) {
				latitudeStr.append(location.getLatitude());
				longitudeStr.append(location.getLongitude());
			} else {
				latitudeStr.append("null");
				longitudeStr.append("null");
			}
			latitudeStr.append(" from: " + providerStr + "\n");
			longitudeStr.append(" from: " + providerStr + "\n");
		}

		StringBuilder X,Y;
		X=zwrocX();
		Y=zwrocY();
		
		TextView dlugosc = (TextView) findViewById(R.id.dlugosc);
		TextView szerokosc = (TextView) findViewById(R.id.szerokosc);

		szerokosc.setText(X);
		dlugosc.setText(Y);*/
		
	}

	
	
	
	private void getLocationManager() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}

	public void staninternetu(View V) {
		 
		int a;
		 	 
		
		
		ConnectivityManager connManager = null;
		connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		dostepdointernetu sesja = new dostepdointernetu();
         a = sesja.polaczenie(connManager);
		

		  TextView t = (TextView) findViewById(R.id.internet);
		 t.setText("" + a);

	}

	// zwraca 2 dla polaczenia WIFII
	// zwraca 1 dla polaczenia GSM
	// zwraca 0 dla braku internetu

	/*
	 * public Arrays podaj_dane_telefonu(View v) {
	 * 
	 * 
	 * Arrays wynik=; String m_szDevIDShort = Build.BOARD+ Build.BRAND +
	 * Build.CPU_ABI + Build.DEVICE + Build.DISPLAY + Build.HOST + Build.ID+
	 * Build.MANUFACTURER+ Build.MODEL + Build.PRODUCT + Build.TAGS +
	 * Build.TYPE+ Build.USER ; //13 digits return wynik;
	 * 
	 * // TextView t = (TextView)findViewById(R.id.daneimei); //
	 * t.setText("IMEI: "+m_szDevIDShort);
	 * 
	 * 
	 * }
	 */

}