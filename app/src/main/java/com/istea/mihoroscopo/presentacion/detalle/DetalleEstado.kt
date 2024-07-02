package com.istea.mihoroscopo.presentacion.detalle

import com.istea.mihoroscopo.repository.Horoscopo

sealed class DetalleEstado {
    data object Vacio: DetalleEstado()
    data object Cargando: DetalleEstado()
    data class Resultado( val horoscopo : Horoscopo) :DetalleEstado()
    data class Error(val mensaje: String): DetalleEstado()
}