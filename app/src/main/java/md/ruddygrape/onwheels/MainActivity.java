package md.ruddygrape.onwheels;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;


public class MainActivity extends Activity {
    private GoogleMap gMap;
    private MapHelper mapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareMap();

    }

    private void prepareMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.am_map);
        gMap = mapFragment.getMap();
        mapHelper = new MapHelper(gMap);
    }
}
