package com.example.moviematrix

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.tabs.TabLayout.TabGravity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val firebaseAuth = FirebaseAuth.getInstance()


    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    private val _toast = MutableLiveData<String?>()
    val toast: LiveData<String?>
        get() = _toast

    fun signUp(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
            if (it.isSuccessful) {
                login(email,password)
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception?.message}.")
                _toast.value = it.exception?.message
                _toast.value = null
            }
        }
    }

    fun login(email: String, password: String) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _currentUser.value = firebaseAuth.currentUser
                } else {
                    Log.e(TAG, "Login failed: ${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
        }
        fun logout() {

            firebaseAuth.signOut()
            _currentUser.value = firebaseAuth.currentUser
        }
}