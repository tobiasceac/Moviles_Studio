package com.tobiascen.movilesstudio


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreen(){
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(  // ← Column PADRE
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                color = Color(0xFF4A5FDB),  // Azul
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¡Te echábamos de menos!",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {


            EmailField(
                value = email,
                onValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))

            PasswordField(
                value = password,
                onValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextButton(
                onClick = { /* Acción */ },
                modifier = Modifier
                    .align(Alignment.End),
            ){
                Text(

                    text = "¿Olvidaste tu contraseña?",
                    color = Color(0xFF4A5FDB),
                    fontWeight = FontWeight.SemiBold

                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LoginButton(
                onClick = {
                    password = ""
                    email = ""
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Crea una cuenta nueva",
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier.weight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier,
                color = Color(0xFF4A5FDB),
                text = "O continua con"

            )
            Row(){
                LoginNext(R.drawable.ic_google)
                LoginNext(R.drawable.ic_facebook)
                LoginNext(R.drawable.ic_apple)
            }
        }
    }
}



@Composable
fun EmailField(
    value: String,
    onValueChange: (String) -> Unit
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Email")},
        placeholder = { Text("Introduce tu Email") },
        leadingIcon = {
            Icon(
                painter = painterResource(android.R.drawable.sym_action_email),
                contentDescription = "Email"
            )
        },
        singleLine = true,
    )
}

@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit){
    TextField(
        value = value,
        onValueChange = onValueChange,
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

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4A5FDB),  // ← Color de fondo
        )
    ) {
        Text("Iniciar Sesión")
    }
}

@Composable
fun LoginNext(
    icon: Int
    ){
    Button(
        onClick = {},
        modifier = Modifier
            .width(85.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x52A3A3AF),  // ← Color de fondo
        )

    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(29.dp),
            tint = Color.Unspecified
        )
    }
}

