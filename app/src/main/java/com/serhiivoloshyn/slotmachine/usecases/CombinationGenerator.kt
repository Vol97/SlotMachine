package com.serhiivoloshyn.slotmachine.usecases

import com.serhiivoloshyn.slotmachine.enums.SlotValues
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CombinationGenerator @Inject constructor() {
    private var defaultSetOfValues: MutableList<MutableList<SlotValues>> = mutableListOf(
        mutableListOf(
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.ORANGE,
            SlotValues.BANANA,
            SlotValues.STRAWBERRY,
            SlotValues.COCONUT,
            SlotValues.GRAPE,
            SlotValues.PEACH
        ),
        mutableListOf(
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.ORANGE,
            SlotValues.BANANA,
            SlotValues.STRAWBERRY,
            SlotValues.COCONUT,
            SlotValues.GRAPE,
            SlotValues.PEACH
        ),
        mutableListOf(
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.KIWI,
            SlotValues.ORANGE,
            SlotValues.BANANA,
            SlotValues.STRAWBERRY,
            SlotValues.COCONUT,
            SlotValues.GRAPE,
            SlotValues.PEACH
        )
    )

    fun makeCombination(): List<SlotValues> {
        val combination = mutableListOf<SlotValues>()

        combination.add(defaultSetOfValues[0].random())
        combination.add(defaultSetOfValues[1].random())
        combination.add(defaultSetOfValues[2].random())

        return combination
    }

    //TODO think about this logic
    private fun changeDefaultCombination(
        slotPosition: Int,
        slotValue: SlotValues,
        slotValueQuantity: Int
    ) {
        val slotValuesToAdd = mutableListOf<SlotValues>()
    }
}