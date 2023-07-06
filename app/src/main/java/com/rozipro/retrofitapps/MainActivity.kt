package com.rozipro.retrofitapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.rozipro.retrofitapps.ResponseRickandMorty
import com.rozipro.retrofitapps.ResultsItem
import com.rozipro.retrofitapps.RickandMortyAdapter
import com.rozipro.retrofit.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvRickandMorty = findViewById<RecyclerView>(R.id.rvChar)

        ApiConfig.getService().getRickandMorty().enqueue(object : Callback<ResponseRickandMorty> {
            override fun onResponse(call : Call<ResponseRickandMorty>,response: Response<ResponseRickandMorty>){
                if(response.isSuccessful){
                    val responseRick = response.body()
                    val dataRick = responseRick?.results
                    val rickAdapter = RickandMortyAdapter(dataRick as List<ResultsItem>)
                    rvRickandMorty.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
            }

            override fun onFailure (call: Call<ResponseRickandMorty>,t:Throwable){
                Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        })
    }
}