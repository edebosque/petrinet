package tests;

import junit.framework.TestCase;
import petrinet.ArcIn;
import petrinet.ArcOut;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;

public class TestAffichage extends TestCase {

     /**
     *  Returns a string representation of the Petri net.
     * 
     *  @param net the Petri net to represent
     */
    public String getPetriNetRepresentation(PetriNet net) {
        StringBuilder representation = new StringBuilder();
        representation.append("Reseau de Petri\n");
        representation.append(net.getPlaces().size()).append(" places\n");
        representation.append(net.getTransitions().size()).append(" transitions\n");
        representation.append(net.getArcs().size()).append(" arcs\n");
        representation.append("Liste des places :\n");
        int placeIndex = 1;
        for (Place place : net.getPlaces()) {
            representation.append(placeIndex).append(" : place avec ")
                          .append(place.getNbTokens()).append(" Jetons\n");
            placeIndex++;
        }
        representation.append("Liste des transitions\n");
        int transitionIndex = 1;
        for (Transition trans : net.getTransitions()) {
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
                      .append(arcIn.getPlace().getNbTokens()).append(" Jetons)\n");
            } else if (arc instanceof ArcOut) {
            ArcOut arcOut = (ArcOut) arc;
            representation.append(arcIndex).append(" : arc simple poids ")
                      .append(arcOut.getValue()).append(" (place avec ")
                      .append(arcOut.getPlace().getNbTokens()).append(" Jetons vers transition)\n");
            }
            arcIndex++;
        }
        return representation.toString();
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
            transition.triggerTransition();     
            String stringAfter = getPetriNetRepresentation(net);
            System.out.println(getPetriNetRepresentation(net));   
            
            assertEquals("Reseau de Petri\n" + //
                                "2 places\n" + //
                                "1 transitions\n" + //
                                "2 arcs\n" + //
                                "Liste des places :\n" + //
                                "1 : place avec 4 Jetons\n" + //
                                "2 : place avec 2 Jetons\n" + //
                                "Liste des transitions\n" + //
                                "1 : transition, 1 arc entrant, 1 arc sortant\n" + //
                                "Liste des arcs :\n" + //
                                "1 : arc simple poids 3 (place avec 4 Jetons vers transition)\n" + //
                                "2 : arc simple poids 1 (transition vers place avec 2 Jetons)\n", 
                        stringBefore);

            assertEquals("Reseau de Petri\n" + //
                                "2 places\n" + //
                                "1 transitions\n" + //
                                "2 arcs\n" + //
                                "Liste des places :\n" + //
                                "1 : place avec 1 Jetons\n" + //
                                "2 : place avec 3 Jetons\n" + //
                                "Liste des transitions\n" + //
                                "1 : transition, 1 arc entrant, 1 arc sortant\n" + //
                                "Liste des arcs :\n" + //
                                "1 : arc simple poids 3 (place avec 1 Jetons vers transition)\n" + //
                                "2 : arc simple poids 1 (transition vers place avec 3 Jetons)\n", 
                stringAfter);
        }

}
