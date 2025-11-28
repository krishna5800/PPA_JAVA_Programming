package com.marvellous.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Laptop
{
    @Autowired
    public Harddisk hobj;
    @Autowired
    public RAM robj;

    @GetMapping("Laptop")
    public String LaptopDisplay()
    {
        return hobj.HardiskDisplay() + " and " + robj.RAMDisplay();
    }
}
