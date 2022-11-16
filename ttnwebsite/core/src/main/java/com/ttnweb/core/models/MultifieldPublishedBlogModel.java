package com.ttnweb.core.models;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldPublishedBlogModel
{
    @SlingObject
    private Resource componentResource;     //Used to get the current resource of the component

    private List<Map<String, String>> details = new ArrayList<>();

    public List<Map<String, String>> getMultiDataMap()
    {
        return details;
    }

    @PostConstruct
    protected void init()
    {
        Resource resource = componentResource.getChild("details");  //now we will get the details resource which holds the data in different item node.
        if (resource != null)
        {
            for (Resource items : resource.getChildren())
            {
                Map<String, String> detailsMap = new HashMap<>();
                detailsMap.put("title",items.getValueMap().get("title", String.class));// Saving the property into a map, which will be fetched in HTML
                detailsMap.put("heading",items.getValueMap().get("heading", String.class));
                detailsMap.put("date",items.getValueMap().get("date", String.class));
                detailsMap.put("description",items.getValueMap().get("description", String.class));

                detailsMap.put("image",items.getValueMap().get("image",String.class));
                details.add(detailsMap);
            }
        }

    }

}

