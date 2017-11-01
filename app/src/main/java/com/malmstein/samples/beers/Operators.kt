package com.malmstein.samples.beers

import android.view.View
import android.view.ViewGroup

operator fun ViewGroup.get(pos: Int): View = getChildAt(pos)

