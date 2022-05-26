package learning.kotlin.part2.holyseat.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import learning.kotlin.part2.holyseat.R
import learning.kotlin.part2.holyseat.contentsList.ContentsListActivity
import learning.kotlin.part2.holyseat.databinding.FragmentGenreBinding

class GenreFragment : Fragment() {
    private lateinit var binding : FragmentGenreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_genre, container, false)

        binding.category1.setOnClickListener {
            val intent = Intent(context, ContentsListActivity::class.java)
            intent.putExtra("category","category1")
            startActivity(intent)

        }
        binding.category2.setOnClickListener {
            val intent = Intent(context, ContentsListActivity::class.java)
            intent.putExtra("category","category2")
            startActivity(intent)
        }


        binding.homeTab.setOnClickListener{
            it.findNavController().navigate(R.id.action_genreFragment_to_homeFragment)
        }
        binding.talkTab.setOnClickListener{
            it.findNavController().navigate(R.id.action_genreFragment_to_talkFragment)
        }
        binding.bookmarkTab.setOnClickListener{
            it.findNavController().navigate(R.id.action_genreFragment_to_bookmarkFragment)
        }
        binding.siteTab.setOnClickListener{
            it.findNavController().navigate(R.id.action_genreFragment_to_siteFragment)
        }


        return binding.root
    }


}