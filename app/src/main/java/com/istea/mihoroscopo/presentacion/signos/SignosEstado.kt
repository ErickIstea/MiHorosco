package com.istea.mihoroscopo.presentacion.signos

import com.istea.mihoroscopo.repository.Signo

sealed class SignosEstado {
    data object Vacio: SignosEstado()
    data object Cargando: SignosEstado()
    data class Resultado( val signos : List<Signo> ) :SignosEstado()
    data class Error(val mensaje: String): SignosEstado()
}