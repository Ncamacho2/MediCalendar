package com.poligran.medicalendar.ui.web

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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
        editTextUrl.setImeActionLabel("Hecho", KeyEvent.KEYCODE_ENTER);
        editTextUrl.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                // Validar el texto al presionar Enter
                val texto = editTextUrl.text.toString()
                if (!texto.startsWith("https://")) {
                    editTextUrl.setText("https://$texto")
                    editTextUrl.setSelection(editTextUrl.text.length)
                }
                true
            }
            false
        }
        buttonGo.setOnClickListener {
            loadUrl()
        }


        return view
    }


    private fun loadUrl() {
        val url = editTextUrl.text.toString().trim()
        webView.visibility = View.VISIBLE // Mostrar el WebView
        webView.webViewClient = WebViewClient()
        if (url.isNotEmpty()) {

            webView.loadUrl(url)
        } else {
            webView.loadUrl("https://google.com")
        }
    }
}