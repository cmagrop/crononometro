package com.example.cronometro.viewModels

import android.util.Log
import androidx.collection.emptyLongSet
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cronometro.estados.CronometroEstado
import com.example.cronometro.repositorios.CronometroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CronosViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {

    //variables
    var estado by mutableStateOf(CronometroEstado())

    var cronometroJob by  mutableStateOf<Job?>(null)

    var tiempo by mutableStateOf(0L)

    fun obtenerCronometroPorId(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {

            repository.obtenerCronometroPorId(id).collect {

                    item ->
                if (item != null) {
                    tiempo = item.cronometro
                    estado = estado.copy(title = item.title)

                } else {
                    Log.d("Error", "El objeto es nulo")

                }

            }

        }
    }

        fun valorDelEstado(valor:String)
        {
            estado = estado.copy(title = valor)

        }

        fun iniciar()
        {
            estado= estado.copy(cronometroActivo = true)

        }

        fun pausar()
        {

            estado= estado.copy(

                cronometroActivo = false,
                mostrarBotonGuardar = true


            )

        }

        fun detener()
        {
            cronometroJob?.cancel()
            tiempo=0

            estado = estado.copy(

                cronometroActivo = false,
                mostrarBotonGuardar = false,
                mostrarCamposDeTexto = false,
                title = ""

            )
        }

        fun mostrarCampoDeTexto()
        {
            estado = estado.copy(
                mostrarCamposDeTexto = true
            )

        }

        fun cronometro()
        {
            if(estado.cronometroActivo) // es true
            {
                cronometroJob?.cancel() //asegura la cancelacion del trabajo

                cronometroJob =
                    viewModelScope.launch {
                        while (true)
                        {
                            delay(1000)
                            //tiempo = tiempo+1000
                            tiempo+=1000

                        }
                    }

            }

            else{

                cronometroJob?.cancel()
            }
        }




    }


