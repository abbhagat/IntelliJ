package com.split.controller;

import com.split.model.Group;
import com.split.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @PostMapping(value = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createGroup(@RequestBody Group group) {
        service.createGroup(group);
    }

    @GetMapping(value = "/getAllGroupInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getAllGroupInfo() {
        return service.getAllGroupInfo();
    }

    @GetMapping(value = "/getGroupInfoById/{groupID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Group getGroupInfoById(@PathVariable long groupID) {
        return service.getGroupInfoById(groupID);
    }
}
