package com.irfanberas_bdg.latihan.er_ex_java

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.irfanberas_bdg.latihan.er_ex_java.observables.ZipActivity
import com.irfanberas_bdg.latihan.er_ex_java.operators.OperatorsActivity
import com_irfanberas_bdg.latihan.er_ex_java.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_operators.setOnClickListener {
            startActivity(Intent(this@MainActivity, OperatorsActivity::class.java))
        }

        btn_observables.setOnClickListener {
            startActivity(Intent(this@MainActivity, ZipActivity::class.java))
        }
    }

}
