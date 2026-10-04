package com.MisbahatuAhmad;

// Author: Ahmad Hibban
// Misbahatu Ahmad - 3D Aqua Tasbih Pro

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.*;
import android.speech.tts.TextToSpeech;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import java.io.*;
import java.text.*;
import java.util.*;
import org.json.*;

public class MainActivity extends Activity {
    
    private MainBinding binding;
    private TextToSpeech tts;
    
    private static final String ONLINE_URL = "https://ahmadhibban.github.io/Misbahatu-Ahmad/";
    private static final String OFFLINE_URL = "file:///android_asset/index.html";

    private boolean isNetworkAvailable() {
        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                return netInfo != null && netInfo.isConnected();
            }
        } catch (Exception ignored) {}
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize(savedInstanceState);
        initializeLogic();
    }
    
    private void initialize(Bundle savedInstanceState) {
        tts = new TextToSpeech(getApplicationContext(), null);
        
        binding.webview1.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if (failingUrl != null && failingUrl.startsWith("http")) {
                    view.loadUrl(OFFLINE_URL);
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (request != null && request.isForMainFrame() && request.getUrl() != null && request.getUrl().toString().startsWith("http")) {
                    view.loadUrl(OFFLINE_URL);
                }
            }
        });
        binding.webview1.setWebChromeClient(new WebChromeClient());
    }
    
    private void initializeLogic() {
        WebView myWebView = binding.webview1;
        
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setDatabaseEnabled(true);
        ws.setAllowFileAccess(true);
        ws.setAllowContentAccess(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
        
        myWebView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void speak(String text) {
                if (tts != null) {
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        }, "Android");
        
        if (isNetworkAvailable()) {
            myWebView.loadUrl(ONLINE_URL);
        } else {
            myWebView.loadUrl(OFFLINE_URL);
        }
    }
    
    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.shutdown();
        }
        if (binding != null && binding.webview1 != null) {
            binding.webview1.destroy();
        }
        super.onDestroy();
    }
}