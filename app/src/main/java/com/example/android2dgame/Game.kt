package com.example.android2dgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class Game(context: Context) : SurfaceView(context), SurfaceHolder.Callback  {
    private var surfaceHolder : SurfaceHolder = holder
    private var gameLoop= GameLoop(this, surfaceHolder)
    init {
        holder.addCallback(this)
        gameLoop = GameLoop(this, surfaceHolder)
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
    }
}
