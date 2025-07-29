package com.day6proj2.service;

import java.sql.Blob;
import java.util.List;

import com.day6proj2.entity.Bug;
import com.day6proj2.repository.BugRepository;
import com.day6proj2.repository.BugRepositoryImpl;

public class BugService {
    private BugRepository bi;

public BugService(BugRepository bi) {
    this.bi = bi;
}

    public void insert(Bug b)
    {   //rule
        if(b.getStatus().equals("open")||b.getStatus().equals("closed")){
            bi.insertBug(b);
        }
        else{
            System.out.println("Invalid status");
        }
    }
    public List<Bug> view()
    {   if(!bi.viewAllBugs().isEmpty()){
        return bi.viewAllBugs();
    }
    System.out.print("No Bugs Found");
    return null;
    
}
public void update(Bug b)
{    
        List<Bug> l1=bi.viewAllBugs();
        if(!b.getStatus().equals("open")&&!b.getStatus().equals("closed")){
         System.out.println("Invalid status");
         return;
        }
        boolean exists = false;
      for (Bug existing : l1) {
        if (existing.getId() == b.getId()) {
            exists = true;
            break;
        }
      }

      if (!exists) {
        System.out.println("ID not found");
        return;
      }
         bi.updateStatus(b);
    }
    public void delete(Bug b)
    {   List<Bug> l1=bi.viewAllBugs();
       boolean exists = false;

    for (Bug existing : l1) {
        if (existing.getId() == b.getId()) {
            exists = true;
            break;
        }
    }

    if (!exists) {
        System.out.println("ID not found");
        return;
    } 
        bi.deleteBug(b);
    }

}
