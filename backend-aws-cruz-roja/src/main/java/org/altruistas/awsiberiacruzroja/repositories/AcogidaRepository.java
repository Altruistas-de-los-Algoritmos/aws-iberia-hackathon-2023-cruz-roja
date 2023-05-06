package org.altruistas.awsiberiacruzroja.repositories;

import org.altruistas.awsiberiacruzroja.models.entities.AcogidaEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface AcogidaRepository extends CrudRepository<AcogidaEntity, String> {
    List<AcogidaEntity> findAll();
}
