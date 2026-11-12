package br.com.msartor.aulajetpackcompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import br.com.msartor.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme
import br.com.msartor.aulajetpackcompose.viewmodel.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstagramScaffoldActivity : ComponentActivity() {

    private val feedViewModel: FeedViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        feedViewModel.carregarFeed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaJetpackComposeTheme {
                HomeRoute(viewModel = feedViewModel)
            }
        }
    }
}
