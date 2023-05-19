package com.serhiivoloshyn.slotmachine.usecases

import com.serhiivoloshyn.slotmachine.enums.BetSize
import com.serhiivoloshyn.slotmachine.enums.SlotValues
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WinAmountCalculator @Inject constructor() {
    fun calculateWinAmount(winningSlotValue: SlotValues?, betSize: BetSize): Int {
        var winAmount = 0

        winAmount += when(winningSlotValue) {
            SlotValues.ORANGE -> betSize.size * 250
            SlotValues.STRAWBERRY -> betSize.size * 100
            SlotValues.GRAPE -> betSize.size * 50
            SlotValues.COCONUT -> betSize.size * 20
            SlotValues.PEACH -> betSize.size * 10
            SlotValues.BANANA -> betSize.size * 5
            SlotValues.KIWI -> betSize.size * 2
            else -> { 0 }
        }

        return winAmount
    }
}