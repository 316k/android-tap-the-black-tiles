package org.legtux.m_316k.taptheblacktiles;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebActivity extends ActionBarActivity {

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView) findViewById(R.id.webView);

        // Settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Client

        WebViewClient client = new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if(url.matches("^(https?|mailto):/?/?.*")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                    return true;
                }

                return false;
            }
        };
        webView.setWebViewClient(client);

        webView.loadUrl("file:///android_asset/tap-the-black-tiles/index.html?reload");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) &&
                !webView.getUrl().equals("file:///android_asset/tap-the-black-tiles/index.html")) {
            // Back always lead to main menu
            webView.loadUrl("file:///android_asset/tap-the-black-tiles/index.html");
            return true;
        }
        finish();
        return true;
    }
}
