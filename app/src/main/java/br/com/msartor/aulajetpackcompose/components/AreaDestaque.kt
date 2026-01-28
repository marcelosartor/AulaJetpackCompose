package br.com.msartor.aulajetpackcompose.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.model.Destaque

@Composable
fun AreaDestaque(listaDestaques: List<Destaque>, modifier: Modifier = Modifier,){
    LazyRow(
        modifier = modifier,
    ){
        items(listaDestaques){ destaque ->
            //Text(text = destaque.nome)
            ItemDestaque(destaque = destaque)
        }
    }
}