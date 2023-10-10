package com.example.apicallvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.apicallvolley.databinding.ActivityMainBinding
import kotlinx.coroutines.DefaultExecutor.thread
import java.net.HttpURLConnection
import org.json.JSONArray
import java.net.URL
import java.util.Scanner


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnQuote.setOnClickListener {
            handleRetrieveQuoteWithVolley()
        }
    }
        // Access views using binding object
        val myButton = binding.btnRetrieve

    fun dummy(){

        try{

            if(){

                if(){

                }
            }
        }catch (IO exception){

        }


    }    }

    fun getQuote(view: View) {  val thread = Thread {

        val url = URL("https://api.fbi.gov/wanted/v1/list")

        try {
            val connection = url.openConnection()
            if (connection is HttpURLConnection) {
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.requestMethod = "GET"
                connection.connect()

                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val scanner = Scanner(connection.inputStream)
                    scanner.useDelimiter("\\A")
                    val jsonData = if (scanner.hasNext()) scanner.next() else ""
                    Log.d("jsonData", jsonData)
                    val jsonArray = JSONArray(jsonData)
                    val quote = jsonArray[0].toString()
                    updateTextBoxFromThread(quote)
                    Log.d("jsonArray[0]", quote)
                } else {
                    updateTextBoxFromThread("Sorry, there's a problem with the server")
                }
            }else{
                Log.wtf ("MAIN_ACTIVITY", "Someone changed the API protocol")
            }
            thread.start()
        }
    }
        private fun parseJson(jsonData: String?): String {
            val jsonArray = JSONArray(jsonData)
            val quote = jsonArray[0].toString()
            return quote

        }
        private fun handleRetrieveQuoteWithVolley() {
            val queue = volley.newRequestQueue(this)
            val jsonObjectRequest = jsonObjectRequest(
                Request.Method
            )
    }
}