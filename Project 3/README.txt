@author Kaiven Zhou [kz2182]

===== Contains =====
- main.java: contains the text interface
- Graph.java: handles the list of City objects, and contains all the methods that the text interface can use
- City.java: a Vertex in the graph
- Edge.java: an Edge in the graph

===== IMPORTANT ======
-The professor said that it was ok to use java's built in LinkedList, so I have.
-I have NOT attempted the extra credit. Hence, text interface.
-There's an odd error with loading from the bin

===== Runtimes =====
a. Load a text file into the system
-
d. Search for state and list all cities of that state with the in/out counts for each
- O(n). Sweeps through the list of Citys, checking each for its state

e. Search for city and display some information about it. (gps and in/out count)
- O(n). Sweeps through the list of Citys, checking each for its city name. In/out counts are stored as an attribute

h. Find n closest cities to current city using gps distances
- O(n^2). Uses insertion sort (which is O(n^2)) to sort the cities by gps distance with respect to the current city. 
Gps distances calculated using the following sources:
	- http://comminfo.rutgers.edu/~jacekg/devel/mobile/android/Distance%20based%20on%20lat_long.pdf
	- https://sites.google.com/a/cs.usfca.edu/cs-107-03-2012-spring/tutorials/distancecalculator

i. Find all cities from current city with directed edge costs less than Y
- O(n^2). Uses djikstra's (without a priority queue, so O(n^2)) to find the edge distance from the current to every other node, 
then uses insertion sort (O(n^2)) to sort these distances. Then goes through the list of these distances (O(n^2)) outputting
those citys under distance Y.

j. Find shortest path between current and some target city
- O(n^2). Uses djikstra's (without a priority queue, so O(n^2)) to construct the shortest path. Outputs the path by sweeping (O(n))
through the list of created (the list contains what city comes before a given city in the shortest path).
