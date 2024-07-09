package com.example.cronometro.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cronometro.models.Cronometro

@Database(entities = [Cronometro::class], version = 1, exportSchema = false)
abstract class CronometroDatabase: RoomDatabase() {
    abstract fun  cronometroDAO() : CronometroDatabaseDAO
}