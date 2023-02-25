package com.example.android2dgame

import android.content.Context
import androidx.core.content.ContextCompat


class Player (c:Context, joystick: Joystick, x: Float, y:Float, r: Float) :
        Circle(c, ContextCompat.getColor(c, R.color.player), x,y, r){
    val  SPEED_PIXELS_PER_SECOND = 400f
    val MAX_SPEED = SPEED_PIXELS_PER_SECOND / 30f  // GameLoop.MAX_UPS
    var joystick = joystick


    fun setPosition(x: Float, y: Float) {
        positionX= x
        positionY = y
    }


    override fun update() {
        super.update()
        velocityX = joystick.getAacuatorX()*MAX_SPEED
        velocityY = joystick.getAacuatorY()*MAX_SPEED
        positionX += velocityX
        positionY += velocityY
    }


}
