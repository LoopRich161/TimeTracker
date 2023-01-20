package ru.looprich.timetracker.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    navigateToProjects : () -> Unit
)
{
    val mContext = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val login = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        var passwordVisible = remember { mutableStateOf(false) }


        OutlinedTextField(value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "Логин") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Пароль") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val description = if(passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = Icons.Filled.Lock, description)
                }
            })

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
                if(login.value.isEmpty() or password.value.isEmpty())
                {
                    Toast.makeText(mContext, "Заполните логин или пароль", Toast.LENGTH_SHORT).show()
                }
                if(login.value.isNotEmpty() and password.value.isNotEmpty())
                {
                    if((login.value == "test") and (password.value == "test"))
                    {
                        Toast.makeText(mContext, "Вход...", Toast.LENGTH_SHORT).show()
                        navigateToProjects()
                    } else
                    {
                        Toast.makeText(mContext, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        ) {
            Text("Вход", color = Color.White)
        }
    }
}
