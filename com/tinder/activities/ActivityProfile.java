package com.tinder.activities;

import android.content.Intent;
import android.os.Bundle;
import com.tinder.base.ActivityBase;
import com.tinder.enums.UserType;
import com.tinder.fragments.C2745x;
import com.tinder.model.User;

public class ActivityProfile extends ActivityBase {
    C2745x f3972a;
    User f3973b;
    boolean f3974c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.f3973b = (User) intent.getSerializableExtra("user");
        this.f3974c = intent.getBooleanExtra("from_wear", false);
        this.f3972a = C2745x.m7751a(this.f3973b, UserType.REC);
        m5923b(this.f3972a);
    }
}
