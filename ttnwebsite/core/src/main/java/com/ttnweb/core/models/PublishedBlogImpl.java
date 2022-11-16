package com.ttnweb.core.models;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = PublishedBlogs.class,immediate = true)
@Designate(ocd=PublishedBlogsConfiguration.class)
public class PublishedBlogImpl implements PublishedBlogs
{
    public int totalNoOfBlog;
    @Activate
    public void ActivateMethod(PublishedBlogsConfiguration config)
    {
        totalNoOfBlog=config.total_published_blogs();
    }
    @Override
    public int getTotalNoOfBlog()
    {
        return totalNoOfBlog;
    }
}
