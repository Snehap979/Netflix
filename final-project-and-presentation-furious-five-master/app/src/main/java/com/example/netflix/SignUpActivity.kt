package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.netflix.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpEmail : EditText
    private lateinit var signUpPassword : EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var confirmPassword : EditText

    private lateinit var register : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        register = findViewById(R.id.register)

        auth = Firebase.auth

        register.setOnClickListener {


            performSignUp()
        }
    }

    private fun performSignUp() {

        signUpEmail = findViewById(R.id.signUpEmail)
        signUpPassword = findViewById(R.id.signUpPassword)
        confirmPassword = findViewById(R.id.confirmPassword)


        val inputEmail = signUpEmail.text.toString()
        val inputPassword = signUpPassword.text.toString()
        //val inputPassword2 = confirmPassword.text.toString()

        if (signUpEmail.text.isEmpty() || (signUpPassword.text.isEmpty()))
        {
            Toast.makeText(this , "Please fill all fields" , Toast.LENGTH_SHORT).show()
            return
        }


        Toast.makeText(baseContext, inputEmail,
            Toast.LENGTH_SHORT).show()
        Toast.makeText(baseContext, inputPassword,
            Toast.LENGTH_SHORT).show()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent = Intent(this , homePageActivity::class.java)
                        startActivity(intent)
                    } else {

                        Toast.makeText(baseContext, "Authentication failed.{e}",
                            Toast.LENGTH_SHORT).show()

                    }
                }
                .addOnFailureListener{
                    Toast.makeText(this, "Error Occured ${it.localizedMessage}" , Toast.LENGTH_SHORT)
                }




    }
}