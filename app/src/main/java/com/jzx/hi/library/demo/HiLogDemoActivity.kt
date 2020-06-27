package com.jzx.hi.library.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.jzx.hi.hilibrary.log.*
import com.jzx.hi.library.R
import kotlinx.android.synthetic.main.activity_hi_log_demo.*

class HiLogDemoActivity : AppCompatActivity() {
    private var viewPrinter:HiViewPrinter? =null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)
        viewPrinter = HiViewPrinter(this)
        btn_log.setOnClickListener {
            printLog()
        }
        viewPrinter!!.viewPrinterProvider.showFloatingView()



    }

    private fun printLog(){
        HiLogManger.getInstance().addPrinter(viewPrinter)
        HiLog.log(object :HiLogConfig(){
            override fun includeThread(): Boolean {
                return true;
            }

            override fun stackTraceDepth(): Int {
                return 0;
            }
        },HiLogType.E,"------","5599")
        HiLog.a("3999","nihao","hello")
    }
}
