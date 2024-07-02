package com.istea.mihoroscopo.presentacion.detalle

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.mihoroscopo.repository.Repository
import com.istea.mihoroscopo.router.Router

@Composable
fun DetallePage(
    navHostController: NavHostController,
    signoid: String
) {
    val viewModel : DetalleViewModel = viewModel(
        factory = DetalleViewModelFactory(
            repositorio = Repository(),
            router = Router(navHostController),
            signoid = signoid
        )
    )
    DetalleView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}
