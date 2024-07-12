package com.example.cronometro.estados

data class CronometroEstado(

    val cronometroActivo: Boolean = false,
    val mostrarBotonGuardar: Boolean = false,
    val mostrarCamposDeTexto: Boolean =false,
    val title: String = ""

)
