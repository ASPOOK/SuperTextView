package com.aspook.library;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

/**
 * SpanFactory
 * <p/>
 * Created by Andy on 16/7/29.
 */
public class SpanFactory {

    private SpanFactory() {

    }

    public static Object getForegroundColorSpan(int color) {
        ForegroundColorSpan span = new ForegroundColorSpan(color);

        return span;
    }

    public static Object getBackgroundColorSpan(int color) {
        BackgroundColorSpan span = new BackgroundColorSpan(color);

        return span;
    }

    public static Object getUnderlineSpan() {
        UnderlineSpan span = new UnderlineSpan();

        return span;
    }

    public static Object getStrikethroughSpan() {
        StrikethroughSpan span = new StrikethroughSpan();

        return span;
    }

    public static Object getURLSpan(String url) {
        URLSpan span = new URLSpan(url);

        return span;
    }

    public static Object getStyleSpan(int style) {
        StyleSpan span = new StyleSpan(style);

        return span;
    }

    public static Object getTypefaceSpan(String family) {
        TypefaceSpan span = new TypefaceSpan(family);

        return span;
    }

    public static Object getAbsoluteSizeSpan(int size, boolean isDip) {
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(size, isDip);

        return span;
    }

    public static Object getRelativeSizeSpan(float scale) {
        RelativeSizeSpan span = new RelativeSizeSpan(scale);

        return span;
    }

}
