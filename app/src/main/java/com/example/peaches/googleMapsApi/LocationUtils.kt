package com.example.peaches.googleMapsApi

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

//This class is a helper class to help us determine whether the user has granted us the permission to access their location
class LocationUtils(val context: Context) {
    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }
}