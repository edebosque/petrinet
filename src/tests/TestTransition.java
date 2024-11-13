package tests;

import junit.framework.TestCase;
import petrinet.ArcIn;
import petrinet.ArcOut;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;

public class TestTransition extends TestCase {

    public void testRemoveTransition() {
        PetriNet net = new PetriNet();
        Transition transition = new Transition();
        net.addTransition(transition);
        assertEquals(1, net.getTransitions().size());
        net.remTransition(transition);
        assertEquals(0, net.getTransitions().size());
    }


    public void testSimpleTransitionActivation1() {
        PetriNet net = new PetriNet();
        Place place = new Place(2);
        Transition transition = new Transition();
        ArcOut arc = new ArcOut(place, 2);
        transition.addArcOut(arc);
        net.addPlace(place);
        net.addTransition(transition);
        net.addArc(arc);
        transition.triggerTransition();            
        assertEquals(0, place.getNbTokens());
    }

    
    public void testSimpleTransitionActivation2() {
        PetriNet net = new PetriNet();
        Place place = new Place(2);
        Transition transition = new Transition();
        ArcOut arc = new ArcOut(place, 3);
        transition.addArcOut(arc);
        net.addPlace(place);
        net.addTransition(transition);
        net.addArc(arc);
        transition.triggerTransition();            
        assertEquals(2, place.getNbTokens());
    }


    public void testSimpleTransitionActivation3() {
        PetriNet net = new PetriNet();
        Place place1 = new Place(4);
        Place place2 = new Place(2);
        Transition transition = new Transition();
        ArcOut arc1 = new ArcOut(place1, 3);
        ArcIn arc2 = new ArcIn(place2, 1);
        transition.addArcOut(arc1);
        transition.addArcIn(arc2);
        net.addPlace(place1);
        net.addPlace(place2);
        net.addTransition(transition);
        net.addArc(arc1);
        net.addArc(arc2);
        transition.triggerTransition();        
        assertEquals(1, place1.getNbTokens());
        assertEquals(3, place2.getNbTokens());
    }


    public void testMultipleInputTransitionActivation() {
        PetriNet net = new PetriNet();
        Place place1 = new Place(1);
        Place place2 = new Place(1);
        Transition transition = new Transition();
        ArcOut arc1 = new ArcOut(place1, 1);
        ArcOut arc2 = new ArcOut(place2, 1);
        transition.addArcOut(arc1);
        transition.addArcOut(arc2);
        net.addPlace(place1);
        net.addPlace(place2);
        net.addTransition(transition);
        net.addArc(arc1);
        net.addArc(arc2);
        transition.triggerTransition();
        assertEquals(0, place1.getNbTokens());
        assertEquals(0, place2.getNbTokens());
    }

}
