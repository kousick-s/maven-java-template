package com.hashedin;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class testMovieRecomendor {
	
	public static void main(String[] args){
		Movie mov=new Movie();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("lessdata.data");
		Assert.assertEquals(movhmap.size(), 4);
	}

}
