# Migrating to new navigation types

Improve navigation behaviour in your app by replacing navigation views with navigation stacks and navigation split views.

## Overview

If your app has a minimum deployment target of iOS 16, iPadOS 16 transition away from using **NavigationView**. In it's place, use **NavigationStack** and **NavigationSplitView** instances.

## Update Single Column Navigation

If your app is using a **NavigationView** that you style using the **stack** navigtation view, where people navigate by pushing a new view onto a stack, switch to **NavigationStack**.

In particular stop doing this:

```swift
# DEPRECATED
NavigationView {
    /** content **/
}
.navigationViewStyle(.stack)
```

Instead, create a navigation stack:

```swift
NavigationStack {
    /** content **/
}
```

- - - 

## Update Multicolumn navigation

If your app uses a two or three column **NavigationView** or for apps that have multiple columns in some cases and a single column in others, switch to **NavigationSplitView**

Instead of using a two column navigation view:

```swift
NavigationView {
    /* column 1 */
    /* column 2 */
}
```

Create a navigation split view that has explicit sidebar and detail content using the `init(sidebar: detail:)` initializer

```swift
NavigationSplitView {
    //side bar view
} detail: {
    //detail view
}

Similarly, instead of using a three column view...

```swift
NavigationView {
    /* column 1 */
    /* column 2 */
    /* column 3 */
}
```

Create a navigation split view that has explicit `side bar`, `content` and `detail` components:

```swift
NavigationSplitView {
    /* column 1 */
} content: {
    /* column 2 */
} detail: {
    /* column 3 */
}
```

> If you need a `navigation within a column` embed a navigation stack in that column. This arragment provides finer control over what each column displays.

- - -

## Update programmatic navigation



