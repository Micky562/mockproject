package com.ttnweb.core.models;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="published blogs configuration")
public @interface PublishedBlogsConfiguration
{
   @AttributeDefinition(name="published blogs",description="enter total no of blog to display",type= AttributeType.INTEGER)
    int total_published_blogs() default 4;
}
