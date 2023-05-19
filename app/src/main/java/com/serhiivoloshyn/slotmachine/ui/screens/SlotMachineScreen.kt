package com.serhiivoloshyn.slotmachine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serhiivoloshyn.slotmachine.R
import com.serhiivoloshyn.slotmachine.ui.theme.baseFontFamily

@Composable
fun SlotMachineScreen(
    viewModel: SlotMachineViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds
        )

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.pipe),
            contentDescription = "Pipe",
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            BetCreditWin(state = state)
            SlotsRow(state = state)
            ButtonsRow(
                state = state,
                btnBetOneClick = { viewModel.betOne() },
                btnBetMaxClick = { viewModel.betMax() },
                btnSpinClick = { viewModel.spin() }
            )
        }
    }
}

@Composable
fun BetCreditWin(state: SlotMachineState) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AmountBlock(stringResource(id = R.string.bet), state.betSize.size)
        AmountBlock(stringResource(id = R.string.credit), state.creditAmount)
        AmountBlock(stringResource(id = R.string.win), state.winAmount)
    }
}

@Composable
fun AmountBlock(
    text: String,
    amount: Int
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = text,
            fontFamily = baseFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )
        Text(
            text = "$$amount",
            fontFamily = baseFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )
    }
}

@Composable
fun SlotsRow(state: SlotMachineState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Slot(imageId = state.firstSlot.resId)
        Slot(imageId = state.secondSlot.resId)
        Slot(imageId = state.thirdSlot.resId)
    }
}

@Composable
fun Slot(
    imageId: Int
) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.item_bg),
            contentDescription = "Item background"
        )
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = imageId),
            contentDescription = "Slot item"
        )
    }
}

@Composable
fun ButtonsRow(
    state: SlotMachineState,
    btnBetOneClick: () -> Unit,
    btnBetMaxClick: () -> Unit,
    btnSpinClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonFromImage(
            if (state.isSpinning) {
                R.drawable.btn_one_disabled
            } else {
                R.drawable.btn_one_default
            },
            state
        ) { btnBetOneClick.invoke() }

        ButtonFromImage(
            if (state.isSpinning) {
                R.drawable.btn_max_disabled
            } else {
                R.drawable.btn_max_default
            },
            state
        ) { btnBetMaxClick.invoke() }

        ButtonFromImage(
            if (state.isSpinning || state.creditAmount < state.betSize.size) {
                R.drawable.btn_spin_disabled
            } else {
                R.drawable.btn_spin_default
            },
            state
        ) { btnSpinClick.invoke() }
    }
}

@Composable
fun ButtonFromImage(
    imageId: Int,
    state: SlotMachineState,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = "Slot Button",
        modifier = Modifier.clickable {
            if (!state.isSpinning
                && state.creditAmount >= state.betSize.size
            ) onClick.invoke()
        }
    )
}