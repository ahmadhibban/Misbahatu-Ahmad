// Generated file. Do not modify.
package com.MisbahatuAhmad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

public final class MainBinding {
    public final LinearLayout rootView;
    public final WebView webview1;

    private MainBinding(LinearLayout rootView, WebView webview1) {
        this.rootView = rootView;
        this.webview1 = webview1;
    }

    public LinearLayout getRoot() {
        return rootView;
    }

    public static MainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.main, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static MainBinding bind(View view) {
        LinearLayout rootView = (LinearLayout) view;
        WebView webview1 = findChildViewById(view, R.id.webview1);

        if (webview1 == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new MainBinding(rootView, webview1);
    }

    private static <T extends View> T findChildViewById(View rootView, int id) {
         if (rootView instanceof ViewGroup) {
              ViewGroup rootViewGroup = (ViewGroup) rootView;
              for (int i = 0; i < rootViewGroup.getChildCount(); i++) {
                   T view = rootViewGroup.getChildAt(i).findViewById(id);
                   if (view != null) return view;
              }
         }
         return null;
    }
}