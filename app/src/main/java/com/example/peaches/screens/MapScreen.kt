package com.example.peaches.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.peaches.googleMapsApi.GetLocation
import com.example.peaches.googleMapsApi.LocationUtils

@Composable
fun MapScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        //debug code Card
        Card (
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(100.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Blue)
        ) {
            Spacer(modifier = Modifier.height(320.dp))
            Text(text = "Map Screen", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 60.sp)
            Row (modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 15.dp)){
                GetLocation(locationUtils = LocationUtils(LocalContext.current), context = LocalContext.current)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview(){
    MapScreen()
}