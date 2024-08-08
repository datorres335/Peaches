package com.example.peaches.googleMapsApi

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.peaches.MainActivity
import com.example.peaches.R

@Composable
fun GetLocation(
    locationUtils: LocationUtils,
    context: Context,
    dynamicColors: ColorScheme,
    locationViewModel: LocationViewModel
){
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            permissions ->
            if(permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true){
                // already have access to user's location
                locationUtils.requestSingleLocation(locationViewModel = locationViewModel)
            }
            else {
                // ask for permission to get user's location
                //"shouldShowRequestPermissionRationale" displays why we are requesting for permission
                val rationalRequired = ActivityCompat.shouldShowRequestPermissionRationale(context as MainActivity, Manifest.permission.ACCESS_FINE_LOCATION) // "as MainActivity" might be wrong

                if(rationalRequired) {
                    Toast.makeText(context, "Location Permission Denied", Toast.LENGTH_LONG).show()
                }
                else{
                    //if the user previously denied access to their location, they would have to manually change the settings on their own on their device
                    Toast.makeText(context, "Location Permission Denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    )
    Button(
        onClick = {
            if(locationUtils.hasLocationPermission(context)) {
                // Permission already granted update the location
                // TODO *************************************************************************************************
            }
            else {
                // Request location permission
                requestPermissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION))
            }
        },
        modifier = Modifier.width(40.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonColors(containerColor = dynamicColors.surfaceContainerLowest, contentColor = dynamicColors.onSurface, disabledContainerColor = Color.Gray, disabledContentColor = Color.DarkGray)
    ) {
        Icon(painter = painterResource(id = R.drawable.baseline_location_searching_24), contentDescription = null)
    }
}

@Preview
@Composable
fun GetLocationPreview(){
    val locationViewModel: LocationViewModel = viewModel()
    GetLocation(
        locationUtils = LocationUtils(LocalContext.current),
        context = LocalContext.current,
        dynamicColors = dynamicDarkColorScheme(LocalContext.current),
        locationViewModel = locationViewModel
    )
}