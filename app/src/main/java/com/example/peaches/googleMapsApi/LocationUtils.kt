package com.example.peaches.googleMapsApi

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource

//This class is a helper class to help us determine whether the user has granted us the permission to access their location
class LocationUtils(val context: Context) {
    private val _fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    val _cancellationTokenSource = CancellationTokenSource()

    // EXPERIMENTAL CODE UNDERNEATH, MEANT TO GET USER LOCATION EXACTLY ONCE
    fun requestSingleLocation(locationViewModel: LocationViewModel) {
        _fusedLocationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            _cancellationTokenSource.token
        ).addOnSuccessListener { location ->
            if (location != null) {
                // Handle the location object
                //println("Location: ${location.latitude}, ${location.longitude}")
                // TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                val latLon = LocationData(location.latitude, location.longitude)
                locationViewModel.updateLocation(latLon)
            } else {
                // Handle the case where location is null
                //println("Location is null")
                Toast.makeText(context, "Failed to get location", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener { exception ->
            // Handle the exception
            //println("Failed to get location: ${exception.message}")
            Toast.makeText(context, "Failed to get location", Toast.LENGTH_LONG).show()
        }
    }

    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }
}