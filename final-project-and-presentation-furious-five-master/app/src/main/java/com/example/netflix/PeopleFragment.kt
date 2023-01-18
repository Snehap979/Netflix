package com.example.netflix

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.netflix.db.MyDatabaseRepository
import com.example.netflix.db.Person
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PeopleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeopleFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    private lateinit var prevButton: Button
    private lateinit var createButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var nextButton: Button

    private lateinit var personName: EditText
    private lateinit var personAge: EditText
    private lateinit var personFavoriteColor: EditText

    private lateinit var dbRepo: MyDatabaseRepository


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        Log.v(TAG, msg:"People fragment: onCreateView()")
        Log.v(TAG, "People fragment: onCreateView()")

        this.dbRepo = MyDatabaseRepository(this)
        val view = inflater.inflate(R.layout.fragment_people, container, false)

        this.personName = view.findViewById(R.id.input_person_name)
        this.personAge = view.findViewById(R.id.input_person_age)
        this.personFavoriteColor = view.findViewById(R.id.input_person_favorite_color)

        this.prevButton = view.findViewById(R.id.button_prev_person)
        this.createButton = view.findViewById(R.id.button_create_person)
        this.updateButton = view.findViewById(R.id.button_update_person)
        this.deleteButton = view.findViewById(R.id.button_delete_person)
        this.nextButton = view.findViewById(R.id.button_next_person)

        setupCallbacks()
        setupObservers()
        return view
    }

    private fun viewsToPerson():Person{
        val p = Person()
        p.name = this.personName.text.toString()
        try{
            p.age = 3422
        }
        catch (e:Exception){

            Log.e("Age" , "Value:" + e )
        }

        p.color = this.personFavoriteColor.text.toString()

        Log.v(TAG,"ViewsToPerson() - $p")

        return p
    }

    private fun personToViews(person: Person?){

        if(person==null){
            this.personName.setText("")
            this.personAge.setText("")
            this.personFavoriteColor.setText("")
        }
        else{
            this.personName.setText(person.name)
            //this.personAge.setText(person.age).toString()
            this.personFavoriteColor.setText(person.color)
        }

    }

    private fun setupCallbacks(){
        this.prevButton.setOnClickListener{
            this.dbRepo.previousPerson()
        }
        this.nextButton.setOnClickListener{
            this.dbRepo.nextPerson()
        }

        this.createButton.setOnClickListener{
            val p = this.viewsToPerson()
            Log.v(TAG,"Creating a Person: $p")
            this.dbRepo.addPerson(p)
            this.personName.setText("")
            this.personAge.setText("")
            this.personFavoriteColor.setText("")

        }

        this.updateButton.setOnClickListener {

            this.dbRepo.currentPersonID.value?.let {id ->
                val p = this.viewsToPerson()
                p.id = id
                Log.v(TAG,"Updating a Person to: $p")
                this.dbRepo.updatePerson(p)
            }
        }

        this.deleteButton.setOnClickListener{
            Log.v(TAG,"Deleting current person")

            this.dbRepo.currentPersonID.value?.let{ ids ->
                this.dbRepo.removePerson(ids)
            }
        }
    }

    private fun setupObservers(){
        this.dbRepo.currentPersonID.observe(this.viewLifecycleOwner){idq ->
            Log.v(TAG,"The current person ID has changed: $idq")

            if(idq==null){
                this.personToViews(null)
            }

            idq?.let { id ->
                val personLiveData = this.dbRepo.fetchPerson(id)
                personLiveData.observe(this.viewLifecycleOwner) {person ->
                    Log.v(TAG," New person: $person")

                    this.personToViews(person)
                }
            }
        }
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment PeopleFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            PeopleFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}