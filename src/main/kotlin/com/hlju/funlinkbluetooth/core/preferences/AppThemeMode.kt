package com.hlju.funlinkbluetooth.core.preferences

enum class AppThemeMode(val storageValue: String) {
    System("system"),
    Light("light"),
    Dark("dark");

    companion object {
        fun fromStorage(value: String?): AppThemeMode {
            return entries.firstOrNull { it.storageValue == value } ?: System
        }
    }

    fun displayName(): String = when (this) {
        System -> "跟随系统"
        Light -> "浅色"
        Dark -> "深色"
    }
}
