package com.example.qrtest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

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

        scanQR2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment, BlankFragment()).commit()
        }


    }

    class ScanFragment : Fragment() {
        private var toast: String? = null
        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            displayToast()
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view: View = inflater.inflate(R.layout.fragment_scan, container, false)
            val scan =
                view.findViewById<Button>(R.id.scan_from_fragment)
            scan.setOnClickListener { v: View? -> scanFromFragment() }
            return view
        }

        fun scanFromFragment() {
            IntentIntegrator.forSupportFragment(this).initiateScan()
        }

        private fun displayToast() {
            if (activity != null && toast != null) {
                Toast.makeText(activity, toast, Toast.LENGTH_LONG).show()
                toast = null
            }
        }

        override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?
        ) {
            val result =
                IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                toast = if (result.contents == null) {
                    "Cancelled from fragment"
                } else {
                    "Scanned from fragment: " + result.contents
                }

                // At this point we may or may not have a reference to the activity
                displayToast()
            }
        }
    }



}
