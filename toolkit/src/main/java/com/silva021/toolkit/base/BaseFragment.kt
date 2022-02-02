package com.silva021.toolkit.base

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.gson.Gson
import com.silva021.toolkit.navigation.QuestionNavigation

abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {
    private var _binding: VBinding? = null
    protected val binding get() = _binding!!
    protected abstract fun getViewBinding(): VBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    protected fun navigate(
        identifier: String,
        args: Bundle,
    ) {
        findNavController().apply {
            this.graph.find { navDestination ->
                navDestination.hasDeepLink(recoverDeepLink(identifier))
            }?.let {
                this.navigate(it.id, args)
            }
        }
    }

    protected fun navigate(
        identifier: String,
    ) {
        findNavController().navigate(recoverDeepLink(identifier))
    }

    inline fun <reified T> recoverArguments(
        success: (T) -> Unit,
    ) {
        arguments?.getString("object")?.let {
            val objectJson = Gson().fromJson(it, T::class.java)
            success(objectJson)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun recoverDeepLink(identifier: String): Uri =
        Uri.parse(String.format(QuestionNavigation.DEEPLINK_FORMAT, identifier))
}