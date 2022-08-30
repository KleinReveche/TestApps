package com.kleinreveche.testapps.features.lunch_tray.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kleinreveche.testapps.features.lunch_tray.datasource.DataSource
import com.kleinreveche.testapps.features.lunch_tray.model.MenuItem
import com.kleinreveche.testapps.features.lunch_tray.model.MenuItem.SideDishItem

@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (SideDishItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit
    )
}

@Preview
@Composable
fun SideDishMenuPreview(){
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItems,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onSelectionChanged = {}
    )
}
