package com.example.cronometro.vistas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cronometro.componentes.BotonIconoPrincipal
import com.example.cronometro.componentes.TituloPrincipal
import com.example.cronometro.viewModels.CronometroViewModel

@OptIn(ExperimentalMaterial3Api::class)

//declaracion incompleta
@Composable
fun agregarVista(navController: NavController,cronometroViewModel: CronometroViewModel)
{
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloPrincipal(titulo = "Agregar Cronometro")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {

                   BotonIconoPrincipal(icono = Icons.Default.ArrowBack) {
                       navController.popBackStack() //volver atras
                   }

                }


            )



        }


    )

    {

        it -> ContentAddView(it,navController,cronometroViewModel)
    }



}

@Composable
fun ContentAddView(it: PaddingValues, navController: NavController, cronometroViewModel: CronometroViewModel) {

}
