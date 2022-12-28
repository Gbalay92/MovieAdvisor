package com.movieadvisor.dao;

import java.util.Collection;
import com.movieadvisor.model.Film;

public interface FilmDao {
	public Film findById(long id);
	public Collection<Film> findAll();
	public void insert (Film film);
	public void update (Film film);
	public void delete (long id);
	
}
