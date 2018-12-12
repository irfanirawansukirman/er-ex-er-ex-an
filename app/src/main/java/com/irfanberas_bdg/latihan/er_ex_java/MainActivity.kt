package com.irfanberas_bdg.latihan.er_ex_java

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.irfanberas_bdg.latihan.er_ex_java.observables.ZipActivity
import id.co.gits.belajarrx.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var movieA: Movie
    private lateinit var movieB: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_operators.setOnClickListener {
            // Sample looping numbers with rx java
            // RxUtils().loopsFromArray()

            // Sample looping with range operator
            // and filter it when the number modulus 2 == 0
            // RxUtils().loopsAndFilterData()
        }

        btn_observables.setOnClickListener {
            startActivity(Intent(this@MainActivity, ZipActivity::class.java))
        }
    }

}
