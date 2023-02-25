package com.example.android2dgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.content.ContextCompat



class Player (c:Context, x: Float, y:Float, r: Float){
    val  SPEED_PIXELS_PER_SECOND = 400f
    val MAX_SPEED = SPEED_PIXELS_PER_SECOND / 30f  // GameLoop.MAX_UPS
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

    fun update(joystick: Joystick ) {
        var velocityX = joystick.getAacuatorX()*MAX_SPEED
        var velocityY = joystick.getAacuatorY()*MAX_SPEED
        positionX += velocityX
        positionY += velocityY
    }

    fun setPosition(x: Float, y: Float) {
        positionX= x
        positionY = y
    }

}
