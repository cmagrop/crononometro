package com.example.cronometro.componentes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable

fun BotonFlotante(onClick: ()->Unit)
{
    FloatingActionButton( onClick = onClick,
                         containerColor = MaterialTheme.colorScheme.primary,
                         contentColor = Color.White)
    {
        Icon(

            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )

    }

}

@Composable
fun BotonIconoPrincipal(icono: ImageVector, onClick: () -> Unit)
{
    IconButton(onClick = onClick) {

        Icon(imageVector = icono, contentDescription = null,tint= Color.White)

    }

}

//crear botones pendientes

@Preview
@Composable
fun PreviewBotonCirculo()
{
    BotonCirculo(icon = null, onClick = {} )

    
}

@Composable

fun botonCirculo(icon: Painter?, enabled: Boolean=false, onClick: () -> Unit)
{


    Button(

        onClick = onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(8.dp),
        enabled = enabled,
        modifier = Modifier.padding(horizontal = 15.dp)

    ) {

        if (icon != null) {
            Icon(

                painter = icon,
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
        }

    }



}
