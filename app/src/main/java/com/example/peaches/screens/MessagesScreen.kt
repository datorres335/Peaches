package com.example.peaches.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
fun MessagesScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        //debug code Card
        Card (
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(100.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Green)
        ) {
            Spacer(modifier = Modifier.height(320.dp))
            Text(
                text = "Messages Screen",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 45.sp,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessagesScreenPreview(){
    MessagesScreen()
}