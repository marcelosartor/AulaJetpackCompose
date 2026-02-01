package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.data.remore.model.Postagem

@Composable
fun AreaPostagem(listaPostagem: List<Postagem>, modifier: Modifier = Modifier,){
    LazyColumn(
        modifier = modifier,
    ){
        items(listaPostagem){ postagem ->
            //Text(text = destaque.nome)
            ItemPostagem(postagem = postagem)
        }
    }
}