package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque

@Composable
fun AreaDestaque(listaDestaques: List<Destaque>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(listaDestaques, key = { it.id }) { destaque ->
            ItemDestaque(destaque = destaque)
        }
    }
}
