package com.uax.cardealership.ui

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.uax.cardealership.R
import com.uax.cardealership.databinding.ActivityLoginBinding
import com.uax.cardealership.models.User

class LoginActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var users: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instances()
        //initGUI()
        actions()
    }

    //Initialize Instances
    private fun instances() {
        users = arrayListOf(
            User("Selena", "selena@gmail.com", "1234"),
            User("Aitor", "aitor@gmail.com", "5678"),
            User("Almudena", "almudena@gmail.com", "7891")
        )
    }

    //Initialize graphical user interface
    private fun initGUI() {
        //Default option: Registered
        binding.userGroup.check(binding.registeredRadio.id)
    }

    //Set event listeners
    private fun actions() {
        binding.loginButton.setOnClickListener( this )
        binding.userGroup.setOnCheckedChangeListener( this )
    }

    //On click button:
    override fun onClick(p0: View?) {
        when( p0?.id ) {
            binding.loginButton.id -> {
                val selectedRadio: Int = binding.userGroup.checkedRadioButtonId
                val intent: Intent = Intent( applicationContext, CarsActivity::class.java )

                //Input fields:
                val emailInput = binding.editEmail.text.toString()
                val passInput = binding.editPass.text.toString()

                when (selectedRadio) {
                    binding.guestRadio.id -> {
                        //Access directly
                        startActivity( intent )
                    }

                    binding.registeredRadio.id -> {
                        //Empty fields:
                        if ( emailInput.isEmpty() || passInput.isEmpty() ) {
                            Snackbar.make( binding.root, "Please, fill in the empty fields.", Snackbar.LENGTH_SHORT ).show()
                        } else {
                            val user: User? = users.find {
                                it.email.equals( emailInput ) && it.pass.equals( passInput )
                            }

                            if ( user == null ) {
                                Snackbar.make( binding.root, "Log in Error.", Snackbar.LENGTH_SHORT ).show()
                            } else {
                                //Correct Login, access:
                                startActivity( intent )
                            }
                        }
                    }
                }
            }
        }
    }

    //On checked changed (radio)
    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when( p0?.id ) {
            binding.userGroup.id -> {
                when(p1) {
                    //Guest option selected:
                    binding.guestRadio.id -> {
                        binding.editPass.isEnabled = false
                        binding.editEmail.isEnabled = false
                    }
                    //Registered option selected
                    binding.registeredRadio.id -> {
                        binding.editPass.isEnabled = true
                        binding.editEmail.isEnabled = true
                    }
                }
            }
        }
    }
}