package tests;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;
import petrinet.ArcIn;
import petrinet.ArcOut;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;
import petrinet.Videur;
import petrinet.Zero;

public class TestArc extends TestCase {

    public void testCreateArcIn() {
        PetriNet net = new PetriNet();
        Place place = new Place(1);
        Transition transition = new Transition();
        net.addPlace(place);
        net.addTransition(transition);
        ArcIn arc = new ArcIn(place, 1);
        net.addArc(arc);
        assertTrue(net.getArcs().contains(arc));
    }

    public void testCreateArcOut() {
        PetriNet net = new PetriNet();
        Place place = new Place(1);
        Transition transition = new Transition();
        net.addPlace(place);
        net.addTransition(transition);
        ArcOut arc = new ArcOut(place, 1);
        net.addArc(arc);
        assertTrue(net.getArcs().contains(arc));
    }

    public void testCreateArcNegative() {
        PetriNet net = new PetriNet();
        Place place = new Place(3);
        net.addPlace(place);
        assertThrows(IllegalArgumentException.class, () -> new ArcOut(place, -2));
    }

    public void testArcSetValue() {
        PetriNet net = new PetriNet();
        Place place = new Place(3);
        ArcOut arc = new ArcOut(place, 2);
        net.addPlace(place);
        net.addArc(arc);
        arc.setValue(3);
        assertEquals(3, arc.getValue());
    }

    public void testVideur() {
        PetriNet net = new PetriNet();
        Place place1 = new Place(2);
        Place place2 = new Place(0);
        Videur videur = new Videur(place1);
        ArcIn arc = new ArcIn(place2, 1);
        Transition transition = new Transition();
        transition.addArcOut(videur);
        transition.addArcIn(arc);
        net.addPlace(place1);
        net.addPlace(place2);
        net.addArc(videur);
        net.addArc(arc);
        net.addTransition(transition);
        transition.triggerTransition();
        assertEquals(0, place1.getNbTokens());
        assertEquals(1, place2.getNbTokens());
        transition.triggerTransition();
        assertEquals(0, place1.getNbTokens());
        assertEquals(1, place2.getNbTokens());
    }

    public void testZero() {
        PetriNet net = new PetriNet();
        Place place1 = new Place(0);
        Place place2 = new Place(0);
        Zero zero = new Zero(place1);
        ArcIn arc = new ArcIn(place2, 2);
        Transition transition = new Transition();
        transition.addArcOut(zero);
        transition.addArcIn(arc);
        net.addPlace(place1);
        net.addPlace(place2);
        net.addArc(zero);
        net.addArc(arc);
        net.addTransition(transition);
        transition.triggerTransition();
        assertEquals(0, place1.getNbTokens());
        assertEquals(2, place2.getNbTokens());
        place1.setNbTokens(2);
        transition.triggerTransition();
        assertEquals(2, place1.getNbTokens());
        assertEquals(2, place2.getNbTokens());
    }

    public void testRemovePlaceDoubleArcs() {
        PetriNet net = new PetriNet();
        Place place = new Place(6);
        ArcIn arc1 = new ArcIn(place, 1);
        ArcOut arc2 = new ArcOut(place, 1);
        net.addPlace(place);
        net.addArc(arc1);
        net.addArc(arc2);
        net.remPlace(place);
        assertEquals(0, net.getArcs().size());
        assertEquals(0, net.getPlaces().size());
    }

    public void testRemovePlaceDoubleOutArcs() {
        PetriNet net = new PetriNet();
        Place place = new Place(6);
        ArcOut arc1 = new ArcOut(place, 3);
        ArcOut arc2 = new ArcOut(place, 1);
        net.addPlace(place);
        net.addArc(arc1);
        net.addArc(arc2);
        net.remPlace(place);
        assertEquals(0, net.getArcs().size());
        assertEquals(0, net.getPlaces().size());
    }

}
