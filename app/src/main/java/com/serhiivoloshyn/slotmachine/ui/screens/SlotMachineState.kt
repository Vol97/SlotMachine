package com.serhiivoloshyn.slotmachine.ui.screens

import com.serhiivoloshyn.slotmachine.enums.BetSize
import com.serhiivoloshyn.slotmachine.enums.SlotValues

data class SlotMachineState(
    val betSize: BetSize = BetSize.TEN,
    val creditAmount: Int = 1000,
    val winAmount: Int = 0,
    val firstSlot: SlotValues = SlotValues.ORANGE,
    val secondSlot: SlotValues = SlotValues.ORANGE,
    val thirdSlot: SlotValues = SlotValues.ORANGE,
    val isSpinning: Boolean = false
)
