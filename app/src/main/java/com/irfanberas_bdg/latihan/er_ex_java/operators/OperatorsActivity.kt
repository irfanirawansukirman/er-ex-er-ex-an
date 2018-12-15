package com.irfanberas_bdg.latihan.er_ex_java.operators

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com_irfanberas_bdg.latihan.er_ex_java.R
import kotlinx.android.synthetic.main.operators_activity.*

class OperatorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.operators_activity)

        btn_operators_fromArray.setOnClickListener {
            startActivity(Intent(this@OperatorsActivity, FromArrayActivity::class.java))
        }

        btn_operators_range.setOnClickListener {
            startActivity(Intent(this@OperatorsActivity, RangeFusionActivity::class.java))
        }

        btn_operators_merge.setOnClickListener {
            startActivity(Intent(this@OperatorsActivity, MergeActivity::class.java))
        }
    }
}
