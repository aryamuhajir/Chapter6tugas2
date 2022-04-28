package com.binar.chapter6tugas2

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.chapter6tugas2.ViewModel.ViewModelFilm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapterFilm : RvAdapter
    lateinit var cont : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cont = this

        PenerapanAsyncTask().execute()

    }

    inner class PenerapanAsyncTask : AsyncTask<Void, Void, Void>(){
        lateinit var pdialog : ProgressDialog
        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(cont)
            pdialog.show()

        }

        override fun doInBackground(vararg p0: Void?): Void? {
            pasangAdapter()
            return null

        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            getDataFilm2()
            pdialog.dismiss()
        }


    }
    fun getDataFilm2(){
        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getLiveFilmObserver().observe(this, {
            if (it != null){
                adapterFilm.setDataFilm(it)
                adapterFilm.notifyDataSetChanged()

            }

        })

        viewModel.makeApiFilm()

    }
    fun pasangAdapter(){
        rv_film.layoutManager = LinearLayoutManager(cont)
        adapterFilm = RvAdapter()
        rv_film.adapter = adapterFilm
    }
}