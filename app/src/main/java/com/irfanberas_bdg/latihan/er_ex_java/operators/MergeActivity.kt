package com.irfanberas_bdg.latihan.er_ex_java.operators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.co.gits.belajarrx.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class MergeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.merge_activity)

        val alphabets1 = Observable
            .interval(1, TimeUnit.SECONDS).map { id -> "A$id" }

        val alphabets2 = Observable
            .interval(1, TimeUnit.SECONDS).map { id -> "B$id" }

        Observable.merge(alphabets1, alphabets2)
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(s: String) {
                    Log.d("MERGE ", s)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
    }
}
