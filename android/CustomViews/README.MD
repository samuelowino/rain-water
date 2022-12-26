# Building Android Custom Views

# APIs

1. View
2. ViewGroup
3. MeasureSpec
4. Canvas
5. Paint
6. ViewGroup.LayoutParams
7. Bitmap
8. Path
9. Rect
10. BitmapFactory
11. PathEffect, ComposePathEffect, CornerPathEffect, DashPathEffect, DiscretePathEffect, PathDashPathEffect


# View | android.view.View

This class represents the basic building blocks for user interface components.
A view occupies a rectangular area on the screen and is responsible for drawing and event handling.

View is the base class for **widgets**, which are responsible for creating interactive UI components **(buttons,text fields, text views etc.)**.

> The **ViewGroup** subclass is the base class for layouts, which are invisible containers that hold other views or other ViewGroups and define their layout properties.

## Using Views

All of the views in a window are arranged in a single tree.

Once you have created a tree of views, there are typically a few types of common operations you may wish to perform:

* **Set properties** 

* **Set focus**

* **set up listeners**

* **set visibility**

- - -

# Canvas

The Canvas class holds the "draw" calls. 

To draw something, you need 4 basic components:

1. A **Bitmap** to hold the pixels
2. A **Canvas** to host the draw calls.
3. A **drawing primitive** e.g Rect, Path, text, Bitmap
4. A **paint** to describe the colors and style for the drawing

- - -

# Paint

Paint class holds the style and color information about how to draw geometrics, text and bitmaps.

- - -

# Path

The Path class encapsulates compound geometric paths consisting of **straight line segments**, **quadratic curves** and **cubic curves**.

It can be drawn with **canvas.drawPath(Paint, paint)**, either filled or stroked or it can be used for clipping or to draw text on a path.

```java
addArc()

addCircle()

addOval()

addPath()

addRect()

addRoundedRect()

moveTo()

lineTo()

arcTo()

cubicTo()
```






