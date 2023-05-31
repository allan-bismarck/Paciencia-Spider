package com.app.paciencia_spider

import android.content.Context
import android.content.SharedPreferences

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
        val editor = dataBase.edit()

        editor.putString(context.resources.getString(R.string.db_user), name)
        editor.putInt(context.resources.getString(R.string.db_wins), 0)
        editor.putInt(context.resources.getString(R.string.db_defeats), 0)

        editor.apply()
    }

    fun existUser(): Boolean {
        return !getNameUser().equals("")
    }

    fun getNameUser(): String? {
        return dataBase.getString(context.resources.getString(R.string.db_user), "")
    }

    fun getWins(): Int {
        return dataBase.getInt(context.resources.getString(R.string.db_wins), 0)
    }
    
    fun setWins(win: Int) {
        val editor = dataBase.edit()
        val wins = dataBase.getInt(context.resources.getString(R.string.db_wins), 0)
        editor.putInt(context.resources.getString(R.string.db_wins), wins + win)
        editor.apply()
    }

    fun getDefeats(): Int {
        return dataBase.getInt(context.resources.getString(R.string.db_defeats), 0)
    }

    fun setDefeats(defeat: Int) {
        val editor = dataBase.edit()
        val defeats = dataBase.getInt(context.resources.getString(R.string.db_defeats), 0)
        editor.putInt(context.resources.getString(R.string.db_defeats), defeats + defeat)
        editor.apply()
    }

    fun deleteUser() {
        val editor = dataBase.edit()

        editor.putString(context.resources.getString(R.string.db_user), "")
        editor.putInt(context.resources.getString(R.string.db_wins), 0)
        editor.putInt(context.resources.getString(R.string.db_defeats), 0)

        editor.apply()
    }
}