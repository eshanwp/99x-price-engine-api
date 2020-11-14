package io.x99.priceengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface EntityRepository<T> extends JpaRepository<T, Integer>, QuerydslPredicateExecutor<T> {
}
