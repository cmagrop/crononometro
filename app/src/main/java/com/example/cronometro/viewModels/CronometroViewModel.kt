package com.example.cronometro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cronometro.modelos.Cronometro
import com.example.cronometro.repositorios.CronometroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CronometroViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {

    private  val _cronometroList = MutableStateFlow<List<Cronometro>>(emptyList())
    val cronometroList = _cronometroList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.obtenerTodosLosCronometros().collect(){
                item ->

                if(item.isNullOrEmpty())
                {
                    _cronometroList.value = emptyList()

                }

                else{

                    _cronometroList.value = item
                }
            }


        }

    }

    fun agregarCronometro(cronometro: Cronometro)=
        viewModelScope.launch { repository.agregarCronometro(cronometro) }

    fun actualizarCronometro(cronometro: Cronometro) =
        viewModelScope.launch { repository.actualizarCronometro(cronometro) }

    fun eliminarCronometro(cronometro: Cronometro) =
        viewModelScope.launch { repository.eliminarCronometro(cronometro) }



}