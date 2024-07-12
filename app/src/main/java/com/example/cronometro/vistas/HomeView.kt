package com.example.cronometro.vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cronometro.componentes.BotonFlotante
import com.example.cronometro.componentes.CronCard
import com.example.cronometro.componentes.TituloPrincipal
import com.example.cronometro.componentes.formatoTiempo
import com.example.cronometro.viewModels.CronometroViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController,cronometroViewModel: CronometroViewModel)
{
    Scaffold(
        topBar = {
            
            CenterAlignedTopAppBar(
                title = { TituloPrincipal(titulo = "Cronometro App")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            BotonFlotante {
                navController.navigate("agregarView")
            }
        }
    )
    {
        ContentHomeView(it,navController,cronometroViewModel)
    }


}

@Composable
fun ContentHomeView(it: PaddingValues,
                    navController: NavController,
                    cronometroViewModel: CronometroViewModel) {

    Column(modifier = Modifier.padding(it))
    {

        val cronometroList by cronometroViewModel.cronometroList.collectAsState()
        LazyColumn {
            items(cronometroList)
            {
                item ->
                val eliminar = SwipeAction(
                    icon = rememberVectorPainter(image = Icons.Default.Delete ),
                    background = Color.Red,
                    onSwipe = {cronometroViewModel.eliminarCronometro(item)}
                )

                SwipeableActionsBox(endActions = listOf(eliminar), swipeThreshold = 270.dp ) {

                    CronCard(item.title,formatoTiempo(item.cronometro) ) {

                        navController.navigate("EditarView/${item.id}")

                    }



                }


            }
        }

    }




}


