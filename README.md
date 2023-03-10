# AndroidDateTimeUtils
![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23)


This is a simple VKSearchableDialog library that helps you to implement your list in searchview dialog.

SearchableDialog is a dialog with the search feature which allows to search the items loaded in the spinner.

## Features

- You can set your list in searchview dialog.
- SearchableDialog allows to search the items loaded in the dialog.

# How it works:

## Gradle Dependency

-  Add the JitPack repository to your project's build.gradle file

```groovy
    allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Add the dependency in your app's build.gradle file

```groovy
    dependencies {
    implementation 'com.github.TecOrb-Developers:AndroidDateTimeUtils:v1.0.4'
}
```

## How to use this library function

### 1. setup SearchableDialog

First you have to initialize the SearchableDialog like below

```
val searchableDialogOS = SearchableDialog(context)  // initialize the dialog
searchableDialogOS.windowTitle = "Select/Search Android OS"  // set the dialog window title
searchableDialogOS.setSpinnerListItems(loadOSNameList(osList))  // load the string type list into dialog
```

### 2. setup ClickListener for showing the dialog

```
searchableDialogOS.show() // use it for showing the dialog on click on any view
```

### 3. setup onItemSelectedListener

This is used for onItemSelectedListener and set the selected value into your required view.
```
searchableDialogOS.onItemSelectedListener = object : OnItemSelectedListener {
	override fun setOnItemSelectedListener(position: Int, selectedOsName: String) {
		binding.tvSelectedOS.text = selectedOsName
	}
}
```

# Developers

MIT License

Copyright (c) 2019 TecOrb Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
