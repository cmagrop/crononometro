package com.example.cronometro.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cronometro.estados.CronometroEstado
import com.example.cronometro.repositorios.CronometroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class CronosViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {

    var estado by mutableStateOf(CronometroEstado())

    var cronometroJob by  mutableStateOf<Job?>(null)



}