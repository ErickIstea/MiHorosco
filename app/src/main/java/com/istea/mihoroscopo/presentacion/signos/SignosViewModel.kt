package com.istea.mihoroscopo.presentacion.signos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.mihoroscopo.presentacion.detalle.DetalleEstado
import com.istea.mihoroscopo.presentacion.detalle.DetalleIntencion
import com.istea.mihoroscopo.presentacion.detalle.DetalleViewModel
import com.istea.mihoroscopo.repository.Repository
import com.istea.mihoroscopo.repository.Signo
import com.istea.mihoroscopo.router.Router
import com.istea.mihoroscopo.router.Ruta
import kotlinx.coroutines.launch

class SignosViewModel(
    val repositorio: Repository,
    val router: Router
) : ViewModel() {

    var uiState by mutableStateOf<SignosEstado>(SignosEstado.Vacio)

    fun ejecutar(intencion: SignosIntencion) {
        when(intencion){
            is SignosIntencion.CargarLista -> cargarLista()
            is SignosIntencion.Seleccionar -> seleccionar(signo = intencion.signo)
        }
    }

    private fun cargarLista(){
        uiState = SignosEstado.Cargando
        viewModelScope.launch {
            val signos = repositorio.getSignos()
            uiState = SignosEstado.Resultado(signos)
        }
    }

    private fun seleccionar(signo: Signo){
        router.navegar(Ruta.Detalle(signo))
    }
}

class SignosViewModelFactory(
    private val repositorio: Repository,
    private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignosViewModel::class.java)) {
            return SignosViewModel(repositorio,router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}