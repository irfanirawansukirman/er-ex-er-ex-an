package com.irfanberas_bdg.latihan.er_ex_java.observables

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.irfanberas_bdg.latihan.er_ex_java.ApiService
import com.irfanberas_bdg.latihan.er_ex_java.Capture
import com.irfanberas_bdg.latihan.er_ex_java.Movie
import com_irfanberas_bdg.latihan.er_ex_java.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.zip_activity.*


class ZipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zip_activity)

        btn_zip.setOnClickListener {
            // Sample multiple request call
            callMultipleRequest()
        }
    }

    private fun callMultipleRequest() {
        val movie1 = ApiService.apiInstanceService.getMovies()
        val movie2 = ApiService.apiInstanceService.getMovies()

        Observable.zip(
            movie1,
            movie2,
            BiFunction<Movie, Movie, Capture> { t1, t2 -> captureMovies(t1, t2) })
            // Run on background thread
            .subscribeOn(Schedulers.io())
            // Be notified on main thread
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Capture> {
                override fun onComplete() {
                    Log.d("MOVIE", "onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("MOVIE", "onSubscribe")
                }

                override fun onNext(t: Capture) {
                    Log.d("MOVIE A", Gson().toJson(t.movieA))
                    Log.d("MOVIE B", Gson().toJson(t.movieB))
                }

                override fun onError(e: Throwable) {
                    Log.d("MOVIE", e.message)
                }
            })
    }

    private fun captureMovies(movieA: Movie, movieB: Movie): Capture {
        return Capture(movieA, movieB)
    }
}
