package com.istea.mihoroscopo;

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.istea.mihoroscopo.presentacion.detalle.DetallePage
import com.istea.mihoroscopo.presentacion.signos.SignosPage
import com.istea.mihoroscopo.router.Ruta

@Composable
fun MainPage() {
    val navHostController = rememberNavController()
    NavHost(
            navController = navHostController,
            startDestination = "signos"
    ) {
        composable(
                route = Ruta.Signos.id
        ) {
            SignosPage(navHostController)
        }
        composable(
                route = "detalle/{signoid}",
                arguments =  listOf(
                    navArgument("signoid") { type= NavType.StringType }
            )
        ) {
            val signoId = it.arguments?.getString("signoid") ?: ""
            DetallePage(navHostController, signoId)
        }
    }
}


//La aplicación MiHoroscopo tiene algunos errores que deben ser corregidos:
//El botón de back no funciona. (3 puntos)
//No se ve el loading del detalle. (3 puntos)
//Cambiar el color del topbar para que coincida con los colores de las cards. (2 puntos)
//Corregir los textos hardcodeados de las cards de Amor, Riqueza y Bienestar. (2 puntos)