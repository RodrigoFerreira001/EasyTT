package com.catbit.easytt.ui.activities.login

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.catbit.easytt.R
import com.catbit.easytt.ui.activities.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.loginSuccessful.observe(this, Observer { success ->
            if (success) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })

        viewModel.showProgressBar.observe(this, Observer {
            login.isEnabled = !it
            progressBar.visibility = if (it) VISIBLE else GONE
        })

        viewModel.showSnackBar.observe(this, Observer {
            Snackbar.make(root, viewModel.errorMsg.toString(), Snackbar.LENGTH_LONG).show()
        })

        login.setOnClickListener {
            viewModel.login(username.text.toString(), password.text.toString())
        }
    }
}