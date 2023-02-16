package com.example.paciencia_spider

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class ConfigDataBaseUser {
    private var dataBase: SharedPreferences
    private var context: Context

    constructor(context: Context) {
        this.context = context

        dataBase = context.getSharedPreferences(
            context.resources.getString(R.string.db_user),
            Context.MODE_PRIVATE
        )
    }

    fun createDB(name: String) {
        var editor = dataBase.edit()

        editor.putString(context.resources.getString(R.string.db_user), name)
        editor.putInt(context.resources.getString(R.string.db_wins), 0)
        editor.putInt(context.resources.getString(R.string.db_defeats), 0)

        editor.commit()
    }

    fun existUser(): Boolean {
        return !getNameUser().equals("")
    }

    fun getNameUser(): String? {
        return dataBase.getString(context.resources.getString(R.string.db_user), "")
    }

    fun getWins(): Int? {
        return dataBase.getInt(context.resources.getString(R.string.db_wins), 0)
    }

    fun getDefeats(): Int? {
        return dataBase.getInt(context.resources.getString(R.string.db_defeats), 0)
    }

    fun deleteUser() {
        var editor = dataBase.edit()

        editor.putString(context.resources.getString(R.string.db_user), "")
        editor.putInt(context.resources.getString(R.string.db_wins), 0)
        editor.putInt(context.resources.getString(R.string.db_defeats), 0)

        editor.commit()
    }
}