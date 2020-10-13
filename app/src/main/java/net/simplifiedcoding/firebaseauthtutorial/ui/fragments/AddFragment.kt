package net.simplifiedcoding.firebaseauthtutorial.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_add.*

import net.simplifiedcoding.firebaseauthtutorial.R



class AddFragment : Fragment() {
   // private lateinit var database: DatabaseReference
// ...
   var database = FirebaseDatabase.getInstance()


   // myRef.setValue("Hello, World!");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        button_add.setOnClickListener {
            val name = edit_text_name.text.toString().trim()
            if (name.isEmpty()) {
                input_layout_name.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }
            var myRef = database.getReference("Notice" )

          myRef.setValue(name)
            Toast.makeText(this.context , "NOTICE HAS BEEN ADDED", Toast.LENGTH_SHORT).show()



        }
    }


}
