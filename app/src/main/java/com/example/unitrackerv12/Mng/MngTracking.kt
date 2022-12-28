package com.example.unitrackerv12.Mng

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.unitrackerv12.*
import kotlinx.android.synthetic.main.activity_mngtracking.*

var DEBUG_TAG = "LIST_USERS"

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

        // list users in "userlist" ListView

        var groupid = "amigos"; // ver como leer el group id de la otra vista (el mapa)
        // var groupid =
        var doc = GroupManager.collection.document(groupid)
        doc.get()
            .addOnSuccessListener { documentSnapshot ->
                var data = documentSnapshot.toObject(GroupData::class.java)
                Log.d(DEBUG_TAG, "Group ${groupid}: ${data}")

                // IDS of users
                var users = mutableListOf<String>();
                data!!.users?.forEach { userid ->
                    // get name of userid
                    var userData: UserData? = null
                    UserManagerV.collection.document(userid).get()
                        .addOnSuccessListener{ documentSnapshot ->
                            userData = documentSnapshot.toObject(UserData::class.java)
                            userData?.username?.let { users.add(it) }
                            Log.d(DEBUG_TAG, "username ${userData?.username}, users: ${users}")

                            // access the listView from xml file
                            val arrayAdapter: ArrayAdapter<*>
                            var mListView = findViewById<ListView>(R.id.userlist)
                            arrayAdapter = ArrayAdapter(this,
                                android.R.layout.simple_list_item_1, users)
                            mListView.adapter = arrayAdapter
                        }
                }

                Log.d(DEBUG_TAG, "[AFTER FOREACH] users: ${users}")
            }

        /*
        val users = arrayOf(
                "Virat Kohli", "Rohit Sharma", "Steve Smith",
                "Kane Williamson", "Ross Taylor")

        // access the listView from xml file
        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter
        */



        /*btnmngTracking1.setOnClickListener {
            val intent = Intent(this, ::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}