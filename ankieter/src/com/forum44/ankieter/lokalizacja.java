package com.forum44.ankieter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class lokalizacja extends MainActivity  {

	 LocationManager myManager;
	   
	    private Location savedLocation = null;
	    
	    private LocationManager locationManager;
	    Location location; 
	
	
	    public int polaczenia(Context context) {
			ConnectivityManager connManager = null;
			String networkService = Context.CONNECTIVITY_SERVICE;
			int wynik=0;

			/*String provider = Settings.Secure.getString(getContentResolver(),
					Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

			if (!provider.contains("gps")) { // if gps is disabled
				final Intent poke = new Intent();
				poke.setClassName("com.android.settings",
						"com.android.settings.widget.SettingsAppWidgetProvider");
				poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
				poke.setData(Uri.parse("3"));
				sendBroadcast(poke);
			}*/

			connManager = (ConnectivityManager) getSystemService(networkService);

			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected())
			{
				wynik = 1;
				
			}
			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected())
			{
				wynik = 2;
				
			}
				
			
			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
					.isConnected()
					|| connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
							.isConnected()) {

				

			} else {
				wynik = 0;
			}
			
			
			
			return wynik;

		}
	
}
