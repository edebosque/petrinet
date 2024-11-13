package test;
import petri.PetriNet;
import petri.Place;
import petri.Transition;
import petri.ArcIn;
import petri.ArcOut;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;


public class Test extends TestCase {

     /**
     *  Returns a string representation of the Petri net.
     * 
     *  @param net the Petri net to represent
     */
    public String getPetriNetRepresentation(PetriNet net) {
        StringBuilder representation = new StringBuilder();
        representation.append("Reseau de Petri\n");
        representation.append(net.getPlaces().size()).append(" places\n");
        representation.append(net.getTransis().size()).append(" transitions\n");
        representation.append(net.getArcs().size()).append(" arcs\n");
        representation.append("Liste des places :\n");
        int placeIndex = 1;
        for (Place place : net.getPlaces()) {
            representation.append(placeIndex).append(" : place avec ")
                          .append(place.getNbJetons()).append(" jetons\n");
            placeIndex++;
        }
        representation.append("Liste des transitions\n");
        int transitionIndex = 1;
        for (Transition trans : net.getTransis()) {
            representation.append(transitionIndex).append(" : transition, ")
                          .append(trans.getArcsIn().size()).append(" arc entrant, ")
                          .append(trans.getArcsOut().size()).append(" arc sortant\n");
            transitionIndex++;
        }
        representation.append("Liste des arcs :\n");
        int arcIndex = 1;
        for (Object arc : net.getArcs()) {
            if (arc instanceof ArcIn) {
            ArcIn arcIn = (ArcIn) arc;
            representation.append(arcIndex).append(" : arc simple poids ")
                      .append(arcIn.getValue()).append(" (transition vers place avec ")
                      .append(arcIn.getPlace().getNbJetons()).append(" jetons)\n");
            } else if (arc instanceof ArcOut) {
            ArcOut arcOut = (ArcOut) arc;
            representation.append(arcIndex).append(" : arc simple poids ")
                      .append(arcOut.getValue()).append(" (place avec ")
                      .append(arcOut.getPlace().getNbJetons()).append(" jetons vers transition)\n");
            }
            arcIndex++;
        }
        return representation.toString();
        }


        /**
        * Tests 
        */

        public void testRemoveTokensFromPlace1() {
            PetriNet net = new PetriNet();
            Place place = new Place(5);
            net.addPlace(place);
            place.remJetons(3);
            assertEquals(2, place.getNbJetons());
        }

        public void testRemoveTokensFromPlace2() {
            PetriNet net = new PetriNet();
            Place place = new Place(5);
            net.addPlace(place);
            place.remJetons(6);
            assertEquals(0, place.getNbJetons());
        }

        public void testRemoveNegativeTokensFromPlace() {
            PetriNet net = new PetriNet();
            Place place = new Place(5);
            net.addPlace(place);
            place.remJetons(-6);
            assertEquals(5, place.getNbJetons());
        }

        public void testAddTokensFromPlace() {
            PetriNet net = new PetriNet();
            Place place = new Place(3);
            net.addPlace(place);
            place.addJetons(4);
            assertEquals(7, place.getNbJetons());
        }

        public void testAddNegativeTokensFromPlace() {
            PetriNet net = new PetriNet();
            Place place = new Place(3);
            net.addPlace(place);
            place.addJetons(-4);
            assertEquals(3, place.getNbJetons());
        }

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

