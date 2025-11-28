package com.marvellous.marvellous_portal.Controller;

import com.marvellous.marvellous_portal.Entity.BatchEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    //          <key , value>
    private Map<Long, BatchEntry> batchentries = new HashMap<>();

    // select * from batches;
    @GetMapping
    public List<BatchEntry> getAll()
    {
        return new ArrayList<>(batchentries.values());
    }

    // select * from batches where id = 3;
    @GetMapping("/id/{myid}")
    public BatchEntry getBatchEntryById(@PathVariable Long myid)
    {
        return batchentries.get(myid);
    }

    // insert into batches values (1, 'PPA', 28000);
    @PostMapping
    public String createEntry(@RequestBody BatchEntry myentry)
    {
        batchentries.put(myentry.getId(), myentry);

        return "Data inserted successfully";
    }

    // delete from batches where id = 2;
    @DeleteMapping("/id/{myid}")
    public BatchEntry deleteEntryById(@PathVariable Long myid)
    {
        return batchentries.remove(myid);
    }

    // update batches set fees = 31000 where id = 2;
    @PutMapping("/id/{myid}")
    public BatchEntry updateEntryById(@PathVariable Long myid, @RequestBody BatchEntry myentry)
    {
        return batchentries.put(myentry.getId(), myentry);
    }
}
