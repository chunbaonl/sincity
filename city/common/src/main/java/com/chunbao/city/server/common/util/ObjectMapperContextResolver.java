package com.chunbao.city.server.common.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    static private JaxbJacksonObjectMapper mInstance;

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return getMapper();
    }

    public static ObjectMapper getMapper() {
        if (mInstance == null) {
            mInstance = new JaxbJacksonObjectMapper();
        }
        return mInstance;
    }

    public static class JaxbJacksonObjectMapper extends ObjectMapper {

        private static final long serialVersionUID = -1766696918485564718L;

        public JaxbJacksonObjectMapper() {

            final AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
            final AnnotationIntrospector secondary = new JaxbAnnotationIntrospector(getTypeFactory());
            final AnnotationIntrospector pair = AnnotationIntrospector.pair(primary, secondary);

            setAnnotationIntrospector(pair);

            getDeserializationConfig().with(pair);
            getSerializationConfig().with(pair);

            setSerializationInclusion(Include.NON_NULL);

            // Don't bomb on unknown fields
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

    }

}