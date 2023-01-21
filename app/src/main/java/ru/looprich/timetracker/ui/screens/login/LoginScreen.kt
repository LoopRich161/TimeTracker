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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.looprich.timetracker.R
import ru.looprich.timetracker.ui.theme.*

@Composable
fun LoginScreen(
    navigateToProjects: () -> Unit
) {
    val mContext = LocalContext.current

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
            onClick = { authentication(login.value, password.value, mContext, navigateToProjects) },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorGreen600),
        ) {
            Text(stringResource(R.string.loginButtonText), color = colorWhite)
        }
    }
}

fun authentication(
    login: String,
    password: String,
    mContext: Context,
    successfulAction: () -> Unit
) {
    if (login.isEmpty() or password.isEmpty()) {
        Toast.makeText(
            mContext,
            mContext.getString(R.string.fieldsNotFilledAlert),
            Toast.LENGTH_SHORT
        ).show()
    }
    if (login.isNotEmpty() and password.isNotEmpty()) {
        if ((login == "test") and (password == "test")) {
            Toast.makeText(
                mContext,
                mContext.getString(R.string.successfulLogin),
                Toast.LENGTH_SHORT
            ).show()
            successfulAction()
        } else {
            Toast.makeText(
                mContext,
                mContext.getString(R.string.wrongLoginOrPassword),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen { }
}
