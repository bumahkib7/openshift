package org.openex.openshift.repository;

import org.openex.openshift.models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {
}
