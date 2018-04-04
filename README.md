# CameleonLayout
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<br>
A library that let you implement double-layer-layout changing with slide animation.

![gif0](https://user-images.githubusercontent.com/24237865/38308278-8df0398e-3851-11e8-8f08-a53fad45b50a.gif)

## Including in your project
#### build.gradle
```java
dependencies {
  implementation "com.github.skydoves:cameleonlayout:1.0.0"
}
```

## Usage
Could be used just like using normal Layout.

```java
cameleonLayout.drawSecondLayout() // start drawing second layout
```

### FilledStatusListener
Invoked when CameleonLayout's status is changed.

```kotlin
override fun onFilledStatusChanged(status: FilledStatus) {
   when(status) {
      is FilledStatus.UnFilled ->  Toast.makeText(this, "unFilled", Toast.LENGTH_SHORT).show()
      is FilledStatus.Loading ->  Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
      is FilledStatus.Filled -> Toast.makeText(this, "Filled", Toast.LENGTH_SHORT).show()
   }
}
```

### onClickListener
CameleonLayout onClickListener. It provides FilledStatus.

```kotlin
override fun onClick(status: FilledStatus) {
    when(status) {
       is FilledStatus.UnFilled -> cameleonLayout.drawSecondLayout()
       is FilledStatus.Loading ->  Toast.makeText(this, "clicked onLoading", Toast.LENGTH_SHORT).show()
       is FilledStatus.Filled -> Toast.makeText(this, "clicked onFilled", Toast.LENGTH_SHORT).show()
   }
}
```

### XML layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<com.skydoves.cameleonlayout.CameleonLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/cameleonLayout1"
    android:layout_width="140dp"
    android:layout_height="110dp"
    android:background="@drawable/gradient_purple"
    android:layout_gravity="center_horizontal"
    android:layout_marginTop="15dp"
    app:secondLayout="@layout/layout_thumbnail1"
    app:maxProgress="100"
    app:density="2"
    app:duration="1000"
    app:delay="2000"
    app:autoUnFill="true"
    app:drawOnBack="false">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/black"
            android:alpha="0.6"/>

        <TextView
            android:id="@+id/item_episode_coin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@android:color/white"
            android:text="glance"
            android:layout_centerInParent="true"
            android:textStyle="bold"
            android:textSize="25sp"/>
    </RelativeLayout>
</com.skydoves.cameleonlayout.CameleonLayout>
```

#### Methods
Methods | Return | Description
--- | --- | ---
setSecondLayout(int layout) | void | set the second layout.
setSecondLayout(View view) | void | set the second layout.
updateProgress(Float progress) | void | update progress manually.
drawSecondLayout() | void | start drawing the second layout gradually.
eraseSecondLayout() | void | erase the second layout gradually.

#### Attributes
Attributes | Default | Description
--- | --- | ---
secondLayout | null | set the second layout.
maxProgress | 100 | set the max progress.
density | 1 | decide the filling unit.
duration | 3000(millisec) | decide filling & unfilling duration.
delay | 2000(millisec) | delaying time after being filled. autoUnFill should be 'true'.
autoUnFill | true | invoke eraseSecondLayout automatically when Filled and delay.
drawOnBack | false | draw the second layout behind the CameleonLayout's children.


# License
```xml
Copyright 2018 skydoves

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
