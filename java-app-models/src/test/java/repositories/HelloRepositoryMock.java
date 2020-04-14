package com.njax.destructocats.java.app.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.njax.destructocats.java.app.models.HelloEntity;

public class HelloRepositoryMock implements HelloRepository {
	List<HelloEntity> helloEntities = new ArrayList<HelloEntity>();

	public HelloRepositoryMock(final HelloEntity ce) {
		helloEntities.add(ce);
	}

	@Override
	public List<HelloEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelloEntity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HelloEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HelloEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<HelloEntity> findById(Integer id) {
		for(HelloEntity entity : helloEntities) {
			if(entity.getId() == id) {
				return Optional.of(entity);
			}
		}
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(HelloEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends HelloEntity> entities) {
		// TODO Auto-generated method stub
	}

    @Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}

}