        public void testSimpleTransitionActivation1() {
            PetriNet net = new PetriNet();
            Place place = new Place(2);
            Transition transition = new Transition();
            ArcOut arc = new ArcOut(place, 2);
            transition.addArcOut(arc);
            net.addPlace(place);
            net.addTransition(transition);
            net.addArc(arc);
            transition.tirer();            
            assertEquals(0, place.getNbJetons());
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
            transition.tirer();            
            assertEquals(2, place.getNbJetons());
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
            transition.tirer();        
            assertEquals(1, place1.getNbJetons());
            assertEquals(3, place2.getNbJetons());
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
            transition.tirer();
            assertEquals(0, place1.getNbJetons());
            assertEquals(0, place2.getNbJetons());
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

        public void testRD1() {
            PetriNet net = new PetriNet();
            Place place = new Place(5);
            Transition transition = new Transition();
            ArcOut arc = new ArcOut(place, 3);
            transition.addArcOut(arc);
            net.addPlace(place);
            net.addTransition(transition);
            net.addArc(arc);
            transition.tirer();            
            assertEquals(2, place.getNbJetons());
        }

        public void testRD2() {
            PetriNet net = new PetriNet();
            Place place = new Place(1);
            Transition transition = new Transition();
            ArcOut arc = new ArcOut(place, 2);
            transition.addArcOut(arc);
            net.addPlace(place);
            net.addTransition(transition);
            net.addArc(arc);
            transition.tirer();            
            assertEquals(1, place.getNbJetons());
        }

        public void testRG1() {
            PetriNet net = new PetriNet();
            Place place = new Place(4);
            Transition transition = new Transition();
            ArcIn arc = new ArcIn(place, 1);
            transition.addArcIn(arc);
            net.addPlace(place);
            net.addTransition(transition);
            net.addArc(arc);
            transition.tirer();            
            assertEquals(5, place.getNbJetons());
        }

        public void testRDG1() {
            PetriNet net = new PetriNet();
            Place place1 = new Place(5);
            Place place2 = new Place(3);
            Transition transition = new Transition();
            ArcOut arc1 = new ArcOut(place1, 2);
            ArcIn arc2 = new ArcIn (place2, 1);
            transition.addArcOut(arc1);
            transition.addArcIn(arc2);
            net.addPlace(place1);
            net.addPlace(place2);
            net.addTransition(transition);
            net.addArc(arc1);
            net.addArc(arc2);
            transition.tirer();            
            assertEquals(3, place1.getNbJetons());
            assertEquals(4, place2.getNbJetons());
        }

        public void testRDG2() {
            PetriNet net = new PetriNet();
            Place place1 = new Place(2);
            Place place2 = new Place(3);
            Transition transition = new Transition();
            ArcOut arc1 = new ArcOut(place1, 3);
            ArcIn arc2 = new ArcIn (place2, 2);
            transition.addArcOut(arc1);
            transition.addArcIn(arc2);
            net.addPlace(place1);
            net.addPlace(place2);
            net.addTransition(transition);
            net.addArc(arc1);
            net.addArc(arc2);
            transition.tirer();            
            assertEquals(2, place1.getNbJetons());
            assertEquals(3, place2.getNbJetons());
        }

        public void testRM1() {
            PetriNet net = new PetriNet();
            Place place1 = new Place(4);
            Place place2 = new Place(1);
            Place place3 = new Place(3);
            Transition transition = new Transition();
            ArcOut arc1 = new ArcOut(place1, 2);
            ArcOut arc2 = new ArcOut(place2, 1);
            ArcIn arc3 = new ArcIn (place3, 2);
            transition.addArcOut(arc1);
            transition.addArcOut(arc2);
            transition.addArcIn(arc3);
            net.addPlace(place1);
            net.addPlace(place2);
            net.addPlace(place3);
            net.addTransition(transition);
            net.addArc(arc1);
            net.addArc(arc2);
            net.addArc(arc3);
            transition.tirer();            
            assertEquals(2, place1.getNbJetons());
            assertEquals(0, place2.getNbJetons());
            assertEquals(5, place3.getNbJetons());
        }

        public void testRM2() {
            PetriNet net = new PetriNet();
            Place place1 = new Place(1);
            Place place2 = new Place(1);
            Place place3 = new Place(3);
            Transition transition = new Transition();
            ArcOut arc1 = new ArcOut(place1, 2);
            ArcOut arc2 = new ArcOut(place2, 1);
            ArcIn arc3 = new ArcIn (place3, 2);
            transition.addArcOut(arc1);
            transition.addArcOut(arc2);
            transition.addArcIn(arc3);
            net.addPlace(place1);
            net.addPlace(place2);
            net.addPlace(place3);
            net.addTransition(transition);
            net.addArc(arc1);
            net.addArc(arc2);
            net.addArc(arc3);
            transition.tirer();            
            assertEquals(1, place1.getNbJetons());
            assertEquals(1, place2.getNbJetons());
            assertEquals(3, place3.getNbJetons());
        }

   
        public void testAffichage() {
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
            String stringBefore = getPetriNetRepresentation(net);
            System.out.println(getPetriNetRepresentation(net));
            transition.tirer();     
            String stringAfter = getPetriNetRepresentation(net);
            System.out.println(getPetriNetRepresentation(net));   
            
            assertEquals("Reseau de Petri\n" + //
                                "2 places\n" + //
                                "1 transitions\n" + //
                                "2 arcs\n" + //
                                "Liste des places :\n" + //
                                "1 : place avec 4 jetons\n" + //
                                "2 : place avec 2 jetons\n" + //
                                "Liste des transitions\n" + //
                                "1 : transition, 1 arc entrant, 1 arc sortant\n" + //
                                "Liste des arcs :\n" + //
                                "1 : arc simple poids 3 (place avec 4 jetons vers transition)\n" + //
                                "2 : arc simple poids 1 (transition vers place avec 2 jetons)\n", 
                        stringBefore);

            assertEquals("Reseau de Petri\n" + //
                                "2 places\n" + //
                                "1 transitions\n" + //
                                "2 arcs\n" + //
                                "Liste des places :\n" + //
                                "1 : place avec 1 jetons\n" + //
                                "2 : place avec 3 jetons\n" + //
                                "Liste des transitions\n" + //
                                "1 : transition, 1 arc entrant, 1 arc sortant\n" + //
                                "Liste des arcs :\n" + //
                                "1 : arc simple poids 3 (place avec 1 jetons vers transition)\n" + //
                                "2 : arc simple poids 1 (transition vers place avec 3 jetons)\n", 
                stringAfter);
        }

        
    }

