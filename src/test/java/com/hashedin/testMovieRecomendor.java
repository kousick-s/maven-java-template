package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class testMovieRecomendor {
	
	public static void main(String[] args){
		Movie mov=new Movie();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("lessdata.data");
		Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("user.data");
		ArrayList<String> genre= new ArrayList<String>();
		genre=mov.GenreMap("genre.data");
		System.out.println(genre);
		Assert.assertEquals(movhmap.size(), 4);
		
	}

}
