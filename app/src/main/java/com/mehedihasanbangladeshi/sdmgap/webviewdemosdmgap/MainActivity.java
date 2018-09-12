package com.mehedihasanbangladeshi.sdmgap.webviewdemosdmgap;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView mWebView;
    String mURL;
    SwipeRefreshLayout swipeRefreshLayout;
//  m = class member variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.refresh_layout);

       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               loadURL();
           }
       });

        loadURL();




    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }




    public void loadURL(){

        mURL = "https://google.com/";
        mWebView = findViewById(R.id.webview);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().getLoadsImagesAutomatically();
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.loadUrl(mURL);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    Toast.makeText(getApplicationContext()," Not found!!!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getApplicationContext(), "loading finished!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

    // {
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
//                }
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                Toast.makeText(getApplicationContext(),"done!",Toast.LENGTH_SHORT).show();
//                }
//                }














    //    @Override
//    public void onBackPressed() {
//
//        if (mWebView.canGoBack()){
//            mWebView.goBack();
//
//        }else {
//            super.onBackPressed();
//            }
//        }
