package com.wj.myapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wj.myapp.resp.BaseResponse
import com.wj.myapp.resp.LoginResp
import com.wj.myapp.utils.BaseCallback
import com.wj.myapp.utils.Constant
import com.wj.myapp.utils.RequestUtils
import com.wj.myapp.utils.StringUtils
import java.lang.Exception

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var registerButton = findViewById<Button>(R.id.btn_register)
        var account = findViewById<EditText>(R.id.et_account)
        var password = findViewById<EditText>(R.id.et_pwd)
        registerButton.setOnClickListener(View.OnClickListener {
            register(account.text.toString(), password.text.toString())
        })
    }

    private fun register(account: String, password: String) {
        if (StringUtils.isEmpty(account)) {
            showToast("账号不能为空")
            return
        }

        if (StringUtils.isEmpty(password)) {
            showToast("密码不能为空")
            return
        }
        var map = HashMap<String, Any>()
        map["url"] = Constant.REGISTER
        map["account"] = account
        map["password"] = password
        RequestUtils.doPost(map, object : BaseCallback {
            override fun success(res: String) {
                val gson = Gson()
                val type = object : TypeToken<BaseResponse<String>>() {}.type
                val baseResponse: BaseResponse<String> = gson.fromJson(res, type)
                showToastSync(baseResponse.msg)
            }

            override fun failed(e: Exception) {

            }
        })
    }
}