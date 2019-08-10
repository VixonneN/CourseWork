package com.suai.sergey.storage;

import android.content.Context;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PreferencesProvider {

    private PreferencesProvider() {
    }

    @Nullable
    private static Preferences sPreferences;

    @MainThread
    public static void initialize(@NonNull Context context) {
        if (sPreferences == null) {
            sPreferences = new Preferences(context);
        } else {
            throw new IllegalStateException("You shouldn't call initialize twice");
        }
    }

    @NonNull
    public static Preferences getPreferences() {
        if (sPreferences == null) {
            throw new IllegalStateException("You should call initialize before accessing Preferences");
        }
        return sPreferences;
    }
}
