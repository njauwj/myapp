package com.wj.myapp.utils


object StringUtils {
    fun isEmpty(param: String?): Boolean {
        return param == null || param.trim().isEmpty();
    }
}