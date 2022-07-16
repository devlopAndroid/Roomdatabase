package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.data.Room.User
import com.example.roomdatabase.data.Viewmodel.Userviewmodel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    lateinit var myviewmodel: Userviewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_list, container, false)

        val activity = requireNotNull(this.activity)
        myviewmodel = ViewModelProvider(this).get(Userviewmodel::class.java)
        view.button.setOnClickListener {
            insertdatatoDatabase()
        }
        return view
    }

    private fun insertdatatoDatabase() {
        val firstName = textView.text.toString()
        val age = textView2.text

        val user = User(0,firstName,Integer.parseInt(age.toString()))
        myviewmodel.addUser(user)
        Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_SHORT).show()
    }


}