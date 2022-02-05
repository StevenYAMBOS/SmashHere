package com.example.smashhere

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smashhere.Extensions.toast
import com.example.smashhere.FirebaseUtils.firebaseAuth
import com.example.smashhere.FirebaseUtils.firebaseUser
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.* //ajouter le "*"

class Sign_Up : AppCompatActivity() {

    private lateinit var userMail: String
    private lateinit var userPassword: String
    private lateinit var signUpInputsArray: Array<EditText>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpInputsArray = arrayOf(editTextTextEmailAddress, editTextTextPassword)
        btn_register.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            signIn()
        }
    }

    override fun onStart(){
        super.onStart()
        val user : FirebaseUser? = firebaseAuth.currentUser
        user?.let {
            startActivity(Intent(this, MainActivity::class.java))
            toast("Logged in !")
        }
    }

    private fun signIn(){
        userMail = editTextTextEmailAddress.text.toString().trim()
        userPassword = editTextTextPassword.text.toString().trim()

        firebaseAuth.createUserWithEmailAndPassword(userMail, userPassword).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                toast("New account created")
                sendEmailVerification()
                startActivity(Intent(this, MainCharacterSelection::class.java))
                finish()
            }else{
                    toast("failed to Authenticate")
                }
            }
        }

    private fun sendEmailVerification(){
        firebaseUser?.let {
            it.sendEmailVerification().addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    toast("Email sent to $userMail")
                }
            }
        }
    }

    }

