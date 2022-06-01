package com.example.android.treasureHunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SetLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_location)



        findViewById<MaterialButton>(R.id.startHuntButton).setOnClickListener {
            val latitude1 = findViewById<TextInputEditText>(R.id.latitudeOneText).text.toString()
            val longitude1 = findViewById<TextInputEditText>(R.id.longitudeOneText).text.toString()
            val latitude2 = findViewById<TextInputEditText>(R.id.latitudeTwoText).text.toString()
            val longitude2 = findViewById<TextInputEditText>(R.id.longitudeTwoText).text.toString()
            val latitude3 = findViewById<TextInputEditText>(R.id.latitudeThreeText).text.toString()
            val longitude3 = findViewById<TextInputEditText>(R.id.longitudeThreeText).text.toString()

            if(latitude1.isEmpty() || longitude1.isEmpty() || latitude2.isEmpty()
                || longitude2.isEmpty() || latitude3.isEmpty() || longitude3.isEmpty()) {
                Toast.makeText(this, "Please, fill in the necessary information", Toast.LENGTH_LONG)
                    .show()
            } else {
                GeofencingConstants.LANDMARK_DATA[0].latLong = LatLng(latitude1.toDouble(), longitude1.toDouble())
                GeofencingConstants.LANDMARK_DATA[1].latLong = LatLng(latitude2.toDouble(), longitude2.toDouble())
                GeofencingConstants.LANDMARK_DATA[2].latLong = LatLng(latitude3.toDouble(), longitude3.toDouble())
                val intent = Intent(this, HuntMainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}