package com.example.quotes.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotes.databinding.FragmentQuoteRandomBinding
import com.example.quotes.presentation.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {

    private var _binding: FragmentQuoteRandomBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: QuoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentQuoteRandomBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel= ViewModelProvider(this)[QuoteViewModel::class.java]

        viewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            viewModel.randomQuote()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun observer(){
        lifecycleScope.launch {
            viewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }
}
