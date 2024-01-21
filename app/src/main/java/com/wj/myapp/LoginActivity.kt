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

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginButton = findViewById<Button>(R.id.btn_login)
        var account = findViewById<EditText>(R.id.et_account)
        var password = findViewById<EditText>(R.id.et_pwd)
        loginButton.setOnClickListener(View.OnClickListener {
            login(account.text.toString(), password.text.toString())
        })

    }

    private fun login(account: String, password: String) {
        if (StringUtils.isEmpty(account)) {
            showToast("账号不能为空")
            return
        }
        if (StringUtils.isEmpty(password)) {
            showToast("密码不能为空")
            return
        }
        var map = HashMap<String, Any>()
        map["url"] = Constant.LOGIN
        map["account"] = account
        map["password"] = password
        RequestUtils.doPost(map, object : BaseCallback {
            override fun success(res: String) {
                val gson = Gson()
                val type = object : TypeToken<BaseResponse<LoginResp>>() {}.type
                val baseResponse: BaseResponse<LoginResp> = gson.fromJson(res, type)
                var code = baseResponse.code
                if (code == 1) {
                    var data = baseResponse.data
                    localStorage("token", data.token)
                }
                showToastSync(baseResponse.msg)

            }

            override fun failed(e: Exception) {

            }
        })
    }


}