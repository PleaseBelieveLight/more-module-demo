package com.yyzy.feature.business

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yyzy.common.expansion.repeatOnLifecycleOnViewModel
import com.yyzy.common.expansion.requestMain
import com.yyzy.data.repo.TrackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

/**
 * @Author: ljl
 * @Email: ljl@dofun.cc
 * @ClassName: com.yyzy.main
 * @Description: BusinessViewModel
 * @Date: 2024/2/1
 */
@HiltViewModel
class BusinessViewModel @Inject constructor(
    private val lifeTrackRepository: TrackRepository
) : ViewModel(), DefaultLifecycleObserver {

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow: MutableSharedFlow<String>
        get() = _messageFlow

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        requestMain {
            lifeTrackRepository.saveLifeTrackEntity()
            repeatOnLifecycleOnViewModel(lifeTrackRepository.getLifeTrackFlow()) {
                _messageFlow.emit(it.joinToString { entity ->
                    entity.toString()
                })
            }
        }
    }
}