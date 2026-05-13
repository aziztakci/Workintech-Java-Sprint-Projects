package org.example.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name.toLowerCase()) {
            case "ann": return annsTasks;
            case "bob": return bobsTasks;
            case "carol": return carolsTasks;
            case "all": return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default: return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersect = new HashSet<>(first);
        intersect.retainAll(second);
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }

    public Set<Task> getAnnsTasks() { return annsTasks; }
    public Set<Task> getBobsTasks() { return bobsTasks; }
    public Set<Task> getCarolsTasks() { return carolsTasks; }
    public Set<Task> getUnassignedTasks() { return unassignedTasks; }
}