package com.example.crytpcurrencytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crytpcurrencytracker.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rclview.layoutManager = LinearLayoutManager(this)


        val call = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .build()
            .create(MyAPICall::class.java)
            .call

        call.enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                val dataModel = response.body()!!

                binding.rclview.adapter = MyAdapter(dataModel)
            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}