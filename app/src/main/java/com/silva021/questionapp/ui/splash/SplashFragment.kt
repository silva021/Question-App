package com.silva021.questionapp.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.silva021.questionapp.databinding.FragmentSplashBinding
import com.silva021.toolkit.base.BaseFragment
import com.silva021.toolkit.navigation.QuestionNavigation

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAnimation()
    }

    private fun initAnimation() {
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                findNavController().popBackStack()
                navigate(QuestionNavigation.SCHOOL_SUBJECT_SCREEN)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

    override fun getViewBinding(): FragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)
}