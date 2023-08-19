package com.srs.waterlevel

import android.content.Context
import android.content.SharedPreferences

class PrefManager(_context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var context: Context? = null

    // shared pref mode
    var privateMode = 0

    // shared pref mode
    var PRIVATE_MODE = 0

    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    var login: Int
        get() = pref.getInt(LOGIN, 0)
        set(isLogged) {
            editor.putInt(LOGIN, isLogged)
            editor.commit()
        }

    var session: Boolean
        get() = pref.getBoolean(SESSION, false)
        set(sessionActive) {
            editor.putBoolean(SESSION, sessionActive)
            editor.commit()
        }

    var userid: String?
        get() = pref.getString(USERID, null)
        set(userId) {
            editor.putString(USERID, userId)
            editor.commit()
        }

    var name: String?
        get() = pref.getString(NAME, null)
        set(sureName) {
            editor.putString(NAME, sureName)
            editor.commit()
        }

    var email: String?
        get() = pref.getString(EMAIL, null)
        set(mail) {
            editor.putString(EMAIL, mail)
            editor.commit()
        }

    var password: String?
        get() = pref.getString(PASSWORD, null)
        set(pass) {
            editor.putString(PASSWORD, pass)
            editor.commit()
        }

    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "sulungresearch"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        private const val LOGIN = "Login"
        private const val SESSION = "Session"

        const val USERID = "user_id"
        const val NAME = "name"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, privateMode)
        editor = pref.edit()
    }

    fun prefManag(context: Context) {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun timeLaunch(): Boolean {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }
}