package com.MisbahatuAhmad;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.speech.tts.TextToSpeech;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private MainBinding binding;
	
	private TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = MainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		tts = new TextToSpeech(getApplicationContext(), null);
		
		binding.webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		android.webkit.WebView myWebView = (android.webkit.WebView) findViewById(R.id.webview1);
		
		// বেসিক সেটিংস
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setDomStorageEnabled(true);
		myWebView.getSettings().setAllowFileAccess(true);
		
		// HTML এর সাথে Android-এর Text-to-Speech কানেকশন (Bridge)
		myWebView.addJavascriptInterface(new Object() {
			@android.webkit.JavascriptInterface
			public void speak(String text) {
				tts.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH, null, null);
			}
		}, "Android");
		
		// ফাইল লোড করা
		myWebView.loadUrl("file:///android_asset/index.html");
		
	}
	
}