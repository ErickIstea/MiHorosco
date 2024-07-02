package com.istea.mihoroscopo.presentacion.detalle

sealed class DetalleIntencion {
    object IrParaAtras : DetalleIntencion()
    object CargarContenido: DetalleIntencion()
}

