package com.example.patryk.lecturestickyintent

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var br1:BroadcastFirst
    lateinit var br2:BroadcastSec
    lateinit var filter:IntentFilter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_sendStickyIntent1).setOnClickListener {
            var intent= Intent("com.example.PAM_sticky")
            intent.putExtra("pole","1")
            sendStickyBroadcast(intent)
            var recIntent:Intent? =registerReceiver(null,filter)
        }

        findViewById<Button>(R.id.button_sendStickyIntent2).setOnClickListener {
            var intent= Intent("com.example.PAM_sticky")
            intent.putExtra("pole","2")
            sendStickyBroadcast(intent)
            var recIntent:Intent? =registerReceiver(null,filter)
        }
        findViewById<Button>(R.id.button_lastRec).setOnClickListener {

            var recIntent:Intent? =registerReceiver(null,filter)
            try {
                Toast.makeText(this, "odebrane dane to: ${recIntent?.getStringExtra("pole")}", Toast.LENGTH_SHORT)
                    .show()
            }
            catch (e:Exception){}
        }

    }

    override fun onResume() {
        super.onResume()
        filter = IntentFilter("com.example.PAM_sticky")
        //br1 = BroadcastFirst()
        br2 = BroadcastSec()
        //registerReceiver(br1, filter)
        registerReceiver(br2, filter)

    }

    override fun onPause() {
        //unregisterReceiver(br1)
        unregisterReceiver(br2)
        super.onPause()
    }
}
