package com.tinder.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.Environment;
import com.tinder.managers.ManagerApp;
import com.tinder.model.UserMeta;
import com.tinder.utils.C3092v;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;

public class DevControls extends FrameLayout implements OnCheckedChangeListener {
    private static final long UPDATE_LOOP_MS = 1000;
    private final Runnable UPDATE_LOOP_RUNNABLE;
    private CheckBox mCheckBoxFbApp;
    private CheckBox mCheckBoxLog;
    private Handler mHandler;
    private ListView mListViewStatus;
    private List<DevPanelStatusRunnable> mListViewStatusGenerators;
    private RadioButton mRadioDev;
    private RadioButton mRadioProd;
    private RadioButton mRadioProdTest;

    /* renamed from: com.tinder.views.DevControls.1 */
    class C31101 implements Runnable {
        C31101() {
        }

        public void run() {
            DevControls.this.mListViewStatusGenerators.clear();
            DevControls.this.addStatusGenerators();
            BaseAdapter baseAdapter = (BaseAdapter) DevControls.this.mListViewStatus.getAdapter();
            baseAdapter.notifyDataSetChanged();
            baseAdapter.notifyDataSetInvalidated();
            DevControls.this.mHandler.postDelayed(DevControls.this.UPDATE_LOOP_RUNNABLE, DevControls.UPDATE_LOOP_MS);
        }
    }

    /* renamed from: com.tinder.views.DevControls.2 */
    class C31112 extends BaseAdapter {
        C31112() {
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public int getCount() {
            return DevControls.this.mListViewStatusGenerators.size();
        }

        public DevPanelStatusRunnable getItem(int i) {
            return (DevPanelStatusRunnable) DevControls.this.mListViewStatusGenerators.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return false;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Object item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(DevControls.this.getContext()).inflate(R.layout.row_view_dev_controls, viewGroup, false);
                view.setOnClickListener(item);
            }
            Pair run = item.run();
            ((TextView) view.findViewById(R.id.text1)).setText((CharSequence) run.first);
            ((TextView) view.findViewById(R.id.text2)).setText((CharSequence) run.second);
            return view;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return DevControls.this.mListViewStatusGenerators.isEmpty();
        }
    }

    abstract class DevPanelStatusRunnable implements OnClickListener {
        public abstract Pair<String, String> run();

        DevPanelStatusRunnable() {
        }

        public void onClick(View view) {
            DevControls.this.UPDATE_LOOP_RUNNABLE.run();
        }
    }

    /* renamed from: com.tinder.views.DevControls.3 */
    class C31123 extends DevPanelStatusRunnable {
        C31123() {
            super();
        }

        public Pair<String, String> run() {
            return new Pair("Mad Ave force enabled (tap to toggle)", String.valueOf(ManagerApp.m7931v().m7985p()));
        }

        public void onClick(View view) {
            ManagerApp.m7931v().m7969a(!ManagerApp.m7931v().m7985p());
            C3095y.m9488g("Changed to " + String.valueOf(ManagerApp.m7931v().m7985p()));
            super.onClick(view);
        }
    }

    /* renamed from: com.tinder.views.DevControls.4 */
    class C31134 extends DevPanelStatusRunnable {
        C31134() {
            super();
        }

        public Pair<String, String> run() {
            return new Pair("Mad Ave swipe count", String.valueOf(ManagerApp.m7914e().m8849i()));
        }
    }

    /* renamed from: com.tinder.views.DevControls.5 */
    class C31145 extends DevPanelStatusRunnable {
        C31145() {
            super();
        }

        public Pair<String, String> run() {
            int adSwipeLimit;
            UserMeta c = ManagerApp.m7911b().m8142c();
            if (c != null) {
                adSwipeLimit = c.getGlobalConfig().getAdSwipeLimit();
            } else {
                adSwipeLimit = -1;
            }
            return new Pair("Mad Ave swipe limit", adSwipeLimit == -1 ? "No meta" : String.valueOf(adSwipeLimit));
        }
    }

    public DevControls(Context context) {
        super(context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mListViewStatusGenerators = new ArrayList();
        this.UPDATE_LOOP_RUNNABLE = new C31101();
        init();
    }

    public DevControls(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mListViewStatusGenerators = new ArrayList();
        this.UPDATE_LOOP_RUNNABLE = new C31101();
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_dev_controls, this);
        setVisibility(8);
    }

    private void initStatusView() {
        addStatusGenerators();
        this.mListViewStatus.setAdapter(new C31112());
        C3092v.m9460a(this.mListViewStatus, 1.5f);
        this.UPDATE_LOOP_RUNNABLE.run();
    }

    private void addStatusGenerators() {
        this.mListViewStatusGenerators.add(new C31123());
        this.mListViewStatusGenerators.add(new C31134());
        this.mListViewStatusGenerators.add(new C31145());
    }

    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.dev_radio_prod:
                if (z) {
                    ManagerApp.m7908a(Environment.PROD);
                }
            case R.id.dev_radio_prodtest:
                if (z) {
                    ManagerApp.m7908a(Environment.PRODTEST);
                }
            case R.id.dev_radio_dev:
                if (z) {
                    ManagerApp.m7908a(Environment.DEV);
                }
            case R.id.dev_checkbox_logging:
                ManagerApp.m7910a(z);
            case R.id.dev_checkbox_fb_web_sso:
                ManagerApp.f5579b = z;
            default:
        }
    }
}
