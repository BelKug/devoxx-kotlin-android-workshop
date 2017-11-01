package com.malmstein.samples.beers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class BeerDetailActivity : AppCompatActivity() {

    companion object Helper {
        fun open(context: Context) {
            context.startActivity(Intent(context, BeerDetailActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_detail)
    }
}
