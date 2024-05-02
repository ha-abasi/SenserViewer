package com.hamedaasi.sersor_alarm

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

// we inherit from DefaultLifecycleObserver to get onStart and onStop

// inorder to get sensor events we need to call SensorManager.register
// and pass in the SensorEventListener and the sensor type
// we also implement SensorEventListener to get onSensorChanged and onAccuracyChanged
class SensorHandler(val sensorManager: SensorManager) : DefaultLifecycleObserver,
    SensorEventListener {
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ALL),
            SensorManager.SENSOR_DELAY_NORMAL)

        Timber.i("sensorManager registered")

    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        sensorManager.unregisterListener(this)
        Timber.i("sensorManager unregistered")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val type = event?.sensor?.stringType

        // check if sensor is ACCELEROMETER :
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

            val x = event.values?.get(0)
            val y = event.values?.get(1)
            val z = event.values?.get(2)

//            Timber.i("Sensor is ACCELEROMETER And x is $x, y is $y, z is $z")

        }else{
            Timber.i("onSensorChanged, Type is '$type'")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Timber.i("onAccuracyChanged")
    }
}