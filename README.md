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
  <img src="https://i.ibb.co/FbQzjMz/Screenshot-20241119-162242.jpg" width=30% height=30%/>
  <img src="https://i.ibb.co/jHZYkgd/Screenshot-20241119-162215.jpg.jpg" width=30% height=30%/>
  <img src="https://i.ibb.co/SxRVgPp/Screenshot-20241119-162522.jpg" width=30% height=30%/>
  <img src="https://i.ibb.co/J2DYZvb/Screenshot-20241119-163523.jpg" width=30% height=30%/>
  <img src="https://i.ibb.co/qr0xhFt/Screenshot-20241119-163835.jpg" width=30% height=30%/>
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
