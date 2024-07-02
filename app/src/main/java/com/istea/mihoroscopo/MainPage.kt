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