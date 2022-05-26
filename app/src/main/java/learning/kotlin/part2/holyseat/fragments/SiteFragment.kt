package learning.kotlin.part2.holyseat.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import learning.kotlin.part2.holyseat.R
import learning.kotlin.part2.holyseat.databinding.FragmentSiteBinding


class SiteFragment : Fragment() {

    private lateinit var binding: FragmentSiteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_site, container, false)
//
//        binding.homeTab.setOnClickListener{
//            it.findNavController().navigate(R.id.action_siteFragment_to_homeFragment)
//        }
//        binding.genreTab.setOnClickListener{
//            it.findNavController().navigate(R.id.action_siteFragment_to_genreFragment)
//        }
//        binding.talkTab.setOnClickListener{
//            it.findNavController().navigate(R.id.action_siteFragment_to_talkFragment)
//        }
//        binding.bookmarkTab.setOnClickListener{
//            it.findNavController().navigate(R.id.action_siteFragment_to_bookmarkFragment)
//        }

        val view = inflater.inflate(R.layout.fragment_site,container,false)
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://52.79.56.51:3000/"))
        startActivity(intent)
//        val webView : WebView = view.findViewById(R.id.siteWebView)

//        webView.getSettings().setJavaScriptEnabled(true)
//        webView.setWebViewClient(WebViewClient())
//        webView.settings.javaScriptEnabled = true
//        webView.loadUrl("http://52.79.56.51:3000/")
//        webView.loadUrl("http://www.ticketlink.co.kr/concert/musical")

//        return binding.root
        return view
    }



}