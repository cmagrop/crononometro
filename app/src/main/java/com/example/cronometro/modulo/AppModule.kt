package com.example.cronometro.modulo

import android.content.Context
import androidx.room.Room
import com.example.cronometro.room.CronometroDatabase
import com.example.cronometro.room.CronometroDatabaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesCronometroDAO(cronometroDatabase: CronometroDatabase):CronometroDatabaseDAO
    {
        return cronometroDatabase.cronometroDAO()

    }

    @Singleton
    @Provides
    fun providesCronometroDatabase(@ApplicationContext context: Context): CronometroDatabase
    {
        return Room.databaseBuilder(
            context,
            CronometroDatabase::class.java,
            "cronometro_db"
        ).fallbackToDestructiveMigration().build()

    }

}