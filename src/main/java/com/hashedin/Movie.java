package com.hashedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Movie {
	
	public Map<String, MovieRecomendor> getMovies(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieRecomendor> moviemap=getStringFromInputStream(is);
	//	System.out.println(moviemap);
		return moviemap;
	}
	public Map<String, MovieRatings> getRatings(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieRatings> moviemap=RatingMap(is);
		System.out.println(moviemap);
		return moviemap;
	}
	public Map<String, MovieUser> getUsers(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieUser> moviemap=UserMap(is);
		System.out.println(moviemap);
		return moviemap;
	}
	
	
	private Map<String, MovieRecomendor> getStringFromInputStream(InputStream is) {
		
		Map<String,MovieRecomendor> moviemap = new HashMap<String, MovieRecomendor>();
		BufferedReader br = null;
		
		
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				MovieRecomendor mn=getMovieobject(line);
				moviemap.put(Integer.toString((mn.getId())) , mn);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return moviemap;
 
	}
private Map<String, MovieRatings> RatingMap(InputStream is) {
		
		Map<String,MovieRatings> moviemap = new HashMap<String, MovieRatings>();
		BufferedReader br = null;
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				MovieRatings mr=getRatingObject(line);
				moviemap.put(Integer.toString(mr.getUid()),mr);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return moviemap;
 
	}
private Map<String, MovieUser> UserMap(InputStream is) {
	
	Map<String,MovieUser> moviemap = new HashMap<String, MovieUser>();
	BufferedReader br = null;
	String line;
	try {
		
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			MovieUser mr=getUserObject(line);
			moviemap.put(Integer.toString(mr.getUid()),mr);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return moviemap;

}
public ArrayList<String> GenreMap(String file) {
	
	
	InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
	ArrayList<String> gnames=new ArrayList<String>();
	
	BufferedReader br = null;
	String line;
	try {
		
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			
			gnames.add(getMovieGenre(line));
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return gnames;

}



	
	private  MovieRecomendor getMovieobject(String line) {
		MovieRecomendor mr=new MovieRecomendor();
		StringTokenizer st2 = new StringTokenizer(line, "|");
	
		mr.setId(Integer.parseInt(st2.nextElement().toString()) );
		mr.setName(st2.nextElement().toString());
		mr.setDate(st2.nextElement().toString());
		mr.setUrl(st2.nextElement().toString());
		
		
		mr.setYear(st2.nextElement().toString());
		return mr;
	}
	private  String getMovieGenre(String line) {
		
		StringTokenizer st2 = new StringTokenizer(line, "|");
		return ((st2.nextElement().toString()) );
	}
	private  MovieUser getUserObject(String line) {
		MovieUser mr=new MovieUser();
		StringTokenizer st2 = new StringTokenizer(line, "|");
	
		mr.setUid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setAge(Integer.parseInt(st2.nextElement().toString()) );
		mr.setGender(st2.nextElement().toString());
		mr.setOccupation(st2.nextElement().toString());
		mr.setZip(st2.nextElement().toString());
		return mr;
	}
	
	private  MovieRatings getRatingObject(String line) {
		MovieRatings mr=new MovieRatings();
		StringTokenizer st2 = new StringTokenizer(line, "\t");
	
		mr.setUid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setMid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setRating(Integer.parseInt(st2.nextElement().toString()) );
		mr.setTimestamp(Integer.parseInt(st2.nextElement().toString()) );
		
		
		return mr;
	}
	
	public ArrayList<Integer> getValue(String file, int n){
BufferedReader br = null;
InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
ArrayList<Integer> mid = new ArrayList<Integer>();
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			
			while ((line = br.readLine()) != null) {
				mid.add(getGenreValue(line,n));
				
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return mid;
	}
	private  int getGenreValue(String line, int n) {
		String token=new String();
		StringTokenizer st2 = new StringTokenizer(line, "|");
		int i=0;
		n+=5;
		int mid=Integer.parseInt(st2.nextToken().toString());
		while (i<=n) {
           token  = st2.nextToken().toString();
           
            i++;
        }
		if(token =="1")
		return mid;
		return -1;
	}
	
	public static void main(String[] args){
		Movie mov=new Movie();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("movie.data");
		Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("user.data");
		ArrayList<String> genrelist= new ArrayList<String>();
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		
		System.out.println("Select Genre");
		int i=0;
		for(String s : genrelist)
		{
			i++;
			System.out.println(i + ". " + s);
			
		}
		String genre="Adventure";
		int arrindex=genrelist.indexOf(genre);
		ArrayList<Integer> mids=new ArrayList<Integer>();
		mids=mov.getValue("movie.data",arrindex);
		System.out.println(mids);
	}
	
}




