package tests;

import junit.framework.TestCase;
import petrinet.ArcOut;
import petrinet.PetriNet;
import petrinet.Place;

public class TestPlace extends TestCase {

    public void testRemoveTokensFromPlace1() {
        PetriNet net = new PetriNet();
        Place place = new Place(5);
        net.addPlace(place);
        place.remTokens(3);
        assertEquals(2, place.getNbTokens());
    }

    public void testRemoveTokensFromPlace2() {
        PetriNet net = new PetriNet();
        Place place = new Place(5);
        net.addPlace(place);
        place.remTokens(6);
        assertEquals(0, place.getNbTokens());
    }

    public void testRemoveNegativeTokensFromPlace() {
        PetriNet net = new PetriNet();
        Place place = new Place(5);
        net.addPlace(place);
        place.remTokens(-6);
        assertEquals(5, place.getNbTokens());
    }

    public void testAddTokensFromPlace() {
        PetriNet net = new PetriNet();
        Place place = new Place(3);
        net.addPlace(place);
        place.addTokens(4);
        assertEquals(7, place.getNbTokens());
    }

    public void testAddNegativeTokensFromPlace() {
        PetriNet net = new PetriNet();
        Place place = new Place(3);
        net.addPlace(place);
        place.addTokens(-4);
        assertEquals(3, place.getNbTokens());
    }

    public void testSetNbTokensNegative() {
        PetriNet net = new PetriNet();
        Place place = new Place(3);
        net.addPlace(place);
        place.setNbTokens(-4);
        assertEquals(0, place.getNbTokens());
    }

     public void testRemovePlaceWithArcs() {
        PetriNet net = new PetriNet();
        Place place1 = new Place(3);
        ArcOut arc1 = new ArcOut(place1, 2);
        Place place2 = new Place(3);
        ArcOut arc2 = new ArcOut(place2, 2);
        net.addPlace(place1);
        net.addArc(arc1);
        net.addPlace(place2);
        net.addArc(arc2);
        assertEquals(2, net.getArcs().size());
        assertEquals(2, net.getPlaces().size());
        net.remPlace(place1);
        assertEquals(1, net.getArcs().size());
        assertEquals(1, net.getPlaces().size());
    }

}
