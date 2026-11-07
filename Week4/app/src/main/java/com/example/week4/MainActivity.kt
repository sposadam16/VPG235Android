package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentListener
{
    override fun removeFragment()
    {
        val frag = supportFragmentManager.findFragmentByTag("MyFragmentTag")

        if (frag != null) {
            supportFragmentManager
                .beginTransaction()
                .remove(frag)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.openListButton_id).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.loadFragButton_id).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_id,
                    MyFragment(),
                    "MyFragmentTag")
                .commit()
        }
    }
}