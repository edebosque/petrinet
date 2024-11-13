/**
 * This package contains classes and interfaces for modeling and simulating Petri nets.
 * 
 * Petri nets are a mathematical modeling language used for the description of distributed systems.
 * This package provides the necessary components to create, manipulate, and analyze Petri nets.
 * 
 * Key components include:
 * - Places
 * - Transitions
 * - Tokens
 * - Arcs
 * 
 * Example usage:
 * 
 * <pre>
 * PetriNet net = new PetriNet();
 * Place p1 = new Place("P1");
 * Transition t1 = new Transition("T1");
 * Arc arc = new Arc(p1, t1);
 * net.addPlace(p1);
 * net.addTransition(t1);
 * net.addArc(arc);
 * </pre>
 * 
 */
package petrinet;