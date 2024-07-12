package com.example.cronometro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cronometro.modelos.Cronometro
import com.example.cronometro.repositorios.CronometroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CronometroViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {
    fun eliminarCronometro(cronometro: Cronometro) =
        viewModelScope.launch { repository.eliminarCronometro(cronometro) }


    private  val _cronometroList = MutableStateFlow<List<Cronometro>>(emptyList())
    val cronometroList = _cronometroList.asStateFlow()

}