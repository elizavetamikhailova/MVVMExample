package project.elizavetamikhailova.mvvmexample.ui.dbadpters

import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import project.elizavetamikhailova.mvvmexample.R

@BindingAdapter("pulsing")
fun setPulsing(target: View, isVisible: Boolean) {
    val animationRotateCenter = AnimationUtils.loadAnimation(
        target.context, R.anim.pulsing
    )
    if (isVisible) target.startAnimation(animationRotateCenter) else View.GONE

}

