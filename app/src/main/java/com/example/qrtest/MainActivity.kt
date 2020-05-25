package com.example.qrtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createQR.setOnClickListener {
//            var alert = AlertDialog.Builder(this)
//            alert.setTitle("alert")
//            alert.setMessage("나왔지롱")
//            alert.show()
            val intent = Intent(this, CreateQR::class.java)
            startActivity(intent)

        }

        scanQR.setOnClickListener {
//            var alert = AlertDialog.Builder(this)
//            alert.setTitle("다이얼로그")
//            alert.setMessage("나왔지롱")
//            alert.show()

            val intent = Intent(this, ScanQR::class.java)
            startActivity(intent)
        }


    }


}
