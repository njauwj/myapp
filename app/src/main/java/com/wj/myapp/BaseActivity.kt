package com.wj.myapp

import android.content.Intent
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun navigation(clazz: Class<*>) {
        var intent = Intent(this, clazz)
        startActivity(intent);
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 解决toast同步打印的话不能出现在子线程
     */
    fun showToastSync(msg: String?) {
        Looper.prepare()
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        Looper.loop()
    }

    fun localStorage(key: String, value: String) {
        var sharedPreferences = getSharedPreferences("wj_myapp", MODE_PRIVATE)
        var edit = sharedPreferences.edit()
        edit.putString(key,value)
        edit.commit()
    }
}