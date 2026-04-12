package com.hlju.funlinkbluetooth.core.preferences

import android.content.Context
import androidx.core.content.edit

class SettingsRepository(context: Context) {

    companion object {
        private const val APP_PREFS_NAME = "funlink_settings"
        private const val PREF_THEME_MODE = "theme_mode"
        private const val NEARBY_PREFS_NAME = "funlink_nearby_settings"
        private const val PREF_HOST_ROOM_NAME = "host_room_name"
        private const val PREF_CLIENT_CONNECTION_NAME = "client_connection_name"
    }

    private val appPrefs = context.getSharedPreferences(APP_PREFS_NAME, Context.MODE_PRIVATE)
    private val nearbyPrefs = context.getSharedPreferences(NEARBY_PREFS_NAME, Context.MODE_PRIVATE)

    // Theme
    fun getThemeMode(): AppThemeMode {
        return AppThemeMode.fromStorage(appPrefs.getString(PREF_THEME_MODE, null))
    }

    fun setThemeMode(mode: AppThemeMode) {
        appPrefs.edit { putString(PREF_THEME_MODE, mode.storageValue) }
    }

    // Host room name
    fun getHostRoomName(): String {
        return nearbyPrefs.getString(PREF_HOST_ROOM_NAME, "")?.trim().orEmpty()
    }

    fun setHostRoomName(name: String) {
        nearbyPrefs.edit { putString(PREF_HOST_ROOM_NAME, name.trim()) }
    }

    // Client connection name
    fun getClientConnectionName(): String {
        return nearbyPrefs.getString(PREF_CLIENT_CONNECTION_NAME, "")?.trim().orEmpty()
    }

    fun setClientConnectionName(name: String) {
        nearbyPrefs.edit { putString(PREF_CLIENT_CONNECTION_NAME, name.trim()) }
    }
}
