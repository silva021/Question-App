package com.silva021.toolkit.extension

import androidx.core.os.bundleOf
import com.google.gson.Gson

fun Any.toBundle() = bundleOf("object" to this)

fun Any.toJson() = Gson().toJson(this)