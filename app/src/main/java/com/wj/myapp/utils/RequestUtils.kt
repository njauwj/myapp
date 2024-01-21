package com.wj.myapp.utils

import android.util.Log
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object RequestUtils {


    fun doPost(map: Map<String, Any>, callBack: BaseCallback) {
        var client = OkHttpClient.Builder().build()
        var jsonObject = JSONObject(map)
        var jsonStr = jsonObject.toString()
        var requestBodyJson =
            RequestBody.create(
                MediaType.parse("application/json;charset=utf-8"), jsonStr
            );
        //第三步创建Rquest
        var request = Request.Builder()
            .url(Constant.BASE_URL + map["url"].toString())
            .addHeader("contentType", "application/json;charset=UTF-8")
            .post(requestBodyJson)
            .build();
        //第四步创建call回调对象
        var call = client.newCall(request);
        //第五步发起请求
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callBack.failed(e)
                Log.e("error", e.message.toString())

            }

            override fun onResponse(call: Call, response: Response) {
                var res = response.body()?.string().toString()
                callBack.success(res)
                Log.d("success", res)
            }
        })
    }

}
