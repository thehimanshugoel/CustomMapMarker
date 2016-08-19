# CustomMapMarker
	
Customize Google Maps Marker of your own choice by passing the marker layout

![alt tag](https://s3.postimg.org/8ah1ksj6b/map_Image.png)

##Download
Grab via gradle:

```compile 'compile 'com.himanshugoel.custommarker:custommarker:0.1.0''```

or Maven:
```<dependency>
  <groupId>com.himanshugoel.custommarker</groupId>
  <artifactId>custommarker</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
 ```


##How To Use
Call CustomMarker class method drawMarker and pass layout of the custom marker layout and inteface MarkerView()
``` LatLng gip = new LatLng(28.56795808189261, 77.32470631599426);
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(CustomMarker.drawMarker(R.layout.marker_view, new MarkerView() {
            @Override
            public void getMarkerView(View view) {
              
            }

            @Override
            public Context getContext() {
                return getApplicationContext();
            }
        })));```
			


#Example

```
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng gip = new LatLng(28.56795808189261, 77.32470631599426);
        MarkerOptions markerOptions = new MarkerOptions();

        //Call CustomMarker class and call drawMarker method and in method parameter pass marker layout and interface MarkerView
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(CustomMarker.drawMarker(R.layout.marker_view, new MarkerView() {
            @Override
            public void getMarkerView(View view) {
                ImageView imgStar = (ImageView) view.findViewById(R.id.imgMarker);
                TextView txtMarkerText = (TextView) view.findViewById(R.id.txtMarkerText);
                txtMarkerText.setText("24 min away");
                txtMarkerText.setTextColor(Color.BLACK);
            }

            @Override
            public Context getContext() {
                return getApplicationContext();
            }
        })));
        markerOptions.position(gip);
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gip));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }
}

```






