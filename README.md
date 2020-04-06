# cs1302-ce20 Fancy ImageApp

![Approved for: Spring 2020](https://img.shields.io/badge/Approved%20for-Spring%202020-blue)
![Instruction: Online](https://img.shields.io/badge/Instruction-Online-important)

> The artist is the creator of beautiful things.
> **-- Oscar Wilde, _The Picture of Dorian Gray_**

This class exercise continues the development a GUI app using the JavaFX library. Students
will continue to create an interactive GUI that loads an image from a specified URL and allows
the user to perform different zooming operations. Construction of this app requires students
to utilize their knowledge of inheritance, polymorphism, interfaces, and API documentation
lookup.

## Course-Specific Learning Outcomes

* **LO2.e:** (Partial) Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO7.a:** (Partial) Design and implement a graphical user interface in a software project.

## References and Prerequisites

* [CSCI 1302 JavaFX 8 Bookmarks and Notes](http://cobweb.cs.uga.edu/~mec/cs1302/gui/)
* [CSCI 1302 JavaFX Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Nike server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Nike into a subdirectory called `cs1302-ce20`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce20.git
   ```

### Exercise Steps

1. Copy over your work from the `src/cs1302/ce19` directory of `cs1302-ce19`
   into the `src/cs1302/ce20` directory of `cs1302-ce20` and update the package
   statements accordingly (i.e., make sure the package is `cs1302.ce20`). 
   **You should create `src/cs1302/ce20` if it does not exist.**
   
1. If you did not finish **cs1302-ce19**, then finish the work required for 
   [cs1302-ce19](https://github.com/cs1302uga/cs1302-ce19)
   in the code you just copied over. 
   
1. **Compile and run your code without any errors or warnings.**

1. Make sure your code passes the `checkstyle` audit then stage and commit your changes.
   
1. Consider the following screenshot and associated containment heirarchy:

   <table>
   <tr>
      <td><img src="http://cobweb.cs.uga.edu/~mec/cs1302/cs1302-ce20-screenshot.png"></td>
      <td><pre><code>            Stage
                 |
               Scene
                 |
               VBox
                 |
               /---\---------\
              /     \         \
            HBox  ImageView  HBox
            / \               |
           /   \            /---\-----\
    TextField  Button      /     \     \
                      Button Button Button
                      /      /           \
                 ImageView ImageView ImageView</code></pre></td>
   </tr>
   </table>
   
   Each node corresponds to an object of some class under the 
   [`javafx`](https://docs.oracle.com/javase/8/javafx/api/toc.htm)
   package. The diagram for the scene graph assumes that child nodes
   are added to their parents in a left-to-right order.
   Here are some additional notes:
   
   * The textfield is expected to grow with its parent `HBox`.
   
   * The three buttons at the bottom should grow to fill their enclosing `HBox`. Buttons require an
     extra step that was not needed with textfields. To get this to work, make sure you read and 
     understand all of the starter code in the 
     [`Hbox` Documentation](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html)
   
   * The three `ImageView` objects associated with the `Button` objects 
      via each `Button` object's `graphic` property. 

   * The icons for the associated images are contained in the `resources` directory 
     provided with this exercise. To use these local files in your `ImageView`, you
     can use a relative `file:` URL, e.g., `file:resources/image.png` -- this will only work
     if resources is in the present working directory when the app is run.
          
   * The stage should NOT be resizable by the user via dragging the window corner.
   
1. Update your code so that it has the same scene graph and visual
   appearance provided in the previous step. The three new buttons below the main `ImageView` 
   object are not supposed to function for this checkpoint. 
   **Recompile before continuing.**
   Also, make sure your code passes the `checkstyle` audit, then stage and commit all changes.

If you completed the steps correctly, your app should look similar to
the screenshot provided above. Congratulations on a good looking app!
   
![CP](https://img.shields.io/badge/Checkpoint-1-success?style=for-the-badge)

1. Now that you have your app looking good, let's make it do stuff. Add
   the functionality listed below to your app. You will
   need to consult the API documentation for the 
   [`ImageView`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html)
   and
   [`Button`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)
   classes to determine the appropriate property to change.
   **Please read all of the bullet points below as well as the recommendations before writing any code.**

   * __Zoom In:__
     The first button (i.e., the one with [`zoom-in-50.png`](resources/zoom-in-50.png))
     should _increase_ the size of the main `ImageView` object by some fixed amount.
     
     * If clicking this button causes the size to increase to an amount such that a 
       subsequent click would cause the `ImageView` size to exceed twice the size of the 
       underlying `Image`, then disable the button. If the second button (i.e., for
       zooming out) is disabled, then enable it.

   * __Zoom Out:__
     The second button (i.e., the one with [`zoom-out-50.png`](resources/zoom-out-50.png))
     should _decrease_ the size of the main `ImageView` object by some fixed amount. 
     
     * If clicking this button causes the size to decrease to an amount such that a 
       subsequent click would cause the `ImageView` size to become negative, then 
       disable the button. If the first button (i.e., for
       zooming in) is disabled, then enable it.

   * __Actual Size:__
     The third button (i.e., the one with [`actual-size-50.png`](resources/actual-size-50.png))
     should return the main `ImageView` object to its default size. This can be accomplished by changing the size 
     of the `ImageView` object to the same size as the `Image` object it displays. 
     
     * If either of the other buttons (i.e., for zooming in / zooming out) are disabled, 
       then enable them.
     
   Recommendations:
   
   * Instead of writing the zoom in / zoom out logic entirely in separate lambda expressions,
     write a `private` zoom method that takes your fixed zoom amount as a positive or negative 
     `double` and simply have the lambdas for your event handlers call that method with the
     appropriate value. For example: 
     
     ```java
     someButton.setOnAction(e -> zoom(+25));
     ```
     
   * Carefully read the entire API documentation, including default values, for the following 
     `ImageView` properties:
     [`fitHeight`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#fitHeightProperty)
     and
     [`preserveRatio`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#preserveRatioProperty).
     Carefully considering how these properties impact an `ImageView` can lead to more concise
     and readable code.
   
1. **Recompile before continuing.**
   Also, make sure your code passes the `checkstyle` audit, then stage and commit all changes.
     
If you completed the steps correctly, your app should not only look 
similar to the screenshot provided above, but it has the desired
functionality. Congratulations on a good looking, functional app!
        
![CP](https://img.shields.io/badge/Checkpoint-2-success?style=for-the-badge)

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside this exercise
   directory with the following information:

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. The weekly code (listed with the exercise on eLC).
   
   Here is an example:
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. Weekly Code: replace-with-actual-code
   ```

1. Add and commit `SUBMISSION.md`. Also, do a final check to ensure your code 
   passes the `checkstyle` audit, then stage and commit all changes, if needed.

1. Change into the parent directory and use the `submit` command to submit this exercise to `cs1302a`:
   
   ```
   $ submit cs1302-ce20 cs1302a
   ```
   
![CP](https://img.shields.io/badge/Checkpoint-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
