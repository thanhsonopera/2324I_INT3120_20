package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        //f1
//        myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        myWebView.loadUrl("https://www.google.com.vn/?hl=vi");

        //f2
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
//        myWebView.loadUrl("file:///android_asset/test.html");]
        //f3

        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl("https://www.google.com.vn/?hl=vi");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("https://www.google.com.vn/?hl=vi")) {
                return false;//Tải
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true; //Ngăn tiếp tục tải
        }
//        @SuppressWarnings("deprecation")
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            final Uri uri = Uri.parse(url);
//            return true;
//        }

//        @TargetApi(Build.VERSION_CODES.N)
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            final Uri uri = request.getUrl();
//            return true;
//        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
//            Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}