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
   
1. If you did not finish cs1302-ce19, then finish the work required for 
   [cs1302-ce19](https://github.com/cs1302uga/cs1302-ce19)
   in the code you just copied over.
   
1. 
   
1. **Compile and run your code without any errors or warnings.**
   Specify `bin` as the default package for your compiled code.
   
   * If you have trouble running the code, then consult the 
     [CSCI 1302 JavaFX Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx.md).
     
1. The contents of the scene represent part of the state of your application.
   As such, the variables that we use to refer to those objects should be
   instance variables of your class. Consult the 
   [API Documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) and 
   [referenced bookmarks](http://cobweb.cs.uga.edu/~mec/cs1302/gui/)
   to determine some of the import statements that are needed, then add them to
   the file for your `ImageApp` class. **Recompile before continuing.** 
   
1. Stage and commit your changes.

1. Now, for each object in the scene graph, declare an **instance variable** 
   of the appropriate type with a good name. Do not create the objects here!
   
1. In the `start` method, construct the objects for the scene graph in
   a top-down fashion, assigning their references to the instance variables
   that you just declared. 
   
   1. Consult the 
      [API Documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) and 
      for each class to see what constructors are available.
      
   1. Try to make the text content of visible nodes match the screenshot.
      
   1. For the `ImageView` object, we would like for you to create a separate
      [`Image`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html)
      object and use the 
      [`ImageView(Image)`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html#ImageView-javafx.scene.image.Image-) constructor. The URL string that you should provide to
      the `Image` constructor is:
   
      ```
      http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png
      ```
      
      **NOTE:** Do not use the `ImageView` constructor that directly takes a URL string.
      If you do, then it will make it potentially more difficult to change the image
      in a later step.
  
   1. Add any child nodes to the to their parent's 
      collection of children using `getChildren().add`. 
      
   1. **Recompile and run.**

1. Stage and commit your changes.

1. If you completed the steps correctly, your app should look similar to
   the screenshot provided above. Congratulations on a good looking app!
   
**CHECKPOINT**

1. Now that you have your app looking good, let's make it do stuff. 

1. In the `start` method of your `ImageApp` class, declare a variable
   of type `EventHandler<ActionEvent>` called `loadHandler`, then assign
   to it, using a lambda expression, an implementation of
   `EventHandler<ActionEvent>` that prints out the text of the
   `TextField` to standard output (i.e., the terminal).
   **Recompile before continuing.**
   
   * Take special care that you import the correct `ActionEvent` class,
     as a quick Internet search may recommend the wrong one!
     Consult the 
     [API Documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) and 
     [referenced bookmarks](http://cobweb.cs.uga.edu/~mec/cs1302/gui/)
     to determine the import statements that are needed.
     
1. Once your app is able to print the text from the `TextField` to 
   standard output, ammend the code that is also creates an `Image`
   object using the supplied URL, then sets the `image` propery of
   the `ImageView` using the appropriated setter method.
   **Recompile before continuing.**
   
   * Here are some URLs to try when testing your program:
   
     * `http://cobweb.cs.uga.edu/~mec/cs1302/gui/pikachu.png`
     * `http://cobweb.cs.uga.edu/~mec/cs1302/gui/brad.jpg`
     * `http://cobweb.cs.uga.edu/~mec/cs1302/gui/SuccessKid.jpg`
   
   * Your program should not crash when supplied invalid input. Use
     exception handling, as needed, to make the experience nicer
     for the user. While we will explore creating popup windows
     and dialogs in the future, it is sufficient to print a friendly
     error message to standard output instead of letting the
     program crash or display a stack trace.
     
1. Stage and commit your changes.

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
