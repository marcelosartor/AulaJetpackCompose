package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import br.com.msartor.aulajetpackcompose.data.remote.model.Destaque
import coil3.compose.AsyncImage

@Composable
fun ItemDestaque(destaque: Destaque, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = destaque.imagemPerfilUrl,
            contentDescription = destaque.nome,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.LightGray, CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = destaque.nome,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemDestaquePreview() {
    ItemDestaque(Destaque(id = 1, nome = "Fulano", imagemPerfilUrl = ""))
}
