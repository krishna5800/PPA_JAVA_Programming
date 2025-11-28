package com.marvellous.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class RAM
{
    public String RAMDisplay()
    {
        return "RAM is of 16 GB";
    }
}
