package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class NewView (context: Context, attrs: AttributeSet) : View(context, attrs) {

    //paint object for colouring and styling
    private val paint =  Paint (Paint.ANTI_ALIAS_FLAG)
    private val mouthPath = Path()

    //some colours for mouth, eyes, background
    private var faceColor = Color.YELLOW
    private var eyeColor = Color.BLACK
    private var mouthColour = Color.BLACK
    private var borderColor = Color.BLACK

    //Face border width in pixels
    private var borderWidth = 4.0f

    //View size in pixels
    private var size = 320



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        //Set the paint color to the faceColor and make it fill the drawing area.
        paint.color = faceColor
        paint.style = Paint.Style.FILL


        val radius = size / 2f
        //calculate the radius for the circle

        canvas.drawCircle(size / 2f, size / 2f, radius, paint)
        //Draw the background circle with a center of (x,y), where x and y are equal to the half of size, and with the calculated radius.

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        //draw a border around the drawing area using stroke

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
        //Draw a border with the same center but with a radius shorter than the previous radius by the borderWidth.
    }

    private fun drawEyes(canvas: Canvas) {
        paint.color = eyeColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)

        canvas.drawOval(leftEyeRect, paint)

        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)

        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        mouthPath.moveTo(size * 0.22f, size * 0.7f)

        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)

        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)

        paint.color = mouthColour
        paint.style = Paint.Style.FILL

        canvas.drawPath(mouthPath, paint)
    }


}

