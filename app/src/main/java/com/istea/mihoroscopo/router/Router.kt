package com.istea.mihoroscopo.router

import android.annotation.SuppressLint
import androidx.navigation.NavHostController
import com.istea.mihoroscopo.repository.Signo


class Router(
    val navHostController: NavHostController
) {
    fun navegar(ruta: Ruta) {
        when(ruta){
            Ruta.Signos -> navHostController.navigate(ruta.id)
            is Ruta.Detalle -> {
                val route = String.format(format="%s/%s",ruta.id,ruta.signo.signoId)
                navHostController.navigate(route)
            }
        }
    }

    fun back(){
        navHostController.popBackStack()
    }
}

sealed class Ruta(val id: String) {
    data object Signos: Ruta("signos")
    data class Detalle(val signo: Signo): Ruta("detalle")
}
