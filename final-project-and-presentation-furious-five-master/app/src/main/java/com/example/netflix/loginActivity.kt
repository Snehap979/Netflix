package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.netflix.R
import com.example.netflix.homePageActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var moveToSignUp : TextView

    private lateinit var signInButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        moveToSignUp = findViewById(R.id.moveToSignUp)


        signInButton = findViewById(R.id.signInButton)
        signInButton.setOnClickListener{
            performLogin()
        }



        moveToSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performLogin() {

        val email : EditText  = findViewById(R.id.loginEmail)
        val password : EditText = findViewById(R.id.loginPassword)


        //Null checks

        if (email.text.isEmpty() || password.text.isEmpty())
        {
            Toast.makeText(this , "Please fill input fields" , Toast.LENGTH_SHORT)
                .show()
            return

        }

        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()
        Toast.makeText(baseContext, emailInput,
            Toast.LENGTH_SHORT).show()
        Toast.makeText(baseContext, passwordInput,
            Toast.LENGTH_SHORT).show()
        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this , homePageActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }





    }
}