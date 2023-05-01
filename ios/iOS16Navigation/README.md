# Migrating to new navigation types

Improve navigation behaviour in your app by replacing navigation views with navigation stacks and navigation split views.

## Overview

If your app has a minimum deployment target of iOS 16, iPadOS 16 transition away from using **NavigationView**. In it's place, use **NavigationStack** and **NavigationSplitView** instances.

## Update Single Column Navigation

If your app using a **NavigationView** that you style using the **stack** navigtation view, where people navigate by pushing a new view onto a stack, switch to **NavigationStack**.

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



