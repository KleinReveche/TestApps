package com.kleinreveche.testapp.features.main.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kleinreveche.testapp.R
import com.kleinreveche.testapp.features.main.model.FeatureListsData
import com.kleinreveche.testapp.features.main.model.Features
import com.kleinreveche.testapp.features.main.ui.feature_lists.FeatureListItem
import com.kleinreveche.testapp.features.main.ui.features.FeatureItem

@Composable
fun Feature(
    featureLists: List<FeatureListsData>,
    onFeatureListClick: (featureList: FeatureListsData) -> Unit,
    features: List<Features>,
    onFeatureClick: (feature: Features) -> Unit
) {
    FeatureScaffold(
        topBarTitle = stringResource(id = R.string.app_name)
    ) { paddingValues ->
        LazyColumn(
            content = {
                item {
                    Text(
                        text = stringResource(id = R.string.features),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(FeaturePadding))
                }
                items(featureLists) { featureList ->
                    FeatureListItem(
                        featureList = featureList,
                        onClick = onFeatureListClick
                    )
                    Spacer(modifier = Modifier.height(FeatureItemPadding))
                }
                items(features) { feature ->
                    FeatureItem(
                        feature = feature,
                        onClick = onFeatureClick
                    )
                    Spacer(modifier = Modifier.height(FeatureItemPadding))
                }
            },
            contentPadding = WindowInsets.safeDrawing
                .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                .add(
                    WindowInsets(
                        left = FeaturePadding,
                        top = FeaturePadding,
                        right = FeaturePadding,
                    )
                )
                .asPaddingValues(),
            modifier = Modifier.padding(paddingValues)
        )
    }
}

private val FeaturePadding = 16.dp
private val FeatureItemPadding = 8.dp