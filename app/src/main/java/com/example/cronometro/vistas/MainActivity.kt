package com.example.cronometro.vistas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cronometro.R
import com.example.cronometro.viewModels.CronometroViewModel
import com.example.cronometro.viewModels.CronosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cronometroViewModel: CronometroViewModel by viewModels()

        val cronosViewModel: CronosViewModel by viewModels()

        setContent{


        }



        //setContentView(R.layout.activity_main)

    }
}