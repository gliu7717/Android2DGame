package com.example.android2dgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class Game(context: Context) : SurfaceView(context), SurfaceHolder.Callback  {
    private var surfaceHolder : SurfaceHolder = holder
    private var gameLoop= GameLoop(this, surfaceHolder)
    private lateinit var player : Player
    private lateinit var joystick : Joystick
    init {
        holder.addCallback(this)
        gameLoop = GameLoop(this, surfaceHolder)
        player = Player(context, 1000f, 500f, 30f)
        joystick = Joystick(275f, 700f,70f, 40f)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            if (event.action == MotionEvent.ACTION_DOWN)
            {
                if(joystick.isPressed(event.getX()  ,  event.getY())){
                    joystick.setIsPressed(true)
                }
                return true
                // player.setPosition( event.getX()  ,  event.getY())
            }
            else if (event.action == MotionEvent.ACTION_MOVE)
            {
                if(joystick.getIsPressed()){
                    joystick.setActuator(event.getX()  ,  event.getY())
                }
                return true
            }
            else if (event.action == MotionEvent.ACTION_UP){
                joystick.setIsPressed(false)
                joystick.resetActuator()
                return true
            }
        }

        return super.onTouchEvent(event)
    }
    override fun surfaceCreated(p0: SurfaceHolder) {
        gameLoop.startLoop()
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        drawUPS(canvas)
        drawFPS(canvas)
        player.draw(canvas)
        joystick.draw(canvas)
    }
    public fun drawUPS(canvas: Canvas?){
        var averageUPS : String
        averageUPS =gameLoop.getAverageUPS().toString()
        var paint = Paint()
        var color = ContextCompat.getColor(context, R.color.magenta)
        paint.color = color
        paint.textSize = 60F
        if (canvas != null) {
            canvas.drawText("UPS: " + averageUPS,100f, 100f,paint)
        }
    }
    public fun drawFPS(canvas: Canvas?){
        var averageFPS : String
        averageFPS =gameLoop.getAverageFPS().toString()
        var paint = Paint()
        var color = ContextCompat.getColor(context, R.color.magenta)
        paint.setColor(color)
        paint.textSize = 60F
        if (canvas != null) {
            canvas.drawText("FPS: " + averageFPS,100f, 200f,paint)
        }
    }

    fun update() {
        player.update(joystick)
        joystick.update()
    }
}
