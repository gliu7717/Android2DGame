package com.example.android2dgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.content.ContextCompat

class Player (c:Context, x: Float, y:Float, r: Float){
    var positionX = x
    var positionY = y
    var radius = r
    var paint = Paint()
    var context = c
    fun draw(canvas: Canvas?) {
        if (canvas != null) {
            var color = ContextCompat.getColor(context, R.color.player)
            paint.setColor(color)
            canvas.drawCircle(positionX, positionY, radius, paint)
        }
    }

    fun update() {

    }

    fun setPosition(x: Float, y: Float) {
        positionX= x
        positionY = y
    }

}
