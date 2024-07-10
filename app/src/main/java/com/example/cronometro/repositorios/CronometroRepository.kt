package com.example.cronometro.repositorios
import com.example.cronometro.modelos.Cronometro
import com.example.cronometro.room.CronometroDatabase
import com.example.cronometro.room.CronometroDatabaseDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronometroRepository
@Inject constructor(private val cronometroDatabaseDAO: CronometroDatabaseDAO)
//@Inject construye un constructor para cronometroDatabaseDAO basandose en CronometroDatabaseDAO
{
    suspend fun agregarCronometro(cronometro: Cronometro)
    = cronometroDatabaseDAO.insertar(cronometro)

    suspend fun actualizarCronometro(cronometro: Cronometro)
    = cronometroDatabaseDAO.actualizar(cronometro)

    suspend fun eliminarCronometro(cronometro: Cronometro)
    = cronometroDatabaseDAO.eliminar(cronometro)

    fun obtenerTodosLosCronometros(): Flow<List<Cronometro>>
    = cronometroDatabaseDAO.obtenerCronometros().flowOn(Dispatchers.IO).conflate()

    fun obtenerCronometroPorId(id:Int):Flow<Cronometro>
    = cronometroDatabaseDAO.obtenerCronometrosPorId(id).flowOn(Dispatchers.IO).conflate()




}