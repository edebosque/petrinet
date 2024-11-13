# Petrinet MAPD
#### Dassouli Zéphyr, Debosque Enzo
\
**This documents explain how the Petrinet works**

### Code
The code is divided in 4 main objects : 
* PetriNet
* Place
* Transition
* Arc
    * ArcIn
    * ArcOut
        * Videur
        * Zero


To execute the code, you will first need to create a petrinet and to add some basic elements : 
#### Example
```java
PetriNet net = new PetriNet();
Place place = new Place(3);
Transition transition = new Transition();
ArcOut arc = new ArcOut(place, 2);
transition.addArcOut(arc);
net.addPlace(place);
net.addTransition(transition);
net.addArc(arc);
transition.triggerTransition();            

```
This basic code will trigger an Arc that will remove 2 tokens out of the place 

### Tests
The tests are devided in 4 differents classes :
* TestArc
* TestPlace
* TestTransition
* TestRepresentation

The first 3 are all testing basic usage of the petri net, each one focusing on a different object, while the last one is testing the string representation of the petri net created for IDEVL.
\
\
Tests are covering the entirety of the main classes.

### Link between model and implementation
Our first petri net modeling was quite bad and we changed lots of things from our first UML class diagram.
\
\
Firstly, we changed the name of several classes and variables, either to be more clear or to only use english : 
* Transition
    * Transit -> Transition
    * addTransi -> addTransition
    * remTransi -> remTransition
    * etc ...

* Tokens
    * nbJetons -> nbTokens
    * addJetons -> addTokens
    * etc ...
* tirer -> triggerTransition
And some other small adjustments.

\
We also added a redefinition of the trigger method in Videur and Zero that we haven't mentioned in our first class diagram.

#
**We used Vscode and Java version "21.0.1"**
