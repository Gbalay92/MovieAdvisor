package com.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieadvisor.config.AppConfig;
import com.movieadvisor.model.Film;


@Repository
public class FilmDaoImpl implements FilmDao {

	public List<Film> films=new ArrayList<Film>();
	
	@Autowired
	private AppConfig appconfig;
	
	public void init() {
		films=UtilFilmFileReader.readFile(appconfig.getFile(), appconfig.getSeparator(), appconfig.getListSeparator());
	}
	
	public Film findById(long id) {
		Optional<Film> result=films.stream()
				.filter(f->f.getId()==id).findFirst();
		return result.orElse(null);
	}

	public Collection<Film> findAll() {
		// TODO Auto-generated method stub
		return films;
	}

	public void insert(Film film) {
		films.add(film);

	}

	public void update(Film film) {
		int index = getIndexOf(film.getId());
		if (index !=-1) {
			films.set(index, film);
		}
		
	}

	public void delete(long id) {
		int index = getIndexOf(id);
		if (index !=-1) {
			films.remove(index);
		}
	}
	
	private int getIndexOf(long id) {
		int index=0;
		for(Film film:films) {
			if(film.getId()==id) {
				return index;
			}
			index++;
		}
		return -1;
	}
	

}
