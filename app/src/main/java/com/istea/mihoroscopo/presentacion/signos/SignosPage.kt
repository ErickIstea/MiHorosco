package com.istea.mihoroscopo.presentacion.signos

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.mihoroscopo.repository.Repository
import com.istea.mihoroscopo.router.Router

@Composable
fun SignosPage(
    navHostController: NavHostController
) {
    val viewModel : SignosViewModel = viewModel(
        factory = SignosViewModelFactory(
            repositorio = Repository(),
            router = Router(navHostController)
        )
    )
    SignosView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}
