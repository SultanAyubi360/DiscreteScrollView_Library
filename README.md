# DiscreteScrollView
The library is a RecyclerView-based implementation of a scrollable list, where current item is centered and can be changed using swipes.
It is similar to a ViewPager, but you can quickly and painlessly create layout, where views adjacent to the currently selected view are partially or fully visible on the screen. 

A scrollable list of items that centers the current element and provides easy-to-use APIs for cool item animations.

<div align="center">
	
[![](https://jitpack.io/v/SultanAyubi360/DiscreteScrollView_Library.svg)](https://jitpack.io/#SultanAyubi360/DiscreteScrollView_Library/1.0)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)  ![Kotlin](https://img.shields.io/badge/Kotlin-100%25-brightgreen)

</div>


## ✨ Screenshots

<kbd>
 
</kbd>


## Usage

### Step 1

#### In older Gradle Style (Build.gradle (project level))
```
allprojects {
  repositories {
    ...
    maven { url "https://maven.google.com" }
    maven { url "https://jitpack.io" }
    maven { url "https://repo.grails.org/grails/core/" }
  }
}
```

#### In New Project Structure (Settings.gradle)
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ......
        maven { url "https://maven.google.com" }
        maven { url "https://jitpack.io" }
        maven { url "https://repo.grails.org/grails/core/" }
        .....
    }
}
```

### Step 2

Include the library as a local library project or add the dependency in your build.gradle.

# For groovy DSL

```
dependencies {
   implementation 'com.github.SultanAyubi360:DiscreteScrollView_Library:1.0'
}
```

# For Kotlin DSL


```
dependencies {
    implementation ("com.github.SultanAyubi360:DiscreteScrollView_Library:1.0")
}
```

---

## Using DiscreteScrollView Library

The GitHub project source includes a sample application, that is used for demonstrating the various features currently supported by this library. Once the library is added to your project, you can
include the DiscreteScrollView into your activity/fragment layout using the following code snippets.

The library uses a custom LayoutManager to adjust items' positions on the screen and handle scroll, however it is not exposed to the client 
code. All public API is accessible through DiscreteScrollView class, which is a simple descendant of RecyclerView.

If you have ever used RecyclerView - you already know how to use this library. One thing to note - you should NOT set LayoutManager.



## Reporting an issue

If you are going to report an issue, I will greatly appreciate you including some code which I can run to see the issue. By doing so you maximize the chance that I will fix the problem. 
By the way, before reporting a problem, try replacing DiscreteScrollView with a RecyclerView. If the problem is still present, it's likely somewhere in your code.


## Find this library useful? :heart:

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it. :coffee: :hamburger: :fries: :apple:

Support it by joining stargazers to this. ⭐

Also, [follow me on GitHub](https://github.com/SultanAyubi360) for my next creations! 🤩



