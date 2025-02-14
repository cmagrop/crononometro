package com.example.cronometro.modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cronometros")
data class Cronometro(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "cronometro")
    val cronometro: Long
    //cronometro: sera el contador de los milisegundos


)
