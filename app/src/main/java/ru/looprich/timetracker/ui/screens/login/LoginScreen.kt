package ru.looprich.timetracker.ui.screens.login

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.looprich.timetracker.App
import ru.looprich.timetracker.R
import ru.looprich.timetracker.ui.theme.colorGreen600
import ru.looprich.timetracker.ui.theme.colorWhite

@Composable
fun LoginScreen(
    app: App,
    navigateToProjects: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(stringResource(R.string.appName), color = colorGreen600)

        Spacer(
            modifier = Modifier.height(100.dp)
        )

        val login = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = stringResource(R.string.loginHint)) })

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = stringResource(R.string.passwordHint)) },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val description = if (passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = Icons.Filled.Lock, description)
                }
            })


        Spacer(
            modifier = Modifier.height(100.dp)
        )

        Button(
            onClick = {
                authentication(
                    app = app,
                    login = login.value,
                    password = password.value,
                    context = context,
                    successfulAction = navigateToProjects
                )
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorGreen600),
        ) {
            Text(stringResource(R.string.loginButtonText), color = colorWhite)
        }
    }
}

fun authentication(
    app: App,
    login: String,
    password: String,
    context: Context,
    successfulAction: () -> Unit
) {
    if (login.isEmpty() or password.isEmpty()) {
        Toast.makeText(
            context,
            context.getString(R.string.fieldsNotFilledAlert),
            Toast.LENGTH_SHORT
        ).show()
    }

    if (login.isNotEmpty() and password.isNotEmpty()) {
        app.userRepo?.get(login, password)?.let {
            Toast.makeText(
                context,
                context.getString(R.string.successfulLogin),
                Toast.LENGTH_SHORT
            ).show()
            successfulAction()
        } ?: run {
            Toast.makeText(
                context,
                context.getString(R.string.wrongLoginOrPassword),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
