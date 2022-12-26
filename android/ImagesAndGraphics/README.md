# Android Image and Graphics

When you want to display static images in your app, you can use the **Drawable** class and its subclasses to draw shapes and images.

> A **Drawable** is a general abstraction for something that can be drawn.

Unlike a view, a drawable does not have any facility to receive events or otherwise interact with the user.

Drawables may take a variety of forms:

* **Bitmap**: the simplest Drawable, a PNG or JPEG image.
* **Nine Patch**: an extension to the PNG format allows it to specify information about how to stretch it and place things inside of it.
* **Vector**: a drawable defined in an XML file as a set of points, lines and curves along with its associated color information. The type of drawable can be scaled without loss of display quality.
* **Shape**: contains simple drawing commands instead of a raw bitmap, allowing it to resize better in some cases.
* **Layers**: a compound drawable, which draws multiple underlying drawables on top of each other.
* **States**: a compound drawable that selects one of a set of drawables based in its state.
* **Levels**: a compound drawable that selected one of a set of drawables based in its level.
* **Scale**: a compound drawable with a single drawable, whose overall size is modified based on the current level.

## Custom drawables

All versions of Android allow the Drawable class to be extended and used at run time in place of framework-provided drawable classes. Starting in API 24, custom drawable classes may also be used in XML.

At a minimum, custom drawable classes must implement the abstract method on Drawable and should override the Drawable#draw(Canvas) method to draw content.


## Create drawables from resource images

You can add graphics to your app by referencing an image file from your project resources.
Supported file types include PNP, JPG and GIF.

> **Note**: Image resources placed in the *res/drawable/* directory may ne automatically optimized with lossless image compression by the **aapt** tool during the build process.

```java
ImageView image = new ImageView(this);
image.setImageResource(R.drawable.cow_picture);
```

In some other cases, you may want to handle your image resource as a drawable object, as show:

```java
Resource res = context.getResource();
Drawable image = ResourceCompat.getDrawble(res, R.drawable.cow_picture, null);
```

You can add the drawable in XML like so:

```xml
<ImageView 
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/cow_picture"
    android:contentDescription="@string/cow_picture_image_desc"
/>
```
## TransitionDrawable
An extension of a LayerDrawable that is intended to cross-fade between the first and second layer.
To start the transition, call **startTransition(int)**.

To display just the first layer, call **resetTransition()**.

It can be defined in an XML file with the <transition> element. Each drawable in the transition is defined in a nested <item>.

```xml
<transition xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawble="@drawable/image_play"/>
    <item android:drawble="@drawable/image_pause"/>
</transition>
```
Retrieve and instantiate the object by calling **Resources#getDrawable()** and passing the resource ID of your XML file. Any drawable subclass that supports the inflate() method can be defined in XML and instantiated by your app.

```java
Resources res = context.getResources();
TransitionDrawable transition =
        (TransitionDrawable) ResourceCompat.getDrawable(res, R.drawable.pause_play_transition, null);

ImageView image = findViewById(R.id.play_toggle_image);
image.setImageDrawable(transition);

transition.startTransition(1000);
```


