package com.example.cronometro.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cronometro.viewModels.CronometroViewModel
import com.example.cronometro.viewModels.CronosViewModel
import com.example.cronometro.vistas.HomeView
import com.example.cronometro.vistas.agregarView
import com.example.cronometro.vistas.editarView

//incompleto
@Composable
fun navManager(cronosViewModel: CronosViewModel, cronometroViewModel: CronometroViewModel)
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

            agregarView(navController, cronometroViewModel,cronosViewModel)
        }

        composable("EditarView/{id}", arguments = listOf(
            navArgument("id"){
                type= NavType.IntType
            }
        ))
        {

            val id =  it.arguments?.getInt("id")?:0
            editarView(navController,cronometroViewModel,cronosViewModel,id)

        }


        }

}
