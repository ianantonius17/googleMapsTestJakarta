import java.net.MalformedURLException;

public class main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        System.out.println("hello world");
        String device_name = "emulator-5554";
        String platform_name = "android";
        String app_package = "com.google.android.apps.maps";
        String app_activity = "com.google.android.maps.MapsActivity";
        String url = "http://127.0.0.1:4723/wd/hub";

        googleMaps gmap = new googleMaps(device_name,platform_name,app_package,app_activity,url);
        gmap.run();
    }
}
