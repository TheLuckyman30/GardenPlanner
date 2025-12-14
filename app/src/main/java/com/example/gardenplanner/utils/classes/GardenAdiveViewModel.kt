package com.example.gardenplanner.utils.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gardenplanner.BuildConfig
import com.example.gardenplanner.navigation.Popup
import kotlinx.coroutines.launch

class GardenAdiveViewModel : ViewModel() {
    fun fetchGardenAdvice(q: String, setPopup: (Popup) -> Unit, setPlant: (Plant?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPlantInfo(
                    q,
                    1,
                    apiKey = BuildConfig.RAPID_API_KEY,
                    host = BuildConfig.RAPID_API_HOST)

                setPlant(response.data[0])
                Log.d("Error", response.data[0].toString())
                setPopup(Popup.CameraConfirm)
            } catch (e: Exception) {
                Log.d("Error", "Error: ${e.message}")
                setPlant(null)
                setPopup(Popup.CameraConfirm)
            }
        }
    }
}