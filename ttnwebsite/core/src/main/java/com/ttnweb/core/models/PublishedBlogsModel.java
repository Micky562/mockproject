package com.ttnweb.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = Resource.class)
public class PublishedBlogsModel
{
    @OSGiService
    PublishedBlogs publishedBlogs;

    public int getPublishedBlogs()
    {
        return publishedBlogs.getTotalNoOfBlog();
    }

}
