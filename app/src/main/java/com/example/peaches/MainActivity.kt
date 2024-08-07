package com.example.peaches // NEED TO CHOOSE A MEANINGFUL & UNIQUE PACKAGE NAME. //com.COMPANY_NAME.peaches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.peaches.screens.MainScaffold
import com.example.peaches.ui.theme.PeachesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false) // TEST CODE
        enableEdgeToEdge()
        setContent {
            PeachesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MainScaffold()
                }
            }
        }
    }
}
