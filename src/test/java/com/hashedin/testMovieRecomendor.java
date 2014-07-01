package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class testMovieRecomendor {
	
	public static void main(String[] args){
		Movie mov=new Movie();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("test_movie.data");
		Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("test_ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("test_user.data");
		ArrayList<String> genre= new ArrayList<String>();
		genre=mov.GenreMap("test_genre.data");
		System.out.println(genre);
		Assert.assertEquals(movhmap.size(), 8);
		Assert.assertEquals(rathmap.size(), 4);
		Assert.assertEquals(userhmap.size(), 10);
		Assert.assertEquals(genre.size(), 15);
		
	}

}
