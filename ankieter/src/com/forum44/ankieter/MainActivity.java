package com.forum44.ankieter;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import com.forum44.ankieter.parametry;

public class MainActivity extends Activity {

	public int a = 0;
	public int sekund = 1000 * 1; // co jaki przedzia³ czasu
	
	
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

	private Runnable doSomething = new Runnable() {
		public void run() {
			TextView t = (TextView) findViewById(R.id.cyfry);
			t.setText("" + a);
			a++;
		}
	};

	public void pokaz(View v) {
		TextView t = (TextView) findViewById(R.id.producent);
		parametry test = new parametry();
		t.setText(test.napis);
	}

	public void kliknij(View v) {
		TextView t = (TextView) findViewById(R.id.daneimei);
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String szImei = TelephonyMgr.getDeviceId();
		t.setText(szImei);

		TextView t1 = (TextView) findViewById(R.id.model);
		t1.setText(Build.MANUFACTURER);
		TextView t2 = (TextView) findViewById(R.id.producent);
		t2.setText(Build.MODEL);

	}

	public void staninternetu(View V) {
		Context context = getApplicationContext();
		int a;
		lokalizacja sesja = new lokalizacja();
		
		
	//	a = sesja.polaczenie(context);
	//	TextView t = (TextView) findViewById(R.id.internet);
	//	t.setText("" + a);

	}

	
	
	//zwraca 2 dla polaczenia WIFII
	//zwraca 1 dla polaczenia GSM
	//zwraca 0 dla braku internetu
	

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