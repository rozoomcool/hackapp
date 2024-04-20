package com.rozoomcool.hackapp.core.preferences

interface PreferencesObserver {
    fun setString(key: String, value: String)
    fun getString(key: String): String?
    fun observePreferences(key: String, callback: (String?) -> Unit)
    fun clearObserver(key: String)
}