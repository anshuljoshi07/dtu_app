package net.simplifiedcoding.firebaseauthtutorial.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_lectures.*
import kotlinx.android.synthetic.main.fragment_notices.*
import net.simplifiedcoding.firebaseauthtutorial.R


class LecturesFragment : Fragment() {


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
        return inflater.inflate(R.layout.fragment_lectures, container, false)





    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val youTubePlayerView: YouTubePlayerView = youtube_player_view
        lifecycle.addObserver(youTubePlayerView)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Notes")

        val database2 = FirebaseDatabase.getInstance()
        val myRef2 = database2.getReference("Comments")

        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
                textView4.text = value


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
                textView.text = value


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })




    }


}
