package com.example.cronometro.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cronometro.viewModels.CronometroViewModel
import com.example.cronometro.vistas.HomeView

//incompleto
@Composable
fun navManager(cronometroViewModel: CronometroViewModel)
{
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
        ){

        composable("Home"){

            HomeView(navController, cronometroViewModel )

        }

        composable("AgregarView")
        {
            //AgregarView
        }

        composable("EditarVista/{id}")
        {

        }


        }

}
