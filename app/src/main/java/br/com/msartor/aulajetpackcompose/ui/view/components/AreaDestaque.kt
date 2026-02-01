package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import br.com.msartor.aulajetpackcompose.data.remore.dto.User

@Composable
fun AreaDestaque(listaUsuarios:List<User>, modifier: Modifier = Modifier,){
    LazyRow(
        modifier = modifier,
    ){
        items(listaUsuarios){ usuario ->
            //Text(text = destaque.nome)
            ItemDestaque(usuario = usuario)
        }
    }
}