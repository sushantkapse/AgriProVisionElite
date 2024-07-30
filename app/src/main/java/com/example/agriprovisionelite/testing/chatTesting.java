package com.example.agriprovisionelite.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.agriprovisionelite.R;

public class chatTesting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_testing);

        WebView webView=findViewById(R.id.webView12);
       WebSettings webSettings= webView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/index.html");


    }
}