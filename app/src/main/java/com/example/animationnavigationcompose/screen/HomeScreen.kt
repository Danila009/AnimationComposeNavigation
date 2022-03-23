package com.example.animationnavigationcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = Icons.Default.Home,
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .size(300.dp)
        )

        TextButton(onClick = { navController.navigate("profile") }) {
            Text(text = "Profile =>")
        }
    }
}