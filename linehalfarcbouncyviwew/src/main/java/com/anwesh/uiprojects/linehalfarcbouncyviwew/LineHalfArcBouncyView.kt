package com.anwesh.uiprojects.linehalfarcbouncyviwew

/**
 * Created by anweshmishra on 03/01/20.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.02f / lines
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.CYAN
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse()).toFloat()
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawLineHalfArc(i : Int, scale : Float, size : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify().divideScale(i, lines)
    save()
    scale(1f, 1f - 2 * i)
    drawLine(0f, h , 0f, h + (size - h) * sf, paint)
    restore()
}

fun Canvas.drawLineHalfArcs(scale : Float, size : Float, h : Float, paint : Paint) {
    for (j in 0..(lines - 1)) {
        drawLineHalfArc(j, scale, size, h, paint)
    }
}

fun Canvas.drawLHANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(gap * (i + 1), h / 2)
    drawLineHalfArcs(scale, size, h / 2, paint)
    restore()
}

class LineHalfArcBouncyView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}