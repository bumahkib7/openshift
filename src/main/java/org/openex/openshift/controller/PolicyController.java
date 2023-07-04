package org.openex.openshift.controller;

import org.openex.openshift.models.Policy;
import org.openex.openshift.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/policies")
public class PolicyController {
    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        return new ResponseEntity<>(policyService.createPolicy(policy), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return new ResponseEntity<>(policyService.getAllPolicies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Policy>> getPolicyById(@PathVariable Long id) {
        return new ResponseEntity<>(policyService.getPolicyById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) {
        return new ResponseEntity<>(policyService.updatePolicy(policy), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
