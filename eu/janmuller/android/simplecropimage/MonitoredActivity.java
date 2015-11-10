package eu.janmuller.android.simplecropimage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends ActionBarActivity {
    private final ArrayList<C3182b> f6802a;

    /* renamed from: eu.janmuller.android.simplecropimage.MonitoredActivity.b */
    public interface C3182b {
        void m9599a(MonitoredActivity monitoredActivity);

        void m9600b(MonitoredActivity monitoredActivity);

        void m9601c(MonitoredActivity monitoredActivity);

        void m9602d(MonitoredActivity monitoredActivity);
    }

    /* renamed from: eu.janmuller.android.simplecropimage.MonitoredActivity.a */
    public static class C3183a implements C3182b {
        public void m9603a(MonitoredActivity monitoredActivity) {
        }

        public void m9604b(MonitoredActivity monitoredActivity) {
        }

        public void m9605c(MonitoredActivity monitoredActivity) {
        }

        public void m9606d(MonitoredActivity monitoredActivity) {
        }
    }

    public MonitoredActivity() {
        this.f6802a = new ArrayList();
    }

    public void m9544a(C3182b c3182b) {
        if (!this.f6802a.contains(c3182b)) {
            this.f6802a.add(c3182b);
        }
    }

    public void m9545b(C3182b c3182b) {
        this.f6802a.remove(c3182b);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f6802a.iterator();
        while (it.hasNext()) {
            ((C3182b) it.next()).m9599a(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f6802a.iterator();
        while (it.hasNext()) {
            ((C3182b) it.next()).m9600b(this);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
        }
        return true;
    }

    protected void onStart() {
        super.onStart();
        Iterator it = this.f6802a.iterator();
        while (it.hasNext()) {
            ((C3182b) it.next()).m9601c(this);
        }
    }

    protected void onStop() {
        super.onStop();
        Iterator it = this.f6802a.iterator();
        while (it.hasNext()) {
            ((C3182b) it.next()).m9602d(this);
        }
    }
}
