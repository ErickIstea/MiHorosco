package com.istea.mihoroscopo.presentacion.signos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.istea.mihoroscopo.repository.Signo
import kotlin.math.sign


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignosView (
    modifier: Modifier = Modifier,
    state : SignosEstado,
    onAction: (SignosIntencion)->Unit
) {

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(SignosIntencion.CargarLista)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.secondary
                ),
                title = { Text(text = "Signos") }
            )
        }
    ) {
        Column(modifier = modifier.padding(it)) {
            when(state) {
                SignosEstado.Cargando -> Text("...")
                is SignosEstado.Error -> Text(text = state.mensaje)
                is SignosEstado.Resultado -> ListaDeSignosView(state.signos) {
                    onAction(
                        SignosIntencion.Seleccionar(it)
                    )
                }
                SignosEstado.Vacio -> Text(text = "No hay signos")
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeSignosView(signos: List<Signo>, onSelect: (Signo)->Unit){
    LazyColumn {
        items(items = signos) {signo ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.secondary,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                onClick = {
                    onSelect(signo)
                }
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painterResource(signo.iconId),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp)
                            .padding(10.dp),
                    )
                    Column {
                        Row (
                            verticalAlignment = Alignment.Bottom
                        ){
                            Text(
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.titleMedium,
                                text = signo.nombre
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.titleSmall,
                                text = signo.desde + " al " + signo.hasta
                            )
                        }
                        Text(
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            text = signo.descripcion
                        )
                    }
                }

            }
        }
    }
}
