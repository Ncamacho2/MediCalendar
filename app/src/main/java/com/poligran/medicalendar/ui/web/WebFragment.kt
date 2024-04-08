package com.poligran.medicalendar.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.poligran.medicalendar.R


class WebFragment : Fragment() {

    private lateinit var editTextUrl: EditText
    private lateinit var buttonGo: Button
    private lateinit var webView: WebView

    fun WebViewFragment() {
        // Required empty public constructor
    }
    companion object {
        fun newInstance() = WebFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_web, container, false)
        editTextUrl = view.findViewById(R.id.editTextUrl)
        buttonGo = view.findViewById(R.id.buttonGo)
        webView = view.findViewById(R.id.webView)

        buttonGo.setOnClickListener {
            loadUrl()
        }
        editTextUrl.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus && !editTextUrl.text.toString().startsWith("http://") && !editTextUrl.text.toString().startsWith("https://")) {
                editTextUrl.setText("https://${editTextUrl.text}")
            }
        }

        return view
    }

    private fun loadUrl() {
        val url = editTextUrl.text.toString().trim()
        if (url.isNotEmpty()) {
            webView.visibility = View.VISIBLE // Mostrar el WebView
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
        }
    }
}