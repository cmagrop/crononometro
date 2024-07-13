package com.example.cronometro.vistas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cronometro.navegation.navManager
import com.example.cronometro.ui.RoomCronometroAppTheme
import com.example.cronometro.viewModels.CronometroViewModel
import com.example.cronometro.viewModels.CronosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cronometroViewModel: CronometroViewModel by viewModels() //proceso/hebra  1

        val cronosViewModel: CronosViewModel by viewModels() //proceso 2 / hebra 2

        //crear un layout base para nuestra aplicacion de Android sin utilizar xml
        setContent{
            RoomCronometroAppTheme{

                Surface (

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                )
                {

                    //descomentar, listo
                   navManager(cronosViewModel,cronometroViewModel )


                }

            }


        }



        //setContentView(R.layout.activity_main)

    }
}