package com.wj.myapp

import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener(View.OnClickListener {
            navigation(LoginActivity::class.java)
        })
        var registerButton = findViewById<Button>(R.id.btn_register)
        registerButton.setOnClickListener(View.OnClickListener {
            navigation(RegisterActivity::class.java)
        })
    }
}