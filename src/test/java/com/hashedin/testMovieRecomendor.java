package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class testMovieRecomendor {
	
	public static void main(String[] args){
		Movie mov=new Movie();
		ArrayList<MovieRatings> rathmap=new ArrayList<MovieRatings>();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("test_movie.data");
		//Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("test_ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("test_user.data");
		String MovieName=mov.getMovieByGenre(rathmap, movhmap, mov,"test_movie.data");
		System.out.println(MovieName);
		
	}

}
