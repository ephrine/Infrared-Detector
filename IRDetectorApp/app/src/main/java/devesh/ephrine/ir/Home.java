package devesh.ephrine.ir;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;


public class Home extends Activity {
    InterstitialAd mInterstitialAd;
    private AdView mAdView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.navcolor));
        }
        MobileAds.initialize(this, getString(R.string.Admob_App_ID));
        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.adView);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId(getString(R.string.Ad_Int_ID));


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();


        String MoPubAdUnitId=getResources().getString(R.string.MOPUB_AD_UNIT_ID);
        String MoPubAdIntId=getResources().getString(R.string.MOPUB_AD_INT_ID);

        SdkConfiguration sdkConfiguration =
                new SdkConfiguration.Builder(MoPubAdUnitId).build();

        SdkConfiguration sdkConfiguration1 =
                new SdkConfiguration.Builder(MoPubAdIntId).build();


        MoPub.initializeSdk(this, sdkConfiguration, null);

       MoPub.initializeSdk(this, sdkConfiguration1, null);

// Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.CAMERA},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        // ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},1);



    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                //  .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            finish();


        } else {
            finish();
        }

    }


    public void ir(View v) {
        //Intent i = new Intent(getBaseContext(), MainActivity.class);
        Intent i = new Intent(getBaseContext(), CameraActivity.class);

        startActivity(i);
    }

    public void share(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Infrared Detector: \n \n " + "Friends!!! Check out a awesome app to Detect infrared radiations around us.  https://play.google.com/store/apps/details?id=devesh.ephrine.ir");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void about(View v) {
        Intent i = new Intent(getBaseContext(), InfoActivity.class);
        startActivity(i);
    }
    public void doc(View v) {
        Intent i = new Intent(getBaseContext(), DocActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
     //   MenuInflater inflater = getMenuInflater();
       // inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.pro:
                Intent pro = new Intent(this, InfoActivity.class);
                startActivity(pro);
                break;

            default:
                break;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(Home.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }




}
