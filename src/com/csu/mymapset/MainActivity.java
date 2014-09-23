package com.csu.mymapset;


import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private MapView mapView;
	private AMap amap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);
		amap = mapView.getMap();
//		amap.setMapType(AMap.MAP_TYPE_SATELLITE);
//		amap.setTrafficEnabled(true);
		
		MarkerOptions markerOption = new MarkerOptions();
		markerOption.position(new LatLng(39.90403, 116.407525));
		markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow));
		
		Marker marker = amap.addMarker(markerOption);
		marker.setRotateAngle(30);
		
		PolylineOptions polylineOption = new PolylineOptions();
		polylineOption.add(new LatLng(39.90403, 116.407525),new LatLng(31.23333, 121.2312));
		polylineOption.color(Color.BLUE);
		polylineOption.width(10);
		amap.addPolyline(polylineOption);
		
		CircleOptions circleOption = new CircleOptions();
		circleOption.center(new LatLng(39.90403, 116.407525));
		circleOption.radius(10000);
		circleOption.fillColor(Color.RED);
		amap.addCircle(circleOption);
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mapView.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mapView.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mapView.onDestroy();
	}

}
