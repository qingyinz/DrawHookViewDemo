package com.example.drawhookviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {showToastWithImage("登录成功")  }

    }
    //带图片的toast
    fun showToastWithImage(message: CharSequence) {
        var mtoastView = LayoutInflater.from(applicationContext).inflate(R.layout.view_toast_image, null)
        val relativeLayout = mtoastView?.findViewById(R.id.toast_linear) as LinearLayout
        //动态设置toast控件的宽高度，宽高分别是130dp
        //这里用了一个将dp转换为px的工具类PxUtil
        val layoutParams = RelativeLayout.LayoutParams(DisplayUtils.dp2px(applicationContext, 130f).toInt(), DisplayUtils.dp2px(applicationContext, 130f).toInt())
        relativeLayout.setLayoutParams(layoutParams)
        val textView = mtoastView?.findViewById(R.id.tv_toast_clear) as TextView
        textView.text = message
        val mToast = Toast(application)
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast?.setGravity(Gravity.CENTER, 0, 0)
        mToast.setView(mtoastView)
        mToast?.show()
    }
}
