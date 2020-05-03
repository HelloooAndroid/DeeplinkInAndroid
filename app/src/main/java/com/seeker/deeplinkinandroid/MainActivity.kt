package com.seeker.deeplinkinandroid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
  import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onResume() {
        super.onResume()
        val `in` = intent        //Keywords can be user as variables in kotlin using symbol (`)
        val data: Uri? = `in`.data

        if (data!=null){    // check for null data
            if(validateDeeplink(data)){  // check for validate data
                data_tv.setText("Deeplink Data is $data");
            }
        }

    }

    private fun validateDeeplink(data: Uri) :Boolean{
        //validate using data or pattern
        return true
    }
}
