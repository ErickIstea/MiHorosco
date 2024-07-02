package com.istea.mihoroscopo.presentacion.signos

import com.istea.mihoroscopo.repository.Signo

sealed class SignosIntencion {
    object CargarLista : SignosIntencion()
    data class Seleccionar(val signo: Signo) : SignosIntencion()
}

