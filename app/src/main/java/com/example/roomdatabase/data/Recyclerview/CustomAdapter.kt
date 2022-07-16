package com.example.roomdatabase.data.Recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.data.Room.User
import kotlinx.android.synthetic.main.custom_list_layout.view.*

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.MViewholder>(){

    private var userlist = emptyList<User>()
    class MViewholder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewholder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_layout,parent,false)
        return MViewholder(view)
    }

    override fun onBindViewHolder(holder: MViewholder, position: Int) {
        val currentTime = userlist[position]
        holder.itemView.textView3.text = currentTime.Name
        holder.itemView.textView4.text = currentTime.age.toString()
    }

    override fun getItemCount(): Int {
       return userlist.size
    }

    fun setData(user : List<User>){
        this.userlist = user
        notifyDataSetChanged()
    }
}