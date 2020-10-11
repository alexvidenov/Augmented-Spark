package com.example.miditeslacoilapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miditeslacoilapp.BluetoothApplication
import com.example.miditeslacoilapp.R
import com.example.miditeslacoilapp.Utils.isConnected
import com.jakewharton.rx.ReplayingShare
import com.polidea.rxandroidble2.RxBleConnection
import com.polidea.rxandroidble2.RxBleDevice
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.*

//private const val EXTRA_MAC_ADDRESS = "extra_mac_address"

/*
class DeviceActivity : AppCompatActivity() {
    private lateinit var connectButton: Button
    private lateinit var discoverButton: Button

    private lateinit var macAddress: String

    private lateinit var bleDevice: RxBleDevice

    private val disconnectTriggerSubject = PublishSubject.create<Unit>()

    private lateinit var connectionObservable: Observable<RxBleConnection>

    private val connectionDisposable = CompositeDisposable()

    private lateinit var characteristicUuid: UUID

    companion object {
        fun newInstance(context: Context, macAddress: String): Intent =
                Intent(context, DeviceActivity::class.java).apply { putExtra(EXTRA_MAC_ADDRESS, macAddress) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)

        macAddress = intent.getStringExtra(EXTRA_MAC_ADDRESS)!! // connect  automatically  after  coming  in here

        characteristicUuid = UUID.fromString(CHARACTERISTIC_UUID)
        bleDevice = BluetoothApplication.rxBleClient.getBleDevice(macAddress)

        connectionObservable = prepareConnectionObservable()

        connectButton = findViewById(R.id.connect_to_device)

        connectButton.setOnClickListener {
            onConnectToggleClick()
        }

        discoverButton = findViewById(R.id.discovery)

        setupNotifications()

        discoverButton.setOnClickListener {
            write("1")
        }
    }

    private fun write(data: String) {
        if (bleDevice.isConnected) {
            connectionObservable
                    .firstOrError()
                    .flatMap {
                        it.writeCharacteristic(UUID.fromString(CHARACTERISTIC_UUID), data.toByteArray())
                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(this, "WROTE TEXT", Toast.LENGTH_SHORT).show()
                    }, { print("WE DID NOT WRITE SOME EPIC SHIT BOY") })
                    .let { connectionDisposable.add(it) }
        }
    }

    private fun setupNotifications() {
        if (bleDevice.isConnected) {
            connectionObservable
                    .flatMap { it.setupNotification(characteristicUuid) }
                    .flatMap { it }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
                    .let { connectionDisposable.add(it) }
        }
    }

    override fun onPause() {
        super.onPause()
        connectionDisposable.clear()
    }

    private fun updateUI() {
        connectButton.isEnabled = !bleDevice.isConnected
    }
}
*/