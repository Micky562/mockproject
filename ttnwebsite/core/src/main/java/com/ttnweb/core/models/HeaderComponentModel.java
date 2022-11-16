package com.ttnweb.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

//import javax.annotation.Resource;


@Model(adaptables = {Resource.class}) //to work with Resource.class we need import pakage api.resource.Resource
public class HeaderComponentModel
{
     @Inject
     @Default(values = "Home")
     private String firstItem;  //propertyname coming from dialog
     @Inject
     @Default(values="Published Blogs")  //what name is given in xml file of cq:dialog that must be same like firstItem,secondItem variable
      private String secondItem;

    public String getSecondItem()
    {
        return secondItem;
    }

    public void setSecondItem(String secondItem)
    {
        this.secondItem = secondItem;
    }

    public String getFirstItem()
    {
        return firstItem;
    }

    public void setFirstItem(String firstItem)
    {
        this.firstItem = firstItem;
    }
}
