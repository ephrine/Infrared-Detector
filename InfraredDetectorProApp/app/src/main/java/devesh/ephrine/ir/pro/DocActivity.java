package devesh.ephrine.ir.pro;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

public class DocActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.navcolor));
        }

    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {

        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();

    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}