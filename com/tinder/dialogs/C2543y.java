package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tinder.R;
import com.tinder.model.Match;
import com.tinder.p030d.aj;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.dialogs.y */
public class C2543y extends Dialog implements OnClickListener {
    private aj f4636a;
    private Match f4637b;

    public C2543y(@NonNull Context context, aj ajVar, Match match) {
        super(context, R.style.Theme.FloatingDialog);
        getWindow().setWindowAnimations(R.style.dialog_up_down_animation);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.view_dialog_moment_game);
        Button button = (Button) findViewById(R.id.moment_game_dialog_btn_block);
        Button button2 = (Button) findViewById(R.id.moment_game_dialog_btn_report);
        Button button3 = (Button) findViewById(R.id.moment_game_dialog_btn_like_message);
        Button button4 = (Button) findViewById(R.id.moment_game_dialog_btn_hide_moments);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        this.f4637b = match;
        String name = this.f4637b.getName();
        button3.setText(String.format(context.getResources().getString(R.string.moment_dialog_send_message), new Object[]{name}));
        button4.setText(String.format(context.getResources().getString(R.string.moment_dialog_hide_moments), new Object[]{name}));
        button.setText(String.format(context.getResources().getString(R.string.moment_dialog__moments_unmatch), new Object[]{name}));
        this.f4636a = ajVar;
    }

    public void onClick(@NonNull View view) {
        C3095y.m9471a("view=" + view);
        switch (view.getId()) {
            case R.id.moment_game_dialog_btn_like_message:
                this.f4636a.m6657i();
                dismiss();
            case R.id.moment_game_dialog_btn_hide_moments:
                this.f4636a.m6658j();
                dismiss();
            case R.id.moment_game_dialog_btn_block:
                this.f4636a.m6660l();
                dismiss();
            case R.id.moment_game_dialog_btn_report:
                this.f4636a.m6659k();
                dismiss();
            default:
        }
    }
}
