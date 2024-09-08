package com.coding.meet.docscannerapp.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.coding.meet.docscannerapp.ui.viewmodels.PdfViewModel

/**
 * Created 08-04-2024 at 01:24 pm
 */

@Composable
fun LoadingDialog(pdfViewModel: PdfViewModel) {
    if (pdfViewModel.loadingDialog) {
        Dialog(onDismissRequest = {
            pdfViewModel.loadingDialog = false
        } ,properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
            Box(
                modifier = Modifier
                    .size(100.dp).background( MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }

}