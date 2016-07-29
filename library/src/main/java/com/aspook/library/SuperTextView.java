package com.aspook.library;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * SuperTextView
 * <p/>
 * Created by Andy on 16/7/29.
 */
public class SuperTextView extends TextView {

    public SuperTextView(Context context) {
        super(context);
    }

    public SuperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * set foreground color for the spans of text, start index must smaller than end index and start > 0 && end > 0
     *
     * @param color the foreground color
     * @param start the start index
     * @param end   the end index
     */
    public void setForegroundColorSpan(int color, int start, int end) {
        if (check(start, end)) {
            setSpannableString(SpanFactory.getForegroundColorSpan(color), start, end);
        }
    }

    /**
     * set background color for the spans of text, start index must smaller than end index and start > 0 && end > 0
     *
     * @param color the background color
     * @param start the start index
     * @param end   the end index
     */
    public void setBackgroundColorSpan(int color, int start, int end) {
        if (check(start, end)) {
            setSpannableString(SpanFactory.getBackgroundColorSpan(color), start, end);
        }
    }

    /**
     * set underline for the spans of text
     *
     * @param start the start index
     * @param end   the end index
     */
    public void setUnderlineSpan(int start, int end) {
        if (check(start, end)) {
            setSpannableString(SpanFactory.getUnderlineSpan(), start, end);
        }
    }

    /**
     * set strikethrough for the spans of text
     *
     * @param start the start index
     * @param end   the end index
     */
    public void setStrikethroughSpan(int start, int end) {
        if (check(start, end)) {
            setSpannableString(SpanFactory.getStrikethroughSpan(), start, end);
        }
    }

    /**
     * set hyperlink for the spans of text
     *
     * @param url   the url, eg:"http://aspook.com","tel:18888888888","mailto:yourswee@google.com" and so on
     * @param start the start index
     * @param end   the end index
     */
    public void setURLSpan(String url, int start, int end) {
        if (isValid(url)) {
            if (check(start, end)) {
                setSpannableString(SpanFactory.getURLSpan(url), start, end);
                // Allow hyperlink to respond to click events
                this.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    /**
     * set style for the spans of text, like BOLD, ITALIC
     *
     * @param style eg:Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC, Typeface.NORMAL and so on
     * @param start the start index
     * @param end   the end index
     */
    public void setStyleSpan(int style, int start, int end) {
        if (check(start, end)) {
            setSpannableString(SpanFactory.getStyleSpan(style), start, end);
        }
    }

    /**
     * Changes the typeface family of the the spans of text
     *
     * @param family The font family for this typeface
     * @param start  the start index
     * @param end    the end index
     */
    public void setTypefaceSpan(String family, int start, int end) {
        if (isValid(family)) {
            if (check(start, end)) {
                setSpannableString(SpanFactory.getTypefaceSpan(family), start, end);
            }
        }
    }

    /**
     * set the spans of text can be selected.  If clicked, the onClick method will be called.
     *
     * @param span  ClickableSpan instance
     * @param start the start index
     * @param end   the end index
     */
    public void setClickableSpan(ClickableSpan span, int start, int end) {
        if (span != null) {
            if (check(start, end)) {
                setSpannableString(span, start, end);
                // Allow the selected text to respond to click events
                this.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    /**
     * Set the absolute text size for the spans of text to physical pixels,or to device-independent pixels if isDip is true
     *
     * @param size  the text size
     * @param isDip if it is dip
     * @param start the start index
     * @param end   the end index
     */
    public void setAbsoluteSizeSpan(int size, boolean isDip, int start, int end) {
        if (size > 0) {
            if (check(start, end)) {
                setSpannableString(SpanFactory.getAbsoluteSizeSpan(size, isDip), start, end);
            }
        }
    }

    /**
     * set the relative size for the spans of text
     *
     * @param scale the scale to default value
     * @param start the start index
     * @param end   the end index
     */
    public void setRelativeSizeSpan(float scale, int start, int end) {
        if (scale > 0) {
            if (check(start, end)) {
                setSpannableString(SpanFactory.getRelativeSizeSpan(scale), start, end);
            }
        }
    }

    /**
     * append image after the text, the image's width and height are the same as the text's size
     *
     * @param context the Context
     * @param resId   the image resource id
     */
    public void appendImageSpan(Context context, int resId) {
        if (resId > 0) {
            SpannableString spannableStr = new SpannableString(" ");
            Drawable drawable = context.getResources().getDrawable(resId);

            if (drawable != null) {
                drawable.setBounds(0, 0, (int) this.getTextSize(), (int) this.getTextSize());
                ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                spannableStr.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                this.append(spannableStr);
            }

        }
    }

    /**
     * set SpannableString for the textview
     *
     * @param span  specific span
     * @param start the start index
     * @param end   the end index
     */
    private void setSpannableString(Object span, int start, int end) {
        SpannableString spannableStr = new SpannableString(this.getText());
        spannableStr.setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        this.setText(spannableStr);
    }

    /**
     * check if the start index and the end index are valid
     *
     * @param start the start index
     * @param end   the end index
     * @return
     */
    private boolean check(int start, int end) {
        CharSequence text = this.getText();
        if (text.length() <= 0) {
            return false;
        }

        if (start > end) {
            return false;
        }

        if (start < 0 || end < 0) {
            return false;
        }

        if (end > text.length()) {
            return false;
        }

        return true;
    }

    /**
     * check whether the string is valid or not
     *
     * @param string
     * @return
     */
    private boolean isValid(String string) {
        if ((string == null) || ("".equals(string)) || (" ".equals(string))
                || ("null".equals(string)) || ("\n".equals(string))) {
            return false;
        } else {
            return true;
        }
    }

}
