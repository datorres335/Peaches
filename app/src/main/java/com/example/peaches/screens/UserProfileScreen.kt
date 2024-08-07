package com.example.peaches.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        //debug code Card
        Card (
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color.Red)
        ) {
            Spacer(modifier = Modifier.height(320.dp))
            Text(
                text = "User Profile Screen",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 40.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview(){
    UserProfileScreen()
}