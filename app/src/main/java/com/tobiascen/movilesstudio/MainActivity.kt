package com.tobiascen.movilesstudio


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tobiascen.movilesstudio.ui.theme.MovilesStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovilesStudioTheme {
                Password()
            }
        }
    }
}

@Composable
fun Counter() {


    var counterA by rememberSaveable { mutableStateOf(0) }
    var counterB by rememberSaveable { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //  Texto A
            Text("Clics boton A: $counterA veces")
            Spacer(modifier = Modifier.height(16.dp))
            // Texto B
            Text("Clics boton B: $counterB veces")
            Spacer(modifier = Modifier.height(16.dp))

            // Botones A y B
            Row (
                modifier = Modifier.padding(10.dp)
            ){
                Button(
                onClick = { counterA++ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("Boton A")
            }
                Spacer(modifier = Modifier.width(32.dp))

                Button(
                    onClick = { counterB++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))

                ) {
                    Text("Boton B")
                }
            }

            //Boton Reset
            Button(
                onClick = {
                    counterA = 0
                    counterB = 0
                          },
                modifier = Modifier.size(width = 180.dp, height = 90.dp).padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3A3A))
            ) {
                Text("Reset",
                    fontSize = 20.sp)
            }


        }
    }
}

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
                //Icon(
                //   painter = painterResource(android.R.drawable.ic_partial_secure)
                //)
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun ejemplo(){
    Box(modifier = Modifier.fillMaxSize()
        .background(color = Color.Red)
    ){
        Column (modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.5f)
            , verticalArrangement = Arrangement.SpaceAround
        ) {
            Row (modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth()

            ){
                Text(text = "Hola")
                Box(modifier = Modifier
                    .background(color = Color.Yellow)
                    .width(100.dp)
                    .height(50.dp)
                    .padding(10.dp)
                    .clickable{
                        //Cuando se hace click sale por consola esto
                        Log.d("Control", "Se ha hecho click")
                    }
                ){
                    Text(text="Click", color = Color.Black)
                }
            }
        }
    }
}

