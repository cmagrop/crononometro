package com.example.cronometro.viewModels

import androidx.lifecycle.ViewModel
import com.example.cronometro.repositorios.CronometroRepository
import javax.inject.Inject

class CronometroViewModel
@Inject constructor(private val repository: CronometroRepository):ViewModel() {
}