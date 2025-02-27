package com.example.gethttp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gethttp.adapter.rvUsersAdapter
import com.example.gethttp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), rvUsersAdapter.ClickListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: rvUsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = rvUsersAdapter(this)
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(api::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val list = api.getUsers()
            runOnUiThread{
                binding.apply {
                    adapter.submitList(list)
                }
            }
        }

    }
    override fun onClick(user: User) {
        startActivity(Intent(this, UserInfomation::class.java).apply {
            putExtra("item", user)
        })
    }

}