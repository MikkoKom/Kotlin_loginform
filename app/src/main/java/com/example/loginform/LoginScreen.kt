package com.example.loginui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF6200EE)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Username field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
                keyboardType = androidx.compose.ui.text.input.KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Lock // This can be an eye icon
                else Icons.Filled.Lock

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                }
            },
            keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
                keyboardType = androidx.compose.ui.text.input.KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button
        Button(
            onClick = { /* No action required as per instruction */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Submit", color = Color.White)
        }
    }
}