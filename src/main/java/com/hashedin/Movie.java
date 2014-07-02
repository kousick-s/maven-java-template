package com.hashedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
	public ArrayList<MovieRatings> getRatings(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		ArrayList<MovieRatings> moviemap=RatingMap(is);
		//System.out.println(moviemap);
		return moviemap;
	}
	public Map<String, MovieUser> getUsers(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieUser> moviemap=UserMap(is);
		//System.out.println(moviemap);
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
private ArrayList<MovieRatings> RatingMap(InputStream is) {
		ArrayList<MovieRatings> moviemap =new ArrayList<MovieRatings>();
		//Map<String,MovieRatings> moviemap = new HashMap<String, MovieRatings>();
		BufferedReader br = null;
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				MovieRatings mr=getRatingObject(line);
				moviemap.add(mr);
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
		int i=1;
		n+=5;
		int mid=Integer.parseInt(st2.nextToken().toString());
		while (i<n) {
           token  = st2.nextToken().toString();
           
            i++;
        }
		int test=Integer.parseInt(token);
		int val=-1;
		if(test==1)
		{
		val=mid;
		}
		return val;
	}
	
	public static void main(String[] args){
		Movie mov=new Movie();
		ArrayList<MovieRatings> rathmap=new ArrayList<MovieRatings>();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("movie.data");
		//Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("user.data");
		String MovieName=mov.getMovieByGenre(rathmap, movhmap, mov);
		System.out.println(MovieName);
		
	}
	
	public String getMovieByGenre(ArrayList<MovieRatings> rathmap,Map<String,MovieRecomendor> movhmap,Movie mov){
		ArrayList<String> genrelist= new ArrayList<String>();
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		String genre="Adventure";
		System.out.println("Select Genre");
		int i=0;
		for(String s : genrelist)
		{
			i++;
			System.out.println(i + ". " + s);
			
		}
		int arrindex=genrelist.indexOf(genre);
		ArrayList<Integer> mids=new ArrayList<Integer>();
		mids=mov.getValue("movie.data",arrindex);
		ArrayList<Integer> newmids=new ArrayList<Integer>();
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		
		for(int d:mids){
			if(d!=-1)
			{
				newmids.add(d);
			}
		}
		System.out.println(newmids);
		
		int fmid=mov.getByGenre(newmids, rathmap);
		System.out.println(averagelist);
		System.out.println(averagelist.size());
		System.out.println(newmids.size());
		System.out.println(fmid);
		MovieRecomendor mrd=new MovieRecomendor();
		mrd=movhmap.get(Integer.toString(fmid));
		System.out.println(mrd.getName());
		return mrd.getName();
	}
	
	public  int  getByGenre(ArrayList<Integer> mids,ArrayList<MovieRatings> m){
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		 ArrayList<MovieRatings> mapmid=new ArrayList<MovieRatings>();
		 int fmid=0;
		for(int item: mids){
			
			for(MovieRatings rats:m){
		        int iid=rats.getMid();
		       if(item==iid){
		        mapmid.add(rats);
		        
		        }
		        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
		       // avoids a ConcurrentModificationException
		    }
		}
		for(int item: mids){
			int average=0,count=0,oaverage=0;
		for(MovieRatings id: mapmid){
		//ArrayList<String> val=new ArrayList<String>(Arrays.asList(id.split(",")));
		//String data=val.get(2);
		//	ArrayList<String> arr=new ArrayList<String>(Arrays.asList(data.split(",")));
//			String[] movidarr=(val.get(1)).split("=");
//			String[] ratingarr=(val.get(2)).split("=");
//			String movid=movidarr[1];
//			String rating=ratingarr[1];
			
	        if((id.getMid()==item)){
	        	int rating=id.getRating();
	        	average=average+(rating);
	        	count++;
			    average=average/count;
			    
			    
			    
			    
				}
	        
			if(average>=oaverage){
				oaverage=average;
				fmid=id.getMid();
			}
			}
		
		averagelist.add(average);
		}
		//Collections.sort(averagelist);
				
		return fmid;
		
	}
	
}




