package com.example.millioner

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

class QuestionViewModel(application: Application): AndroidViewModel(application) {
    val question = MutableLiveData<Question>()
    fun getQuestionData(question_number: Int) {
        var json: JSONObject? = null
        viewModelScope.launch(Dispatchers.IO) {
                json = JSONTokener(getResponse(question_number).toString()).nextValue() as JSONObject
                question.postValue(Question(0,json!!.getString("desc"),json!!.getString("a1"),json!!.getString("a2"),json!!.getString("a3"),json!!.getString("a4"),json!!.getString("aa"),question_number*10000))
            }
        }
    fun getResponse(number:Int): String {
        val url = URL("https://api.npoint.io/800121cc38ed672af8b3/question"+number.toString()+"/0")
        val httpsURLConnection = url.openConnection() as HttpsURLConnection
        httpsURLConnection.setRequestProperty(
            "Accept",
            "application/json"
        )
        httpsURLConnection.requestMethod = "GET"
        httpsURLConnection.doInput = true
        httpsURLConnection.doOutput = false
        val responseCode = httpsURLConnection.responseCode
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            val response = httpsURLConnection.inputStream.bufferedReader()
                .use { it.readText() }
            return response
        }
        return ""
    }
}