package com.istea.mihoroscopo.repository

import androidx.annotation.DrawableRes

data class Signo (
    val signoId: String,
    val nombre: String,
    val descripcion: String,
    val desde: String,
    val hasta: String,
    @DrawableRes val iconId : Int,
    @DrawableRes val ilustrationId : Int
)

data class Horoscopo (
    val signo: Signo,
    val fecha: String,
    val amor: String,
    val riqueza: String,
    val bienestar: String,
)