package himanshugoel.com.custommarker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Himanshu on 15-08-2016.
 */
public class CustomMarker {
    //Before using that method make sure you have added google play services library
    public static Bitmap drawMarker(int layoutId, MarkerView markerView) {
        View view = LayoutInflater.from(markerView.getContext()).inflate(layoutId, null);
        markerView.getMarkerView(view);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        final Bitmap clusterBitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(clusterBitmap);
        view.draw(canvas);
        return clusterBitmap;
    }
}
