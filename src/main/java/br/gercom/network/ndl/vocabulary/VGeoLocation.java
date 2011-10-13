package br.gercom.network.ndl.vocabulary;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Vocabulary definitions from wgs84_pos.rdfs
 * 
 * @author Fernando Farias
 * @serial 10122011
 */

public class VGeoLocation {

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
    public static final String NS = "http://www.w3.org/2003/01/geo/wgs84_pos#";

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
     * <p>
     * The namespace of the vocabulary as a resource
     * </p>
     */
    public static final Resource NAMESPACE = m_model.createResource(NS);

    /**
     * <p>
     * The WGS84 altitude of a SpatialThing (decimal meters above the local
     * reference ellipsoid).
     * </p>
     */
    public static final Property alt = m_model
            .createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#alt");

    /**
     * <p>
     * The WGS84 latitude of a SpatialThing (decimal degrees).
     * </p>
     */
    public static final Property lat = m_model
            .createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#lat");

    /**
     * <p>
     * A comma-separated representation of a latitude, longitude coordinate.
     * </p>
     */
    public static final Property lat_long = m_model
            .createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#lat_long");

    /**
     * <p>
     * The relation between something and the point, or other geometrical thing
     * in space, where it is. For example, the realtionship between a radio
     * tower and a Point with a given lat and long. Or a relationship between a
     * park and its outline as a closed arc of points, or a road and its
     * location as a arc (a sequence of points). Clearly in practice there will
     * be limit to the accuracy of any such statement, but one would expect an
     * accuracy appropriate for the size of the object and uses such as mapping
     * .
     * </p>
     */
    public static final Property location = m_model
            .createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#location");

    /**
     * <p>
     * The WGS84 longitude of a SpatialThing (decimal degrees).
     * </p>
     */
    public static final Property long_ = m_model
            .createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#long");

}
