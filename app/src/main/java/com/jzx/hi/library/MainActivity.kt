package com.jzx.hi.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jzx.hi.hilibrary.log.HiLogManger
import com.jzx.hi.hilibrary.log.HiViewPrinter
import com.jzx.hi.library.demo.HiLogDemoActivity
import kotlinx.android.synthetic.main.activity_hi_log_demo.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var viewPrinter: HiViewPrinter? =null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPrinter = HiViewPrinter(this)
        HiLogManger.getInstance().addPrinter(viewPrinter)
        viewPrinter!!.viewPrinterProvider.showFloatingView()

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_turn ->{
                startActivity(Intent(this,HiLogDemoActivity::class.java))
            }
        }
    }
}
