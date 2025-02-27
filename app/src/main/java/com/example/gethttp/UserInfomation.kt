package com.example.gethttp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gethttp.adapter.rvUsersAdapter
import com.example.gethttp.databinding.ActivityUserInfomationBinding

class UserInfomation : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfomationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfomationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("item") as User
        binding.apply {
            tvUserCity.text = item.address.toString()
            tvUserName.text = item.name
            tvUserEmail.text = item.email
            tvUserPhone.text = item.phone
        }

    }
}