package com.example.unitrackerv12.Mng

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unitrackerv12.MapsActivity
import com.example.unitrackerv12.R
import kotlinx.android.synthetic.main.activity_mngtracking.*

class MngTracking:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mngtracking)

        //btnmngAccount1.isEnabled = false
        btnmngAccount2.setOnClickListener {
            val intent = Intent(this, MngAccount::class.java)
            startActivity(intent)
            finish()
        }

        btnMapa2.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnmngTracking2.isEnabled = false
        /*btnmngTracking1.setOnClickListener {
            val intent = Intent(this, ::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}