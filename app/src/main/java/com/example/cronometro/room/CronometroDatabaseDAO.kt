package com.example.cronometro.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cronometro.modelos.Cronometro
import dagger.Provides
import kotlinx.coroutines.flow.Flow


@Dao  //Data Access Object
interface CronometroDatabaseDAO {
    //mostrar a todos los cronometros
    @Query("select * from cronometros")
    fun obtenerCronometros():Flow<List<Cronometro>>
    //muestre un único cronometro por id
    @Query("select * from cronometros where id = :id")
    fun obtenerCronometrosPorId(id: Int): Flow<Cronometro>

    @Query("insert into cronometros(title,cronometro) values (:title,:cronometro)")
    fun ingregarRegistro(title:String,cronometro:Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(cronometro: Cronometro)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun actualizar(cronometro: Cronometro)

    @Delete
    suspend fun eliminar(cronometro: Cronometro)

}