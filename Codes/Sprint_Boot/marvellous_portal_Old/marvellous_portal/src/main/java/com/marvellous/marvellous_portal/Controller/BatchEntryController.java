package com.marvellous.marvellous_portal.Controller;

import com.marvellous.marvellous_portal.Entity.BatchEntry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    //          <key , value>
    private Map<Long, BatchEntry> batchentries = new HashMap<>();

    @GetMapping
    public String getAll()
    {
        return "Inside HTTP GET verb";
    }

    @PostMapping
    public String createEntry()
    {
        return "Inside HTTP POST verb";
    }

    @DeleteMapping
    public String deleteEntryById()
    {
        return "Inside HTTP DELETE verb";
    }

    @PutMapping
    public String updateEntryById()
    {
        return "Inside HTTP PUT verb";
    }
}
