package com.split.service;

import com.split.model.Group;
import com.split.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class GroupService {

    @Autowired
    private GroupRepository dao;

    public void createGroup(Group group) {
        dao.save(group);
    }

    public List<Group> getAllGroupInfo() {
        return dao.findAll();
    }

    public Group getGroupInfoById(long groupID) {
        Optional<Group> group = dao.findById(groupID);
        return group.orElseGet((Supplier<? extends Group>) new Group());
    }
}
