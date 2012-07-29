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
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.sql.Date;
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
	
	
	
	private ListView lvExample;
    private String[] exampleStrings = {"Element1", "Element2", "El..3"};
    private ArrayAdapter<String> aa;
    
    /** Called when the activity is first created. */
   
      


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
        
        switch (item.getItemId()) {
        case R.id.item01:
            Toast.makeText(getApplicationContext(), 
                    "Opcja item01 na elemencie: " + exampleStrings[info.position], 
                    Toast.LENGTH_LONG).show();
            break;
            
        case R.id.item02:
            Toast.makeText(getApplicationContext(), 
                    "Opcja item02 na elemencie: " + exampleStrings[info.position], 
                    Toast.LENGTH_LONG).show();
            break;
            
        default:
            break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_view_context_menu, menu);
        
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
        
        menu.setHeaderTitle(exampleStrings[info.position]);
        
    }
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.icon:     Toast.makeText(this, "You pressed the icon!", Toast.LENGTH_LONG).show();
	                                break;
	            case R.id.text:     Toast.makeText(this, "You pressed the text!", Toast.LENGTH_LONG).show();
	                                break;
	            case R.id.icontext: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
	                                break;
	        }
	        return true;
	    }
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  lvExample = (ListView)findViewById(R.id.lvExample);
	        aa = new ArrayAdapter<String>(getApplicationContext(), 
	                                      android.R.layout.simple_list_item_1, 
	                                      exampleStrings);
	        lvExample.setAdapter(aa);
	        
	        registerForContextMenu(lvExample);
		

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
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_menu, menu);
	    return true;
	}
	
	@Override
	protected void onStart() {
	    super.onStart();
	    
	    
	    locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0,locationListener); 

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
           
        	
        	StringBuilder X,Y;
    		lokalizacja lokalizuj = new lokalizacja();
    		
    		X=lokalizuj.zwrocX(locationManager);
    		Y=lokalizuj.zwrocY(locationManager);
    		
    		TextView dlugosc = (TextView) findViewById(R.id.dlugosc);
    		TextView szerokosc = (TextView) findViewById(R.id.szerokosc);

    		szerokosc.setText(X);
    		dlugosc.setText(Y); 
            //showAdditionalInfo(location);
           /* if (savedLocation == null)
                savedLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);*/
        }
    };
	
	
	
	
 
	

	public void sprawdz(View v) {

	/*	Button b = (Button) findViewById(R.id.button2);
		b.setEnabled(false);*/

		Timer watek_glowny;

		watek_glowny = new Timer();

		watek_glowny.schedule(new TimerTask() {
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
		//setContentView(R.layout.drugieokno);
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
		/*
	
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	
		
		String szImei = TelephonyMgr.getDeviceId();
		t1.setText(Build.MANUFACTURER);
		t2.setText(Build.MODEL);
		*/

	}

	// pozycje z GPS i WIFII
	public void podajpozycje(View v) {
		String a="Ostatni fix: ";
		Location fix;
		
		fix = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	 showLocation(); 
	 
	 a  += new Date(fix.getTime()).toGMTString() + "\n";
	 TextView t = (TextView) findViewById(R.id.fix);
		 
		t.setText(a); 
		
	    
	     
	 
	}

	// pokaz pozycje;
	private void showLocation() {


		StringBuilder X,Y;
		lokalizacja lokalizuj = new lokalizacja();
		
		X=lokalizuj.zwrocX(locationManager);
		Y=lokalizuj.zwrocY(locationManager);
		
		TextView dlugosc = (TextView) findViewById(R.id.dlugosc);
		TextView szerokosc = (TextView) findViewById(R.id.szerokosc);

		szerokosc.setText(X);
		dlugosc.setText(Y); 
		
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