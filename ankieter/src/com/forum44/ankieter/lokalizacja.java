package com.forum44.ankieter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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


public class lokalizacja   {


	
  public void zapisz_pozycje(LocationManager locationManager) {	
	 
	  HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"http://twojebiuro.pl/zapisz_pozycje.php");

		try {
			String z = "";
			
			StringBuilder X,Y;
			String x1,y1,x_wifi,y_wifi;
			X=zwrocX_gps(locationManager);
			Y=zwrocY_gps(locationManager);
			x1=X.toString();
			y1=Y.toString();
			
			X=zwrocX_wifi(locationManager);
			Y=zwrocY_wifi(locationManager);
			x_wifi=X.toString();
			y_wifi=Y.toString();
		 
			

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
					6);
			nameValuePairs.add(new BasicNameValuePair("id", z));
			nameValuePairs.add(new BasicNameValuePair("imei", "imei"));
			
			
			
			nameValuePairs.add(new BasicNameValuePair("dlug_gps",x1));
			nameValuePairs.add(new BasicNameValuePair("szer_gps",y1));
			nameValuePairs.add(new BasicNameValuePair("dlug_wifi",x_wifi));
			nameValuePairs.add(new BasicNameValuePair("szer_wifi",y_wifi));
			
			
			httppost.setEntity(new UrlEncodedFormEntity(
					nameValuePairs));
		
			
			httpclient.execute(httppost);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	 
	
  }
  
  
  
  public void zapisz_pozycje_Ankiety(LocationManager locationManager) {	
		 
	  HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"http://twojebiuro.pl/zapisz_pozycje_ankieta.php");

		try {
			String z = "";
			
			StringBuilder X,Y;
			String x1,y1,x_wifi,y_wifi;
			X=zwrocX_gps(locationManager);
			Y=zwrocY_gps(locationManager);
			x1=X.toString();
			y1=Y.toString();
			
			X=zwrocX_wifi(locationManager);
			Y=zwrocY_wifi(locationManager);
			x_wifi=X.toString();
			y_wifi=Y.toString();
		 
			

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
					6);
			nameValuePairs.add(new BasicNameValuePair("id", z));
			nameValuePairs.add(new BasicNameValuePair("id_ankiety", "idankiety"));
			nameValuePairs.add(new BasicNameValuePair("imei", "imei"));
			
			
			
			nameValuePairs.add(new BasicNameValuePair("dlug_gps",x1));
			nameValuePairs.add(new BasicNameValuePair("szer_gps",y1));
			nameValuePairs.add(new BasicNameValuePair("dlug_wifi",x_wifi));
			nameValuePairs.add(new BasicNameValuePair("szer_wifi",y_wifi));
			
			
			httppost.setEntity(new UrlEncodedFormEntity(
					nameValuePairs));
		
			
			httpclient.execute(httppost);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	 
	
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	
  public StringBuilder zwrocX_gps(LocationManager locationManager) {
	  
	  StringBuilder latitudeStr = new StringBuilder("\n");
	  Location location = locationManager.getLastKnownLocation("gps");
	  if (location != null) {
		  
		  
		  latitudeStr.append(location.getLatitude());
		  
		  
		  
	  }
	  
	  return latitudeStr;
	  
  }
  
  public StringBuilder zwrocY_gps(LocationManager locationManager) {
	  StringBuilder dlugosc = new StringBuilder("\n");
	  Location location = locationManager.getLastKnownLocation("gps");
	  if (location != null) {
		  
		  dlugosc.append(location.getLongitude());
		  
		  
	  }
	  
	  return dlugosc;
	  
  }
	public StringBuilder zwrocX_wifi(LocationManager locationManager) {
		
		StringBuilder latitudeStr = new StringBuilder("\n");
		Location location = locationManager.getLastKnownLocation("network");
		if (location != null) {
			
			
			latitudeStr.append(location.getLatitude());
			
		
		
		}
		
		return latitudeStr;

	}

	public StringBuilder zwrocY_wifi(LocationManager locationManager) {
		StringBuilder dlugosc = new StringBuilder("\n");
		Location location = locationManager.getLastKnownLocation("network");
		if (location != null) {
			
			dlugosc.append(location.getLongitude());
				
		
		}
		
		return dlugosc;

	}

	
	
	
	/*private void getLocationManager() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}*/
  
  
  
	 
}
