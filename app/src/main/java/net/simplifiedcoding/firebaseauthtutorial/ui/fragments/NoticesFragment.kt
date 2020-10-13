package net.simplifiedcoding.firebaseauthtutorial.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_notices.*
import net.simplifiedcoding.firebaseauthtutorial.R


class NoticesFragment : Fragment() {
private  var value2  : String ?= null
    private  var value3  : String ?= null
    private  var value4 : String = "NO UNSEEN NOTICE"
    private  var value5  : String = "NO UNSEEN NOTICE"

private var   database = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

        var  myRef = database.getReference().child("Notice")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notices, container, false)



        //action_NoticesFragment_to_AddFragment
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var myRef2 = database.getReference("Notice2" )
        val myRef = database.getReference("Notice")
        var myRef3 = database.getReference("Notice3" )

        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


if(value2!=null) {
    myRef2.setValue(value2)
}

if(value3!=null) {
    myRef3.setValue(value3)
}
               // textView5.text=value5
                //textView4.text=value4
                 //textView3.text=value3

                //textView2.text=value2



                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
              //  value5=value4.toString()
               // value4=value3.toString()

                value3=value2.toString()
                value2= value.toString()
                textView1.text = value
                Toast.makeText(context,value,Toast.LENGTH_LONG).show()




            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })
        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
                textView2.text = value


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })
        myRef3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
                textView3.text = value

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })






        button.setOnClickListener {
            val action = NoticesFragmentDirections.actionNoticesFragmentToAddFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }




}
