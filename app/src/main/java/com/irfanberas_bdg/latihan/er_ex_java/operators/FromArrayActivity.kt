package com.irfanberas_bdg.latihan.er_ex_java.operators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com_irfanberas_bdg.latihan.er_ex_java.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FromArrayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.from_array_activity)

        val array = arrayOfNulls<Int>(10)
        for (i in array.indices) {
            array[i] = i + 1
        }

        Observable.fromArray<Int>(*array)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("IRFAN", "On Subscribe")
                }

                override fun onNext(integer: Int) {
                    Log.d("IRFAN", "Number " + integer.toString())
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    Log.d("IRFAN", "All number is emitted")
                }
            })
    }
}
