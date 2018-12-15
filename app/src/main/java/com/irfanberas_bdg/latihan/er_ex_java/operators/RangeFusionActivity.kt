package com.irfanberas_bdg.latihan.er_ex_java.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com_irfanberas_bdg.latihan.er_ex_java.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RangeFusionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.range_fusion_activity)

        Observable.range(1, 20)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { integer -> integer % 2 == 0 }
            .map { integer -> integer.toString() + " is even number" }
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(s: String) {
                    Log.d("IRFAN", "on Value $s")
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    Log.d("IRFAN ", "All items is emitted")
                }
            })
    }
}
