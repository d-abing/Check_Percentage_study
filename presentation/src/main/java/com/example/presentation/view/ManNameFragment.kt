package com.example.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentManNameBinding
import com.example.presentation.viewmodel.MainViewModel


class ManNameFragment: BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        binding.loadingBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalulator(
            host = "love-calculator.p.rapidapi.com",
            key = "361ab343a3mshf052dcf2cffabb5p1cfb81jsn20a5607cc89b",
            sname = mainViewModel.womanNameResult,
            fname = binding.nameEditTxt.text.toString()
        )
    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) { state ->
            binding.loadingBar.visibility = View.INVISIBLE
            when(state) {
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알 수 없는 오류가 발생했습니다")
            }
        }
    }

    private fun toastErrorMsg() {
        when(mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생했습니다")
        }
    }
}