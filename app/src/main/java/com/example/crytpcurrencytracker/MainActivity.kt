package com.example.crytpcurrencytracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rcv: RecyclerView = findViewById(R.id.rclview)

        rcv.layoutManager = LinearLayoutManager(this)


        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .build()
            .create(MyAPICall::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                val dataModel = response.body()!!

                rcv.adapter = MyAdapter(dataModel)
            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}