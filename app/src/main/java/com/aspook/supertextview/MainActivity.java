package com.aspook.supertextview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.aspook.library.SuperTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSuperTextView();
    }

    public void setSuperTextView() {
        SuperTextView mSuperTextView = (SuperTextView) findViewById(R.id.tv_super);
        // 为了更好看到效果，给SuperTextView设置一个背景色
        mSuperTextView.setBackgroundColor(Color.LTGRAY);

        String text = getResources().getString(R.string.test_string);
        mSuperTextView.setText(text);

        // 为某段文本设置前景色
        mSuperTextView.setForegroundColorSpan(Color.BLUE, 24, 28);

        // 为某段文本设置背景色
        mSuperTextView.setBackgroundColorSpan(Color.RED, 38, 42);

        // 为某段文本设置超链接，还可配置超链接文本的颜色
        mSuperTextView.setURLSpan("http://aspook.com", 64, 66);
        mSuperTextView.setURLSpan("tel:18888888888", 72, 74);
        mSuperTextView.setURLSpan("mailto:yourswee@gmail.com", 80, 82);
        mSuperTextView.setURLSpan("geo:31.231365,121.492885", 88, 90);
        mSuperTextView.setURLSpan("sms:18888888888", 96, 98);
        mSuperTextView.setLinkTextColor(Color.BLUE);// 设置超链接的颜色

        // 为某段文本设置粗体效果
        mSuperTextView.setStyleSpan(Typeface.BOLD, 104, 108);

        // 为某段文本设置倾斜效果
        mSuperTextView.setStyleSpan(Typeface.ITALIC, 114, 118);

        // 为某段文本设置加粗倾斜效果
        mSuperTextView.setStyleSpan(Typeface.BOLD_ITALIC, 124, 130);

        // 为某段文本设置特殊字体
        mSuperTextView.setTypefaceSpan("sans-serif", 131, 141);

        // 为某段文本设置下划线
        mSuperTextView.setUnderlineSpan(150, 153);

        // 为某段文本设置删除线
        mSuperTextView.setStrikethroughSpan(162, 165);

        // 为某段文本设置绝对字体大小
        mSuperTextView.setAbsoluteSizeSpan(90, false, 184, 198);

        // 为某段文本设置相对字体大小
        mSuperTextView.setRelativeSizeSpan(0.5f, 218, 234);

        // 为某段文本设置点击响应
        mSuperTextView.setClickableSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "these text was clicked", Toast.LENGTH_SHORT).show();
            }
        }, 244, 250);

        // 为SuperTextView设置表情图片
        mSuperTextView.appendImageSpan(this, R.drawable.emoji_love);
        mSuperTextView.appendImageSpan(this, R.drawable.emoji_grief_a);
        mSuperTextView.appendImageSpan(this, R.drawable.emoji_kiss);
        mSuperTextView.appendImageSpan(this, R.drawable.emoji_naughty);
    }
}
