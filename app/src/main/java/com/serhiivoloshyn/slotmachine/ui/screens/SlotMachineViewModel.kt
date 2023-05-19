package com.serhiivoloshyn.slotmachine.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serhiivoloshyn.slotmachine.enums.BetSize
import com.serhiivoloshyn.slotmachine.enums.SlotValues
import com.serhiivoloshyn.slotmachine.usecases.CombinationGenerator
import com.serhiivoloshyn.slotmachine.usecases.WinAmountCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SlotMachineViewModel @Inject constructor(
    private val combinationGenerator: CombinationGenerator,
    private val winAmountCalculator: WinAmountCalculator
) : ViewModel() {
    private val _state = MutableStateFlow(SlotMachineState())
    val state: StateFlow<SlotMachineState> = _state.asStateFlow()

    fun betOne() {
        when (_state.value.betSize) {
            BetSize.TEN -> _state.update { it.copy(betSize = BetSize.TWENTY) }
            BetSize.TWENTY -> _state.update { it.copy(betSize = BetSize.THIRTY) }
            BetSize.THIRTY -> _state.update { it.copy(betSize = BetSize.TEN) }
        }
    }

    fun betMax() {
        _state.update { it.copy(betSize = BetSize.THIRTY) }
    }

    fun spin() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isSpinning = true,
                    creditAmount = it.creditAmount - it.betSize.size
                )
            }

            val combination = combinationGenerator.makeCombination()
            val winningSlot = if (
                combination[0] == combination[1]
                && combination[1] == combination[2]
            ) {
                combination[0]
            } else {
                null
            }
            val winAmount = winAmountCalculator.calculateWinAmount(
                winningSlotValue = winningSlot,
                betSize = state.value.betSize
            )

            for (i in 0..4) {
                _state.update {
                    it.copy(
                        firstSlot = SlotValues.getRandomSlot(),
                        secondSlot = SlotValues.getRandomSlot(),
                        thirdSlot = SlotValues.getRandomSlot()
                    )
                }
                delay(100L)
            }

            _state.update {
                it.copy(
                    firstSlot = combination[0],
                    secondSlot = combination[1],
                    thirdSlot = combination[2],
                    isSpinning = false,
                    winAmount = it.winAmount + winAmount
                )
            }
        }
    }
}