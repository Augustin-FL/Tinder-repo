package com.android.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError {
    private Intent f190b;

    public AuthFailureError(C0301g c0301g) {
        super(c0301g);
    }

    public String getMessage() {
        if (this.f190b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
