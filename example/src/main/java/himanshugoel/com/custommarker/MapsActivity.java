package himanshugoel.com.custommarker;

import android.content.Context;
import android.graphics.Color;
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
