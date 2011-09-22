package org.neo4j.rest.graphdb;

import org.neo4j.graphdb.Relationship;
import org.neo4j.helpers.collection.IterableWrapper;

import java.util.Collection;
import java.util.Map;

/**
* @author mh
* @since 22.09.11
*/
public class RelationshipIterableConverter implements RestResultConverter {
    private final RestAPI restAPI;

    public RelationshipIterableConverter(RestAPI restAPI) {
        this.restAPI = restAPI;
    }

    @Override
    public Object convertFromRepresentation(RequestResult requestResult) {
        return new IterableWrapper<Relationship, Object>((Collection<Object>) requestResult.toEntity()) {
            @Override
            protected Relationship underlyingObjectToObject(Object data) {
                return new RestRelationship((Map<?, ?>) data, restAPI);
            }
        };
    }
}
