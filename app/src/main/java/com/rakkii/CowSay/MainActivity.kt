package com.rakkii.CowSay

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // Oculta a TopBar
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffC0D6DF))
            ) {
                MyApp {
                    CowSayScreen()
                }
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(),
        typography = Typography()
    ) {
        content()
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun CowSayScreen() {
    var name by remember { mutableStateOf("") }
    var nameIt by remember { mutableStateOf("") }
    val textFieldColors = outlinedTextFieldColors(
        focusedBorderColor = Color.Blue, // cor da linha quando o campo está em foco
        unfocusedBorderColor = Color(0xff546A7B), // cor da linha quando o campo não está em foco
        textColor = Color.Black, // cor do texto do campo
        cursorColor = Color.LightGray, // cor do cursor do campo
    )
    var isNameEnabled by remember { mutableStateOf(true)}
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameIt,
            onValueChange = { nameIt = it },
            label = { Text("Digite um nome",
                style = TextStyle(color = Color(0xff0D1F2D)))},
            colors = textFieldColors, // definir as cores personalizadas
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            enabled = isNameEnabled
        )
        Button(
            onClick = {
                nameIt = nameIt.capitalize()
                keyboardController?.hide() // esconder o teclado
                name = nameIt
                nameIt = ""
                isNameEnabled = false
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Yah")
        }
        Spacer(modifier = Modifier.height(16.dp))
        CowSay(name = name)
        if(!isNameEnabled){
            isNameEnabled = true
        }
    }
}