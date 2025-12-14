package com.example.gardenplanner.utils.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gardenplanner.BuildConfig
import com.example.gardenplanner.navigation.Popup
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.google.gson.JsonElement

class GardenAdiveViewModel : ViewModel() {

    private val gson = Gson()
    fun fetchGardenAdvice(q: String, setPopup: (Popup) -> Unit, setPlant: (Plant?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPlantInfo(
                    q,
                    1,
                    apiKey = BuildConfig.RAPID_API_KEY,
                    host = BuildConfig.RAPID_API_HOST)

                val data = gson.fromJson(
                    response.asJsonObject.getAsJsonArray("data"),
                    Array<Plant>::class.java
                )
                val plant = data.firstOrNull()
                if (plant != null) {
                    setPlant(plant)
                    Log.d("Advice", plant.toString())
                }

                setPopup(Popup.CameraConfirm)
            } catch (e: Exception) {
                Log.d("Error", "Error: ${e.message}")
                setPlant(null)
                setPopup(Popup.CameraConfirm)
            }
        }
    }
}