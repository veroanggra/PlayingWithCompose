# Play with Compose

## Overview

```
This project contains a collection of several codelabs related to Jetpack Compose. 
Each branch is a codebase from a different project. Apart from that, 
each project has a tutorial that contains the project development process. 
So that it is expected to be able to help readers understand the development process of each project.
```

## Chapter
### [Chapter 1] Migrating Existing View
```
One of the great things about Compose is Interoperability with XML, 
so it's possible to have a compose component inside a ViewGroup. 
In this series I discuss the process of migrating View into Custom Widgets and embedding 
them into ViewGroups with ComposeView components. This series is perfect for starting to learn 
how to build UI with compose. There are 4 part : Compose Introduction, 
Setup Existing Project to Compose Migrate, Build Custom Widget, and Implementing ComposeView. 
```
<pre>
<img src="https://github.com/veroanggra/MigratingToComposeSample/blob/master/screenshoot/pict1.png" alt="pict1" width="200" height="450"/>
</pre>

Branch Detail
1. Branch ***before-migrate*** as starter code
2. Branch ***after-migrate-composeview*** as result code

Tutorial
* [Part1](https://medium.com/@veroanggra/part-1-jetpack-compose-introduction-cf5bcfa43ddd) - Jetpack Compose(Introduction)
* [Part2](https://medium.com/@veroanggra/part-2-jetpack-compose-preparing-to-migrate-existing-layout-to-compose-74e07d136745) - Jetpack Compose(Preparing to Migrate Existing Layout to Compose)
* [Part3](https://veroanggra.medium.com/part-3-jetpack-compose-migration-of-component-view-input-text-on-existing-layout-110731d584cb) - Jetpack Compose(Migration of Component View (Input Text) on Existing Layout)
* [Part4](https://veroanggra.medium.com/part-4-jetpack-compose-implementing-a-compose-view-in-a-viewgroup-d6b9873a4c94) - Jetpack Compose(Implementing a Compose View in a ViewGroup)

### [Chapter 2] Basic Layout
```
Build UI with modern framework like Compose based on declarative paradigm
makes the UI building process easier and faster, because it is enough to describe
the desired appearance in a Composable Function which is written like a function 
and Compose will handle it behind the scenes. To make it easier to understand this concept, 
I write this article that specifically discuss about 3 basic components to Build Layout in Compose. 
```
<pre>
<img src="https://github.com/veroanggra/MigratingToComposeSample/blob/master/screenshoot/pict2.png" alt="pict2" width="200" height="450"/>
</pre>

Branch Detail
1. Branch ***arrange-column*** for Column Sample
2. Branch ***row-arrange*** as Row Sample
3. Branch ***box-arrange*** as Box Sample
4. Branch ***wallpaper-app*** as Wallpaper UI (Column, Row, Box)

Tutorial
* [Part1](https://medium.com/@veroanggra/building-basic-layouts-in-jetpack-compose-column-row-and-box-d3cff763d4db) - Building Basic Layouts (Column, Row, and Box)

### [Chapter 3] Constraint Layout
```
ConstraintLayout is a layout manager that allows you to create complex layouts 
by defining constraints between views. In Compose, you can use ConstraintLayout 
to create layouts using a similar approach. 
```

<pre>
<img src="https://github.com/veroanggra/PlayingWithCompose/blob/master/screenshoot/pict3.png" alt="pict2" width="200" height="450"/>
<img src="https://github.com/veroanggra/PlayingWithCompose/blob/master/screenshoot/pict4.png" alt="pict2" width="200" height="450"/>
</pre>

Branch Detail
1. Branch ***basic-constraint*** for Basic Constraint Layout
2. Branch ***handpicked-app*** for Complex Contraint Page Sample

Tutorial
* [Part1](https://veroanggra.medium.com/explore-constraint-layout-on-jetpack-compose-bb45e489b07) - Explore Constraint Layout on Jetpack Compose



## Author

* **Veronica Putri Anggraini**

Feel free to follow me, fork and give me a ⭐


## License

```
Copyright (c) 2023 Veronica Putri Anggraini

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
```