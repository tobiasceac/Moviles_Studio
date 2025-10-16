package com.tobiascen.movilesstudio.Login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tobiascen.movilesstudio.ui.theme.MovilesStudioTheme

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovilesStudioTheme {

            }
        }
    }
}

fun Login() {

}

