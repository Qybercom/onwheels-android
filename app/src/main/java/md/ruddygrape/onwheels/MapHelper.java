package md.ruddygrape.onwheels;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapHelper {
    private GoogleMap gMap;
    public int lineColor;

    public MapHelper(GoogleMap gMap) {
        this.gMap = gMap;
        lineColor = Color.MAGENTA;
    }

    public void drawPathBetweenPoints(LatLng startPoint, LatLng endPoint) {
        gMap.addPolyline(new PolylineOptions()
                .add(startPoint, endPoint)
                .width(3)
                .color(lineColor)
                .geodesic(true));
    }
}
