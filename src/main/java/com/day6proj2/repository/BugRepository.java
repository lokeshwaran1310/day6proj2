package com.day6proj2.repository;

import java.util.List;

import com.day6proj2.entity.Bug;

public interface BugRepository {
    public void insertBug(Bug b);
    public List<Bug> viewAllBugs();
    public void updateStatus(Bug b);
    public void deleteBug(Bug b);
}
