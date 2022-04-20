package com.imagepicker

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns

internal fun ContentResolver.getFileName(uri: Uri): String {
    val returnCursor = query(uri, null, null, null, null) ?: return ""

    val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    returnCursor.close()
    return name
}
