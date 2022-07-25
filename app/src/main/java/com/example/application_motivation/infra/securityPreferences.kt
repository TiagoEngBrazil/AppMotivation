package com.example.application_motivation.infra

import android.content.Context
import android.content.SharedPreferences

class securityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(Key: String, STR: String) {
        security.edit().putString( Key, STR).apply()
    }

    fun getString(Key: String): String {
        return security.getString(Key, "") ?: ""
    }
}