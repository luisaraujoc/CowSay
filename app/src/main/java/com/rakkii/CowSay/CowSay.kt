package com.rakkii.CowSay

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CowSay(name: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, $name!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(0.2.dp))
        CowImage()

    }
}

@Composable
private fun CowImage() {
    Text(
        """
       ___________________     
        \   ^__^
         \  (oo)\_____
            (__)\-------)\/\
                ||----w |
                ||     ||
    """.trimIndent(),
        color = Color.Black,
        style = MaterialTheme.typography.h4
    )
}