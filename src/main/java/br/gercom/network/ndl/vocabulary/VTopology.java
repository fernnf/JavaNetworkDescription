/**
 * 
 */
package br.gercom.network.ndl.vocabulary;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Vocabulary definitions from topology.rdf
 * 
 * @author Fernando Farias
 * @serial 10122011
 */
public class VTopology {

    /**
     * <p>
     * The RDF model that holds the vocabulary terms
     * </p>
     */
    private static Model m_model = ModelFactory.createDefaultModel();

    /**
     * <p>
     * The namespace of the vocabulary as a string
     * </p>
     */
    public static final String NS = "http://www.science.uva.nl/research/sne/ndl#";

    /**
     * <p>
     * The namespace of the vocabulary as a string
     * </p>
     * 
     * @see #NS
     */
    public static String getURI() {
        return NS;
    }

    /**
     * Definition of Resources
     */

    /**
     * <p>
     * The namespace of the vocabulary as a resource
     * </p>
     */

    public static final Resource NAMESPACE = m_model.createResource(NS);

    public static final Resource NetworkElement = m_model.createResource(NS
            + "NetworkElement");
    public static final Resource NetworkTransportElement = m_model
            .createResource(NS + "NetowrkTransportElement");

    public static final Resource Device = m_model.createResource(NS + "Device");
    public static final Resource BroadcastSegment = m_model.createResource(NS
            + "BroadcastSegment");
    public static final Resource ConnectionPoint = m_model.createResource(NS
            + "ConnectionPoint");

    public static final Resource Link = m_model.createResource(NS + "Link");

    public static final Resource Interface = m_model.createResource(NS
            + "Interface");
    public static final Resource ConfigurableInterface = m_model
            .createResource(NS + "ConfigurableInterface");
    public static final Resource StaticInterface = m_model.createResource(NS
            + "StaticInterface");

    public static final Resource Location = m_model.createResource(NS
            + "Location");

    /** 
     * Definition of Property
     */

    /**
     * <p>
     * A float representing the data rate of an Interface or link in Bytes/s
     * (similar to GMPLS; thus not bit/s!), at the layer specified by the
     * Interface or Link. This is the data rate including headers. To compare if
     * two floats are equal, at least the 10 most significant bits (about 3
     * decimals) must be compared, and data should be rounded to Byte/s. The
     * maximum cardinality of this property is 1.
     * </p>
     */
    public static final Property capacity = m_model.createProperty(NS
            + "capacity");

    /**
     * <p>
     * The circuitSwitchedTo property is a specific variant of the switchedTo
     * property. Two circuitSwitchedTo properties with the same Interface as
     * object means that the object Interface somehow picks one of the two
     * signals, and puts that through, dropping traffic from the other subject
     * Interface. For example the Interface with the best signal-to-noise ratio
     * of a 1:1 protected path is picked.
     * </p>
     */
    public static final Property circuitSwitchedTo = m_model.createProperty(NS
            + "circuitSwitchedTo");

    /**
     * <p>
     * The connectedTo ties Interfaces together. This property defines
     * uni-directional tandem connection (ITU G.805 terms) or unidirectional
     * path (graph theory terms) between Interfaces, or from Interfaces to
     * Links. All data send out the subject Interface (the egress interface) is
     * somehow received by to the object Interface (the ingress interface). To
     * define a bi-directional connection with the connectedTo property it
     * should be defined in both directions (both Interfaces pointing to each
     * other or both Interfaces pointing to the same Link). A connectedTo
     * property always involves external connection, between devices, not
     * connections within a device (for that, see switchedTo). The subject and
     * object Interface must be on the same layer.
     * </p>
     */
    public static final Property connectedTo = m_model.createProperty(NS
            + "connectedTo");

    /**
     * <p>
     * A longer human-readable description for the subject.
     * </p>
     */
    public static final Property description = m_model.createProperty(NS
            + "description");

    /**
     * <p>
     * The hasInterface property assigns interfaces to the group of network
     * elements that constitute a device. The has interface property is
     * transitive: if device "has" a physical Interface, and the physical
     * interface contains one or more logical interface (as described by an
     * adaptation property), then those logical interfaces are considered to be
     * part of the device as well. It is common to create a "hasInterface"
     * relation between a device and all fixed Interface: both physical and
     * statically logical interfaces.
     * </p>
     */
    public static final Property hasInterface = m_model.createProperty(NS
            + "hasInterface");

    /**
     * <p>
     * The linkTo ties Interfaces together. The linkTo is a special case of the
     * connectedTo property and defines a uni-directional link connection (ITU
     * G.805 terms) or edge (graph theory terms). The subject and object
     * Interface are directly connected to each other on their layer. There is
     * no intermediate connection point forwarding the data.
     * </p>
     */
    public static final Property linkTo = m_model.createProperty(NS + "linkTo");

    /**
     * <p>
     * The relation between a Device and a Location is defined by the locatedAt
     * property. Optionally, it can be used for denoting the location of an
     * Interface, but only if the accompanying Device is not defined or known.
     * Locations itself may have a location of their own. For example, a
     * location can denote a rack, while its parent locations is a room, and
     * thats parent location is a building or facility.
     * </p>
     */
    public static final Property locatedAt = m_model.createProperty(NS
            + "locatedAt");

    /**
     * <p>
     * A short human-readable name for the subject.
     * </p>
     */
    public static final Property name = m_model.createProperty(NS + "name");

    /**
     * <p>
     * The packetSwitchedTo property is a specific variant of the switchedTo
     * property. Two packetSwitchedTo properties with the same Interface as
     * object means that the data of the all subject Interfaces is somehow
     * merged and forward on the object Interface. For example, Ethernet packets
     * are merged. There may be additional constraints specified in the
     * SwitchMatrix, like a memory buffer.
     * </p>
     */
    public static final Property packetSwitchedTo = m_model.createProperty(NS
            + "packetSwitchedTo");

    /**
     * <p>
     * The switchedTo property represents an internal uni-directional connection
     * within a device. All data from the subject is forwarded to the object. A
     * switchedTo property always involves internal connection, between devices,
     * not connections between two devices (for that, see connectedTo). To
     * define a bi-directional connection with the switchedTo property it should
     * be defined in both directions.
     * </p>
     */
    public static final Property switchedTo = m_model.createProperty(NS
            + "switchedTo");

}
