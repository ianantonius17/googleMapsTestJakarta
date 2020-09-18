# googleMapsTestJakarta

Perform automated activity on Google Maps application in android device using Java , Appium, and Selenium. This 
automated testing is performed using android emulator from Android Studio (Google Pixel 2 XL/ Google Pixel). The automated system is
performed with the help of Appium and Selenium to access elements in Android Application and perform task that mimic
user such as press,tap,input, pinch ,and etc. This automated system is created based on Java with IntelliJ IDEA and 
is tested using TestNG.

Important Note : This program is run for Android 10.0 (Q), different version may cause error on element. It is tested to run
on Google Pixel 2 XL or Google Pixel with Android 10.0 (Q).

Direction:
1. Open android emulator/android device.
2. Run "adb devices" on terminal (Mac)/Commandline (Windows) to check the device name.
3. Input device name in the main class under "device_name" variable
4. Run Appium server with host = '0.0.0.0' and port = 4732
5. If Appium is run under different host and server configuration can be adjusted in main class under the "url" variable
6. Run the program.

System Flow : 
Open Google Map application from android emulator
Skip Sign in request
Search location (keyword : "jakarta")
choose second option on the list
pinch and zoom found location


