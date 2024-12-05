# DiscreteScrollView
The library is a RecyclerView-based implementation of a scrollable list, where current item is centered and can be changed using swipes.
It is similar to a ViewPager, but you can quickly and painlessly create layout, where views adjacent to the currently selected view are partially or fully visible on the screen. 

A scrollable list of items that centers the current element and provides easy-to-use APIs for cool item animations.

<div align="center">
	
[![](https://jitpack.io/v/SultanAyubi360/DiscreteScrollView_Library.svg)](https://jitpack.io/#SultanAyubi360/DiscreteScrollView_Library/1.0)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)  ![Kotlin](https://img.shields.io/badge/Kotlin-100%25-brightgreen)

</div>


## ✨ Sample Videos

<kbd>

<video src="https://github.com/user-attachments/assets/5f5e2343-38b5-453e-85aa-f7843b2982ba" width="30" height="40" /> 

</kbd>

<kbd>

<video src="https://github.com/user-attachments/assets/cf23d16b-7f59-4db6-8d14-10d36f46b26c" width="30" height="40" />

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

### Step 3

Add DiscreteScrollView to your layout either using xml or code:Add the following xml to your layout file.You can use the DiscreteScrollView in following manner:

#### In XML:

```
 <com.sultanayubi.discretescrollviewlibrary.DiscreteScrollView
        android:id="@+id/item_picker"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/galleryBg"
        app:dsv_orientation="vertical" /> <!-- orientation is optional, default is horizontal -->

```
---

### Step 4

Reference the View in Kotlin code.

```
DiscreteScrollView itemPicker = findViewById(R.id.item_picker); <!-- Using Find View By Id -->
DiscreteScrollView itemPicker = binding.itemPicker; <!-- Using View Binding -->


Gallery gallery = Gallery.get(); <!-- Using Gallery class have this method -->
List<Image> data = gallery.getData(); <!-- getData method inside Gallery class -->

itemPicker.setAdapter(new GalleryAdapter(data)); <!-- giving list to our adapter -->

```

#### General
```
scrollView.setOrientation(DSVOrientation o); //Sets an orientation of the view
scrollView.setOffscreenItems(count); //Reserve extra space equal to (childSize * count) on each side of the view
scrollView.setOverScrollEnabled(enabled); //Can also be set using android:overScrollMode xml attribute
```
#### Related to the current item:
```
scrollView.getCurrentItem(); //returns adapter position of the currently selected item or -1 if adapter is empty.
scrollView.scrollToPosition(int position); //position becomes selected
scrollView.smoothScrollToPosition(int position); //position becomes selected with animated scroll
scrollView.setItemTransitionTimeMillis(int millis); //determines how much time it takes to change the item on fling, settle or smoothScroll

```

#### Transformations
One useful feature of ViewPager is page transformations. It allows you, for example, to create carousel effect. DiscreteScrollView also supports 
page transformations.

```
scrollView.setItemTransformer(transformer);
Because scale transformation is the most common, I included a helper class - ScaleTransformer, here is how to use it:

 itemPicker.setItemTransformer(new ScaleTransformer.Builder()
  .setMaxScale(1.05f) 
  .setMinScale(0.8f) 
  .setPivotX(Pivot.X.CENTER) // CENTER is a default one
  .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
  .build());

```
#### Slide through multiple items

To allow slide through multiple items call:
```
scrollView.setSlideOnFling(true);

```
Lower the threshold, more fluid the animation. You can adjust the threshold by calling:
```

scrollView.setSlideOnFlingThreshold(value);

```
#### Infinite scroll
  
Infinite scroll is implemented on the adapter level:
```

InfiniteScrollAdapter wrapper = InfiniteScrollAdapter.wrap(yourAdapter);
scrollView.setAdapter(wrapper);
```
An instance of `InfiniteScrollAdapter` has the following useful methods:
```
int getRealItemCount();

int getRealCurrentPosition();

int getRealPosition(int position);

/*
 * You will probably want this method in the following use case:
 * int targetAdapterPosition = wrapper.getClosestPosition(targetPosition);
 * scrollView.smoothScrollTo(targetAdapterPosition);
 * To scroll the data set for the least required amount to reach targetPosition.
 */
int getClosestPosition(int position);

```
Currently `InfiniteScrollAdapter` handles data set changes inefficiently, so your contributions are welcome. 

#### Disabling scroll
It's possible to forbid user scroll in any or specific direction using:

```
scrollView.setScrollConfig(config);

```

Where `config` is an instance of `DSVScrollConfig` enum. The default value enables scroll in any direction.

#### Callbacks

* Scroll state changes:
```
scrollView.addScrollStateChangeListener(listener);
scrollView.removeScrollStateChangeListener(listener);

```

* Scroll:
```
scrollView.addScrollListener(listener);
scrollView.removeScrollListener(listener);

public interface ScrollListener<T extends ViewHolder> {
  //The same as ScrollStateChangeListener, but for the cases when you are interested only in onScroll()
  void onScroll(float scrollPosition, int currentIndex, int newIndex, @Nullable T currentHolder, @Nullable T newCurrentHolder);
}

```
* Current selection changes:
```

scrollView.addOnItemChangedListener(listener);
scrollView.removeOnItemChangedListener(listener);

```

---

## Reporting an issue

If you are going to report an issue, I will greatly appreciate you including some code which I can run to see the issue. By doing so you maximize the chance that I will fix the problem. 
By the way, before reporting a problem, try replacing DiscreteScrollView with a RecyclerView. If the problem is still present, it's likely somewhere in your code.


## Find this library useful? :heart:

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it. :coffee: :hamburger: :fries: :apple:

Support it by joining stargazers to this. ⭐

Also, [follow me on GitHub](https://github.com/SultanAyubi360) for my next creations! 🤩

