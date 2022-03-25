challenge-three
===============

Shows how to use Navigation to perform navigation in Kotlin.

Features
--------

This sample showcases the following features of the Navigation component:

 * Navigating via actions
 * Transitions
 * [Returning a result to the previous Destination][11]
 * Arguments (Pass data between destinations with [Parcelable][10])

![](https://github.com/ahmadso120/challenge-three/blob/master/screenshot/challenge-3-sample.gif?raw=true)

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions.
  * [Android KTX][1] - Write more concise, idiomatic Kotlin code.
* [Architecture][3] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [View Binding][4] - Declaratively bind observable data to UI elements.
  * [Navigation][5] - Handle everything needed for in-app navigation.
* [UI][6] - Details on why and how to use UI Components in your apps - together or separate
  * [Animations & Transitions][7] - Move widgets and transition between screens.
  * [Fragment][8] - A basic unit of composable UI.
  * [Layout][9] - Lay out widgets using different algorithms.

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/kotlin/ktx
[3]: https://developer.android.com/jetpack/arch/
[4]: https://developer.android.com/topic/libraries/view-binding
[5]: https://developer.android.com/topic/libraries/architecture/navigation/
[6]: https://developer.android.com/guide/topics/ui
[7]: https://developer.android.com/training/animation/
[8]: https://developer.android.com/guide/components/fragments
[9]: https://developer.android.com/guide/topics/ui/declaring-layout
[10]: https://developer.android.com/kotlin/parcelize
[11]: https://developer.android.com/guide/navigation/navigation-programmatic#returning_a_result
