package com.example.cronometro.vistas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cronometro.R
import com.example.cronometro.componentes.BotonIconoPrincipal
import com.example.cronometro.componentes.TituloPrincipal
import com.example.cronometro.componentes.botonCirculo
import com.example.cronometro.componentes.formatoTiempo
import com.example.cronometro.viewModels.CronometroViewModel
import com.example.cronometro.viewModels.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)

//declaracion incompleta
@Composable
fun agregarView(
    navController: NavController,
    cronometroViewModel: CronometroViewModel,
    cronosViewModel: CronosViewModel
)
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

        it -> ContentAddView(it,navController,cronometroViewModel,cronosViewModel)
    }



}

@Composable
fun ContentAddView(
    it: PaddingValues,
    navController: NavController,
    cronometroViewModel: CronometroViewModel,
    cronosViewModel: CronosViewModel
) {


    val estado = cronosViewModel.estado

    LaunchedEffect(estado.cronometroActivo) {
        cronosViewModel.cronometro()
    }

    Column (
        modifier =
        Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {

        Text(
            text = formatoTiempo(cronosViewModel.tiempo),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)

        )
        {

            //iniciar

            botonCirculo(
                icon = painterResource(id = R.drawable.play),
                enabled = true

            ) {

                cronosViewModel.iniciar()

            }




        }

    }


}
