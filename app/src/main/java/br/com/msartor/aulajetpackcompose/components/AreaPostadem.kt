package br.com.msartor.aulajetpackcompose.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.model.Destaque
import br.com.msartor.aulajetpackcompose.model.Postagem

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