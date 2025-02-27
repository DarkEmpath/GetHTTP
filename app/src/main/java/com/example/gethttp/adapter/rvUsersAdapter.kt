package com.example.gethttp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gethttp.R
import com.example.gethttp.User
import com.example.gethttp.UserInfomation
import com.example.gethttp.databinding.RvItemBinding

class rvUsersAdapter(val listener:ClickListener) : ListAdapter<User, rvUsersAdapter.Holder>(Comparator()) {

    class Holder(view : View) : RecyclerView.ViewHolder(view){
        private val binding = RvItemBinding.bind(view)

        fun bind(user: User, listener: ClickListener) = with(binding){
            tvId.text = user.id.toString()
            tvName.text = user.name
            tvEmail.text = user.email
            cvItem.setOnClickListener{
                listener.onClick(user)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface ClickListener{
        fun onClick(user: User)
    }
}