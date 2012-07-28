package com.forum44.ankieter;

import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;

public class dostepdointernetu {

	 LocationManager myManager;
	   
	    private Location savedLocation = null;
	    
	    private LocationManager locationManager;
	    Location location; 
	
	    //zwraca 2 dla polaczenia WIFII
		//zwraca 1 dla polaczenia GSM
		//zwraca 0 dla braku internetu
	    public int polaczenie(ConnectivityManager connManager) {
			
			/*String provider = Settings.Secure.getString(getContentResolver(),
					Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

			if (!provider.contains("gps")) { // if gps is disabled
				final Intent poke = new Intent();
				poke.setClassName("com.android.settings",
						"com.android.settings.widget.SettingsAppWidgetProvider");
				poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
				poke.setData(Uri.parse("3"));
			//	sendBroadcast(poke);
			}*/
	    	
			 
			int wynik=0;
			
			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected())
			{
				wynik = 1;
				
			}
			
			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected())
			{
				wynik = 2;
				
			}
			
			
			if (connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
					.isConnected() 	|| connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI) .isConnected()) {

				

			} else {
				wynik = 0;
			}
			
			
			
			return wynik;

		}
	
}
