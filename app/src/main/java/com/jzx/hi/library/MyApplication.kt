package com.jzx.hi.library

import android.app.Application
import com.google.gson.Gson
import com.jzx.hi.hilibrary.log.HiConsolePrinter
import com.jzx.hi.hilibrary.log.HiLogConfig
import com.jzx.hi.hilibrary.log.HiLogConfig.JsonParser
import com.jzx.hi.hilibrary.log.HiLogManger

class MyApplication : Application() {

    override fun onCreate() {

        super.onCreate()
        HiLogManger.init(object : HiLogConfig() {
            override fun getGlobalTag(): String {
                return "HiLog";
            }

            override fun enable(): Boolean {
                return true
            }

            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

        }, HiConsolePrinter())
    }

}