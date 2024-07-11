package com.example.cronometro.viewModels

import androidx.lifecycle.ViewModel
import com.example.cronometro.modelos.Cronometro
import com.example.cronometro.repositorios.CronometroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CronometroViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {
    fun eliminarCronometro(item: Cronometro) {

    }

    private  val _cronometroList = MutableStateFlow<List<Cronometro>>(emptyList())
    val cronometroList = _cronometroList.asStateFlow()

}