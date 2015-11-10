package com.tinder.fragments;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.fragments.FragmentAnchoredPopup.C2567a;
import com.tinder.p030d.C2430i;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.CustomTextView;

public class aa extends C2567a {
    private FragmentAnchoredPopup f4847a;
    private C2430i f4848b;

    /* renamed from: com.tinder.fragments.aa.1 */
    class C26001 implements OnClickListener {
        final /* synthetic */ aa f4846a;

        C26001(aa aaVar) {
            this.f4846a = aaVar;
        }

        public void onClick(View view) {
            if (this.f4846a.f4848b != null) {
                this.f4846a.f4848b.m6750b(view);
            }
            this.f4846a.f4847a.m7071d();
        }
    }

    public void m7148a(@NonNull FragmentAnchoredPopup fragmentAnchoredPopup, @NonNull C2720t c2720t) {
        if (c2720t.getActivity() == null || fragmentAnchoredPopup.getActivity() == null) {
            C3095y.m9479c("Cannot configure a dialog when the recomendation fragment does not have an activity");
            return;
        }
        this.f4847a = fragmentAnchoredPopup;
        this.f4847a.m7063a(80, R.id.superlike, Strategy.GAMEPAD, c2720t);
        this.f4847a.m7062a(this.f4847a.getResources().getColor(R.color.orange));
        View b = this.f4847a.m7066b((int) R.id.dialog_top_view);
        if (b != null) {
            b.setVisibility(8);
        }
        b = this.f4847a.m7066b((int) R.id.dialog_top_bottom);
        if (b != null) {
            b.setPadding(0, 0, 0, 0);
        }
        CharSequence string = this.f4847a.getResources().getString(R.string.superlike_feature_intro_title);
        CharSequence string2 = this.f4847a.getResources().getString(R.string.superlike_feature_intro_body);
        View inflate = View.inflate(this.f4847a.getActivity(), R.layout.dialog_superlike_content, null);
        ((TextView) inflate.findViewById(R.id.content_title)).setText(string);
        ((TextView) inflate.findViewById(R.id.content_text)).setText(string2);
        this.f4847a.setCenterView(inflate);
        CustomTextView customTextView = (CustomTextView) View.inflate(this.f4847a.getActivity(), R.layout.dialog_superlike_feature_bottom, null);
        customTextView.setText(R.string.superlike_feature_confirmation);
        customTextView.setOnClickListener(new C26001(this));
        this.f4847a.setBottomView(customTextView);
        b = (ImageButton) this.f4847a.m7066b((int) R.id.superlike_icon);
        if (b != null) {
            al.m9271a(b, ContextCompat.getDrawable(this.f4847a.getActivity(), R.drawable.selector_recs_superlike));
            b.setEnabled(true);
        }
    }
}
