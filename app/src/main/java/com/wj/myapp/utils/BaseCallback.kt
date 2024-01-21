package com.wj.myapp.utils

interface BaseCallback {

    fun success(res: String)

    fun failed(e: Exception)

}