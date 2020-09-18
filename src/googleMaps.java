import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import sun.security.x509.DistributionPointName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class googleMaps {

    DesiredCapabilities dc;
    AndroidDriver<AndroidElement> ad;
    private TimeUnit time;
    Dimension windowSize ;
    int height ;
    int width ;
    public googleMaps(String device_name, String platform_name, String app_package, String app_activity, String url) throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,platform_name);
        dc.setCapability("appPackage", app_package);
        dc.setCapability("appActivity",app_activity);

        ad = new AndroidDriver<AndroidElement>(new URL(url),dc );
        time = TimeUnit.SECONDS;
        windowSize = ad.manage().window().getSize();
        height = windowSize.height;
        width = windowSize.width;
    }

    //perform search based on keyword
    public void search(String keyword) throws InterruptedException {
        double x_idx = 0.5;
        double y_idx = 0.08;
        PointOption searchInput= PointOption.point((int)(width * x_idx) , (int) (height * y_idx));
        time.sleep(3);
        TouchAction el1 = new TouchAction(ad).tap(searchInput);
        el1.perform();
        time.sleep(3);

        MobileElement el2 = (MobileElement) ad.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text");
        el2.click();
        time.sleep(3);

        el2.sendKeys(keyword);
        time.sleep(2);

        MobileElement el3 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]");
        String secondOnList = el3.getText();
        el3.click();

        String[] location = secondOnList.split(" ");
        Assert.assertEquals(location[0].toLowerCase(),"jakarta");

    }

    //skip on sign-in request page
    public void skipSignIn(){

        double x_idx = 0.88;
        double y_idx = 0.066;
        PointOption skipLocation= PointOption.point((int)(width * x_idx) , (int) (height * y_idx));
        (new TouchAction(ad)).tap(skipLocation).perform();

    }

    //pinch and zoom on map
    public void pinchAndZoom() throws InterruptedException {

        PointOption el1_start = PointOption.point(596, 943);
        PointOption el1_end = PointOption.point(596, 993);
        PointOption el2_start = PointOption.point(596, 923);
        PointOption el2_end = PointOption.point(596, 873);

        TouchAction finger1 = new TouchAction(ad);
        TouchAction finger2 = new TouchAction(ad);
        MultiTouchAction multiTouch = new MultiTouchAction(ad);
        finger1.press(el1_start).moveTo(el1_end);
        finger2.press(el2_start).moveTo(el2_end);
        multiTouch.add(finger1).add(finger2);
        multiTouch.perform();
        time.sleep(3);

    }

    public void run() throws InterruptedException {

        skipSignIn();
        time.sleep(3);
        search("jakarta");
        time.sleep(3);
        pinchAndZoom();
    }

}
