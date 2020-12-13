# SorterApplication
Sorter is a java console application which allows a user to choose from one of six different sorting methods, prompts them to set parameters for an array of randomly selected integers and then sorts the array into ascending order with the selected. The application displays the time taken to sort the array so the different methods can be compared.

The methods available to choose from are:
  Binary Tree Sort
  Bubble Sort
  Collection Sort
  Insertion Sort
  Merge Sort
  Quick Sort
  
The randomly generated array can have 2 - 10,000 values (selected by the user) and an integer in the array can hold a value 2 - 10,000 (selected by the user)

Custom exceptions have been written to catch invalid user inputs and tests have been written for each exception. Tests have also been written for each sorter class to assure that they correctl sort arrays and handle duplicates. They haven't yet been tested to handle values outside of the above parameters. In the scope of this project the custom exceptions handle this, but there is room for extension if the classes are to be truly re-usable.
