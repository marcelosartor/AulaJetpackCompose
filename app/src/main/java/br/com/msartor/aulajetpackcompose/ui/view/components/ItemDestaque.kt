package br.com.msartor.aulajetpackcompose.ui.view.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.msartor.aulajetpackcompose.R
import br.com.msartor.aulajetpackcompose.data.remore.dto.User
import br.com.msartor.aulajetpackcompose.data.remore.model.Destaque
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ItemDestaque(usuario: User, modifier: Modifier = Modifier) {
    Column(
        modifier= modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        Image(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape),
            painter = painterResource(id = usuario.imagemPerfilRes), contentDescription = null,
            contentScale = ContentScale.Crop
        )
         */

        AsyncImage(

            model = ImageRequest.Builder(LocalContext.current)
                .data(usuario.image)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .background(Color.LightGray, CircleShape)
                .size(56.dp)
                .clip(CircleShape),
            //painter = painterResource(id = usuario.imagemPerfilRes), contentDescription = null,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            text = usuario.firstName,
            style = MaterialTheme.typography.titleMedium
         )
    }
}

/*
@Preview()
@Composable
fun PreviewItemDestaque(){
    val usuario = User(firstName = "fulano")
    ItemDestaque(usuario)
}
*/




