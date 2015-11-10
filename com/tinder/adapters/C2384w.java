package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tinder.R;
import com.tinder.iap.util.C2770g;
import com.tinder.utils.C3080q;
import com.tinder.utils.C3095y;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tinder.adapters.w */
public class C2384w extends Adapter<C2383a> {
    private String f4264a;
    private Context f4265b;
    private LayoutInflater f4266c;
    private Pattern f4267d;
    private List<C2770g> f4268e;

    /* renamed from: com.tinder.adapters.w.a */
    static class C2383a extends ViewHolder {
        @Nullable
        TextView f4263a;

        public C2383a(View view, boolean z, float f) {
            super(view);
            this.f4263a = (TextView) view.findViewById(R.id.paywall_row_option_text);
            if (z && this.f4263a != null) {
                this.f4263a.setTextSize(0, f);
            }
        }
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m6492a((C2383a) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m6490a(viewGroup, i);
    }

    public C2384w(@NonNull Context context, @NonNull List<C2770g> list, @NonNull Pattern pattern) {
        this.f4265b = context;
        this.f4268e = list;
        this.f4267d = pattern;
        this.f4266c = LayoutInflater.from(context);
        this.f4264a = this.f4265b.getResources().getString(R.string.plus_paywall_per_month);
    }

    public C2383a m6490a(ViewGroup viewGroup, int i) {
        boolean z = false;
        View inflate = this.f4266c.inflate(R.layout.row_paywall_option, viewGroup, false);
        if (getItemCount() > 3 && inflate != null) {
            int dimensionPixelSize = this.f4265b.getResources().getDimensionPixelSize(R.dimen.padding_med);
            inflate.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
        float dimension = this.f4265b.getResources().getDimension(R.dimen.text_med);
        if (getItemCount() > 3) {
            z = true;
        }
        return new C2383a(inflate, z, dimension);
    }

    public void m6492a(C2383a c2383a, int i) {
        C3095y.m9483d("Setting up product view");
        C2770g a = m6491a(i);
        if (a != null) {
            String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            Matcher matcher = this.f4267d.matcher(a.m7888b());
            if (matcher.matches() && matcher.groupCount() == 1) {
                str = matcher.group(1);
            }
            BigDecimal scale = new BigDecimal((double) a.m7890d()).divide(new BigDecimal(str), 2).setScale(2, 2);
            int parseInt = Integer.parseInt(str);
            String a2 = C3080q.m9423a(scale, a.m7886a());
            NumberFormat integerInstance = NumberFormat.getIntegerInstance();
            CharSequence quantityString = this.f4265b.getResources().getQuantityString(R.plurals.plus_paywall_option_text, parseInt, new Object[]{integerInstance.format((long) parseInt), a2});
            if (quantityString.contains(this.f4264a)) {
                CharSequence spannableString = new SpannableString(quantityString);
                spannableString.setSpan(new RelativeSizeSpan(0.75f), quantityString.indexOf(this.f4264a), spannableString.length(), 33);
                if (c2383a.f4263a != null) {
                    c2383a.f4263a.setText(spannableString);
                }
            } else if (c2383a.f4263a != null) {
                c2383a.f4263a.setText(quantityString);
            }
        }
        if (i == 0) {
            c2383a.itemView.setBackgroundResource(R.drawable.selector_bg_paywall_best_option);
        } else {
            c2383a.itemView.setBackgroundResource(R.drawable.selector_paywall_option_background);
        }
    }

    public int getItemCount() {
        return this.f4268e.size();
    }

    @Nullable
    public C2770g m6491a(int i) {
        return i == this.f4268e.size() ? null : (C2770g) this.f4268e.get(i);
    }
}
