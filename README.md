# cs1302-ce20

1. CP1 = ce19 CP2 + textfield hgrow + non-functioning buttons for zoom
2. CP2 = create event handler for buttons
3. 


# cs1302-ce20 Fancy ImageApp

> The only way to get rid of temptation is to yield to it.
> **-- Oscar Wilde, _The Picture of Dorian Gray_**

This class exercise explores creating graphical user interfaces (GUIs) using the JavaFX library. Students
will create an interactive GUI that loads an image from a specified URL. The program supports images in BMP, 
GIF, JPEG, and PNG formats. In this exercise, starter code containing the basic layout of a JavaFX application
is provided. Implementation details are left to the student.

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

1. Change into the `cs1302-ce20` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

### Exercise Steps

1. Copy over your work from the `src/cs1302/ce19` directory of `cs1302-ce19`
   into the `src/cs1302/ce20` directory of `cs1302-ce20` and update the package
   statements accordingly (i.e., make sure the package is `cs1302.ce20`).
   
1. If you did not finish **cs1302-ce19**, then finish the work required for 
   [cs1302-ce19](https://github.com/cs1302uga/cs1302-ce19)
   in the code you just copied over. The textfield is expected to grow with
   its parent `HBox`. 
   
1. **Compile and run your code without any errors or warnings.**
   Also stage and commit your changes.
   
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
   
   * The three `ImageView` objects associated with the `Button` objects are not considered
     part of the scene graph but are part of the overall containment hiearchy. These 
     `ImageView` objects are associated with each `Button` object via the `Button` object's
     `graphic` property. 

   * The icons for the associated images are contained in the `resources` directory 
     provided with this exercise. 
     
   * The stage should NOT be resizable by the user via dragging the window corner.
   
1. Update your code so that it has the same scene graph and visual
   appearance provided in the previous step. 
   **Recompile before continuing.**
   Also stage and commit your changes.

1. If you completed the steps correctly, your app should look similar to
   the screenshot provided above. Congratulations on a good looking app!
   
**CHECKPOINT**

1. Now that you have your app looking good, let's make it do stuff. Add
   the following functionality to your app:

   * The first button (i.e., the one with [`/resources/zoom-in-50.png`](/resources/zoom-in-50.png))
     should _increase_ the size of the main `ImageView` object by some set amount.

   * The second button (i.e., the one with [`/resources/zoom-out-50.png`](/resources/zoom-out-50.png))
     should _decrease_ the size of the main `ImageView` object by some set amount.

   * The third button (i.e., the one with [`/resources/actual-size-50.png`](/resources/actual-size-50.png))
     should return the main `ImageView` object to its default size. This can be accomplished by changing the size 
     ImageView` object to the same size as the `Image` object it displays.
   
1. **Recompile before continuing.**
   Also stage and commit your changes.
     
1. If you completed the steps correctly, your app should not only look 
   similar to the screenshot provided above, but it has the desired
   functionality. Congratulations on a good looking, functional app!
        
**CHECKPOINT**

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
