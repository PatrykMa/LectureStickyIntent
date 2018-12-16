package com.example.patryk.lecturestickyintent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast

class BroadcastFirst:  BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


        Toast.makeText(context,"wartośc pola w pierwszym to ${intent?.getStringExtra("pole")}",Toast.LENGTH_SHORT).show()
        intent?.removeExtra("pole")
        intent?.putExtra("pole","12")
        return
    }
}

class BroadcastSec: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var lastIntent=context?.registerReceiver(null, IntentFilter( intent?.action))

        Toast.makeText(context,"wartośc pola w poprzednim użyciu to ${lastIntent?.getStringExtra("pole")}",Toast.LENGTH_SHORT).show()
        intent?.removeExtra("pole")
        intent?.putExtra("pole","12")
    }
}