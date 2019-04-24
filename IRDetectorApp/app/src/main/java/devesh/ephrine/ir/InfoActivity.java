package devesh.ephrine.ir;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.navcolor));
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Button bu =(Button)findViewById(R.id.button4);
            bu.setVisibility(View.VISIBLE);
        }
    }
    public void cam(View v){
        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.CAMERA},
                1);
            }
    public void con(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://goo.gl/forms/fpuYFy9wWubW6QK12")); //Google play store
        startActivity(intent);
    }
    public void bug(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://goo.gl/forms/Sfrtvuods5BATTUl2")); //Google play store
        startActivity(intent);
    }
    public void pro(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=devesh.ephrine.ir.pro")); //pro version
        startActivity(intent);

    }
    public void rate(View v){

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=devesh.ephrine.ir")); //pro version
            startActivity(intent);


    }
    public void don(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://goo.gl/forms/fpuYFy9wWubW6QK12")); //Google play store
        startActivity(intent);
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
                    Toast.makeText(InfoActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
