package com.example.cronometro.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TituloPrincipal(titulo: String)
{
    Text(text = titulo, color = Color.White, fontWeight = FontWeight.Bold)
}