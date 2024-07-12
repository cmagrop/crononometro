package com.example.cronometro.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cronometro.R

@Composable
fun TituloPrincipal(titulo: String)
{
    Text(text = titulo, color = Color.White, fontWeight = FontWeight.Bold)
}

fun formatoTiempo(tiempo:Long): String
{
    val segundos = (tiempo/1000)
    val minutos = (segundos/60)
    val horas = segundos/3600
    return  String.format("%02d:%02d:02%",horas,minutos,segundos)


}
@Composable
fun CronCard(titulo: String,crono:String,onClick:()->Unit)
{
    //Box : layout principal o escenario donde la obra se llevará a cabo
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .clickable { onClick } )
    {

        Column(modifier = Modifier.padding(15.dp)) {
            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row {

                Icon(
                    painter = painterResource(R.drawable.time ),
                    contentDescription = " ",
                    tint = Color.Gray
                )

                Text(text = crono, fontSize = 20.sp)


            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = MaterialTheme.colorScheme.primary
            )



        }


    }

}