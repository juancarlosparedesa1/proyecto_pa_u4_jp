package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
	
		this.entityManager.persist(ciudadano);
	}

	
}
