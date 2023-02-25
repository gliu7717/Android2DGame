package com.example.android2dgame

import android.graphics.Canvas
import androidx.core.content.ContextCompat

public abstract  class GameObject (x:Float, y:Float){
    var positionX = x
    var positionY = y
    var velocityX = 0f
    var velocityY = 0f
    public abstract fun  draw(canvas: Canvas)
    public abstract fun  update()

}