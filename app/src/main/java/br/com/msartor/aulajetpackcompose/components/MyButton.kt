package br.com.msartor.aulajetpackcompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyButton(
    text: String,
     onClick: ()-> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
        ){
        Text(text = "+ ")
        Text(text = text)
        Text(text = " +")
    }
}
