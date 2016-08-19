package himanshugoel.com.custommarker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        MarkerOptions markerOptions = new MarkerOptions();

        //Call CustomMarker class and call drawMarker method and in method parameter pass marker layout and interface MarkerView
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(CustomMarker.drawMarker(R.layout.marker_view, new MarkerView() {
            @Override
            public void getMarkerView(View view) {
                ImageView imgStar = (ImageView) view.findViewById(R.id.imgMarker);
                TextView txtMarkerText = (TextView) view.findViewById(R.id.txtMarkerText);
                txtMarkerText.setText("Sydney");
            }

            @Override
            public Context getContext() {
                return getApplicationContext();
            }
        })));
        markerOptions.position(sydney);
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
