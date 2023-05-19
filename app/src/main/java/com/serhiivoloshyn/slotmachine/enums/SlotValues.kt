package com.serhiivoloshyn.slotmachine.enums

import com.serhiivoloshyn.slotmachine.R

enum class SlotValues(val resId: Int) {
    ORANGE(R.drawable.item0),
    STRAWBERRY(R.drawable.item1),
    GRAPE(R.drawable.item2),
    COCONUT(R.drawable.item3),
    PEACH(R.drawable.item4),
    BANANA(R.drawable.item5),
    KIWI(R.drawable.item6);

    companion object {
        fun getRandomSlot(): SlotValues {
            return values().random()
        }
    }
}