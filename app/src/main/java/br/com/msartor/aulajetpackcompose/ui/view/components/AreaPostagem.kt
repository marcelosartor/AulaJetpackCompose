package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem

@Composable
fun AreaPostagem(listaPostagens: List<Postagem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(listaPostagens) { postagem ->
            ItemPostagem(postagem = postagem)
        }
    }
}
