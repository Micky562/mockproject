package com.ttnweb.core.models;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.kohsuke.rngom.rngparser.parse.host.SchemaBuilderHost;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiField
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
                detailsMap.put("link",items.getValueMap().get("link", String.class));
                details.add(detailsMap);
            }
        }

    }

}
