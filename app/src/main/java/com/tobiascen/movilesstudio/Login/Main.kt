package com.tobiascen.movilesstudio.Login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.tobiascen.movilesstudio.ui.theme.MovilesStudioTheme

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovilesStudioTheme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    Password()
}
@Preview
@Composable
fun Password(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var password by rememberSaveable { mutableStateOf("") }
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña")},
            placeholder = { Text("Introduce tu contraseña") },
            leadingIcon = {
                Icon(
                    painter = painterResource(android.R.drawable.ic_secure),
                    contentDescription = "Contraseña"
                )
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
