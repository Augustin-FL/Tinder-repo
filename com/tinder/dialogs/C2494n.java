package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.tinder.R;
import com.tinder.model.Match;
import com.tinder.p030d.ac;
import com.tinder.p030d.be;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

/* renamed from: com.tinder.dialogs.n */
public class C2494n extends Dialog implements OnClickListener {
    private be f4497a;
    private boolean f4498b;

    public C2494n(@NonNull Context context, be beVar, @Nullable Match match, @Nullable View view) {
        super(context, 16973935);
        this.f4497a = beVar;
        requestWindowFeature(1);
        setContentView(R.layout.view_report_block);
        if (view == null) {
            Window window = getWindow();
            window.setLayout(-2, -2);
            LayoutParams attributes = window.getAttributes();
            attributes.gravity = 53;
            attributes.flags = AdRequest.MAX_CONTENT_URL_LENGTH;
            attributes.y = (int) (context.getResources().getDimension(R.dimen.actionbar_size) - context.getResources().getDimension(R.dimen.height_dialog_drop_shadow));
        } else {
            int b = (al.m9263a(view).y - (al.m9285b(getContext()) / 2)) + (view.getHeight() * 3);
            Window window2 = getWindow();
            window2.setLayout(-2, -2);
            LayoutParams attributes2 = window2.getAttributes();
            attributes2.gravity = 5;
            attributes2.flags = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
            attributes2.y = b;
            C3095y.m9471a("set y for menu:" + b);
        }
        setCanceledOnTouchOutside(true);
        View findViewById = findViewById(R.id.btn_block);
        View findViewById2 = findViewById(R.id.view_separator);
        View findViewById3 = findViewById(R.id.view_moments_separator);
        TextView textView = (TextView) findViewById(R.id.btn_toggle_moments);
        if (match == null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            textView.setVisibility(8);
        } else {
            this.f4498b = match.isFollowed();
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById.setOnClickListener(this);
            textView.setText(this.f4498b ? R.string.unfollow_moments : R.string.follow_moments);
            textView.setClickable(true);
            textView.setOnClickListener(this);
        }
        findViewById(R.id.btn_report).setOnClickListener(this);
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_toggle_moments:
                if (this.f4497a instanceof ac) {
                    ((ac) this.f4497a).m6639a(!this.f4498b);
                }
                dismiss();
            case R.id.btn_report:
                this.f4497a.m6637e();
                dismiss();
            case R.id.btn_block:
                this.f4497a.m6638f();
                dismiss();
            default:
        }
    }
}
