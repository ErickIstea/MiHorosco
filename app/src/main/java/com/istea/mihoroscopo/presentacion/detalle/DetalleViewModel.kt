package com.istea.mihoroscopo.presentacion.detalle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.mihoroscopo.presentacion.signos.SignosEstado
import com.istea.mihoroscopo.repository.Repository
import com.istea.mihoroscopo.router.Router
import kotlinx.coroutines.launch

class DetalleViewModel(
    val repositorio: Repository,
    val router: Router,
    val signoid: String
) : ViewModel() {

    var uiState by mutableStateOf<DetalleEstado>(DetalleEstado.Vacio)

    fun ejecutar(intencion: DetalleIntencion) {
        when(intencion){
            is DetalleIntencion.IrParaAtras -> irParaAtras()
            is DetalleIntencion.CargarContenido -> cargarContenido()
        }
    }

    private fun irParaAtras(){
        router.back()
    }

    private fun cargarContenido(){
        uiState = DetalleEstado.Cargando
        viewModelScope.launch {
            try {
                val horoscopo = repositorio.getHoroscopo(signoId = signoid)
                uiState = DetalleEstado.Resultado(horoscopo = horoscopo)
            } catch (e: Exception) {
                uiState = DetalleEstado.Error(mensaje = "Error al cargar el contenido")
            }
        }
    }
}


class DetalleViewModelFactory(
    private val repositorio: Repository,
    private val router: Router,
    private val signoid: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalleViewModel::class.java)) {
            return DetalleViewModel(repositorio,router,signoid) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}