package com.example.gardenplanner.utils.classes

import java.time.ZonedDateTime

data class Notification (
    val plant: Plant?,
    val name: String,
    val nextDate: ZonedDateTime,
    val interval: Long?,
)