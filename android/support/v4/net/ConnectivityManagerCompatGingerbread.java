package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return false;
            default:
                return true;
        }
    }
}
