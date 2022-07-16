package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.data.Recyclerview.CustomAdapter
import com.example.roomdatabase.data.Viewmodel.Userviewmodel
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    lateinit var userlistmodel : Userviewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        
        val adapter = CustomAdapter()
        val recyclerview  = view.recycle_list
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        
        //UserViewModel
        val activity = requireNotNull(this.activity)
        userlistmodel = ViewModelProvider(this).get(Userviewmodel::class.java)

        userlistmodel.readAllData.observe(viewLifecycleOwner, Observer { user->
            adapter.setData(user)

        })


       view.floatingActionButton.setOnClickListener {
           findNavController().navigate(R.id.action_addFragment_to_listFragment)
       }
        return view
    }

}