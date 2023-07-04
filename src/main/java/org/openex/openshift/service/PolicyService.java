package org.openex.openshift.service;

import org.openex.openshift.models.Policy;
import org.openex.openshift.repository.PolicyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class PolicyService {
    private final PolicyRepo policyRepository;
     public PolicyService(PolicyRepo policyRepository) {
        this.policyRepository = policyRepository;
    }
     // CREATE
    public Policy createPolicy(Policy policy) {
        // Perform validations<
        validatePolicy(policy);
         return policyRepository.save(policy);
    }
     // READ
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
     public Optional<Policy> getPolicyById(Long id) {
        return policyRepository.findById(id);
    }
     // UPDATE
    public Policy updatePolicy(Policy policy) {
        // Perform validations
        validatePolicy(policy);
         return policyRepository.save(policy);
    }
     // DELETE
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
     // Validate Policy
    private void validatePolicy(Policy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Policy cannot be null.");
        }

        if (policyRepository.existsById(policy.getId())) {
            throw new IllegalArgumentException("Policy with ID " + policy.getId() + " already exists.");
        }
    }

}
