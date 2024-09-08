package com.coding.meet.docscannerapp.utils

import android.content.Context

/**
 * Created 24-04-2024 at 06:24 pm
 */

class DataStore(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    private val keyIsDarkMode = "isDarkMode"

    var isDarkMode
        get() = sharedPreferences.getBoolean(keyIsDarkMode,  false)
        set(value) {
            editor.putBoolean(keyIsDarkMode, value)
            editor.commit()
        }
}