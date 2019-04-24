package devesh.ephrine.ir.pro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView browser = (WebView) findViewById(R.id.webView);
        browser.loadUrl("http://www.tutorialspoint.com");




    }
}
