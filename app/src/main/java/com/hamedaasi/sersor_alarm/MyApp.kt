package com.hamedaasi.sersor_alarm

import android.app.Application
import android.hardware.SensorManager
import androidx.lifecycle.ProcessLifecycleOwner
import timber.log.Timber

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

//        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
//        ProcessLifecycleOwner
//            .get()
//            .lifecycle
//            .addObserver(SensorHandler(sensorManager))

    }
}