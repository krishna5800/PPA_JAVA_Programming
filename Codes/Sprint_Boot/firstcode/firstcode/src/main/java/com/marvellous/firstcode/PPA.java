package com.marvellous.firstcode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PPA
{
    @GetMapping("start")
    public String Display()
    {
        return "Jay Ganesh...";
    }

    @GetMapping("stop")
    public String Demo()
    {
        return "Thank you for using Marvellous app";
    }
}
