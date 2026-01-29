package br.com.msartor.aulajetpackcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.R
import br.com.msartor.aulajetpackcompose.model.Destaque
import br.com.msartor.aulajetpackcompose.model.Postagem

@Composable
fun ItemPostagem(postagem: Postagem, modifier: Modifier = Modifier) {
    Column(

    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),

                painter = painterResource(id = postagem.imagemPerfilRes), contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = postagem.nome,
                modifier = Modifier.padding(start=8.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Image(
            modifier = Modifier
                  .fillMaxWidth(),
            painter = painterResource(id = postagem.fotoRes), contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = postagem.descricao,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview()
@Composable
fun  PreviewItemPostagem(){
    ItemPostagem(Postagem(imagemPerfilRes = R.drawable.perfil_01, nome = "Fulano", fotoRes = R.drawable.carro, descricao = "Uma descrição qualquer"))
}