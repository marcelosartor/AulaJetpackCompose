package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.data.remote.model.Postagem
import coil3.compose.AsyncImage

@Composable
fun ItemPostagem(postagem: Postagem, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp),
        ) {
            AsyncImage(
                model = postagem.imagemPerfilUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray, CircleShape),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = postagem.nome,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.titleMedium,
            )
        }
        AsyncImage(
            model = postagem.fotoUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = postagem.descricao,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPostagemPreview() {
    ItemPostagem(
        Postagem(
            id = 1,
            nome = "Fulano",
            imagemPerfilUrl = "",
            fotoUrl = "",
            descricao = "Uma descrição qualquer",
        )
    )
}
