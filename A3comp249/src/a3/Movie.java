package a3;
import java.io.*;

import java.util.Scanner;




public class Movie implements Serializable {
	
	protected int year;
	protected String  title;
	protected int duration;
	protected String genre;
	protected String rating;
	protected double score;
	protected String director;
	protected String actor1;
	protected String actor2;
	protected String actor3;
	protected static String[] genres = {"Musical","Comedy","Animation","Adventure",
										"Drama","Crime","Biography","Horror","Action",
										"Documentary","Fantasy","Mystery","Sci-fi",
										"Family","Romance","Thriller","Western"};
	
	protected static String[] ratings= {"PG","Unrated","G","R","PG-13","NC-17"};
	
	protected static String genre_message = "Invalid Genre. Valid genres are the following:"
											+ "\nmusical"
											+ "\ncomedy"
											+ "\nanimation"
											+ "\nadventure"
											+ "\ndrama"
											+ "\ncrime"
											+ "\nbiography"
											+ "\nhorror"
											+ "\naction"
											+ "\ndocumentary"
											+ "\nfantasy"
											+ "\nmystery"
											+ "\nsci-fi"
											+ "\nfamimly"
											+ "\nromance"
											+ "\nthriller"
											+ "\nwestern";
	
	protected static String ratings_message = "Invalid Rating. Should be one of the following:"
											+ "\nPG"
											+ "\nUnrated"
											+ "\nG"
											+ "\nR"
											+ "\nPG-13"
											+ "\nNC-17";

	protected static int[] sizes={0,73,2,28,43,11,10,11,71,7,3,3,0,0,0,1,0};
	public static String submenu = "------------------------------"
								  +"\n\tGenre Sub-Menu\n"
								  +"------------------------------"
								  +"\n1\tmusical\t\t\t(0 movies)"
								  +"\n2\tcomedy\t\t\t(73 movies)"
								  +"\n3\tanimation\t\t(2 movies)"
								  +"\n4\tadventure\t\t(28 movies)"
								  +"\n5\tdrama\t\t\t(43 movies)"
								  +"\n6\tcrime\t\t\t(11 movies)"
								  +"\n7\tbiography\t\t(10 movies)"
								  +"\n8\thorror\t\t\t(11 movies)"
								  +"\n9\taction\t\t\t(71 movies)"
								  +"\n10\tdocumentary\t\t(7 movies)"
								  +"\n11\tfantasy\t\t\t(3 movies)"
								  +"\n12\tmystery\t\t\t(3 movies)"
								  +"\n13\tsci-fi\t\t\t(0 movies)"
								  +"\n14\tfamily\t\t\t(0 movies)"
								  +"\n15\twestern\t\t\t(0 movies)"
								  +"\n16\tromance\t\t\t(1 movies)"
								  +"\n17\tthriller\t\t(0 movies)"
								  +"\n18\tExit"
								  +"\n---------------------"
								  +"\nEnter Your Choice:";

	public static void mainmenu(String type,int number){
				  String mainmenu="-----------------------------"
								 +"\n\tMain Menu\n"
								 +"-----------------------------"
								 +"\ns\tSelect a movie array to navigate"
								 +"\nn\tNavigate "+type+" movies ("+number+" records)"
								 +"\nx\tExit\n"
								 +"-----------------------------"
								 +"\n\n\nEnter Your Choice:";
		System.out.println(mainmenu);
		}

	public static void navigate_message(String type,int number){
		String navigate ="Navigating "+type+" movies ("+number+")\n"
						+"Enter Your Choice:";
		System.out.println(navigate);
	}

	public static void do_part3(String manifest){
		Scanner sc=new Scanner(System.in);
		int option=0;
		String opt="";
		int range=0;
		
		
		do{
			System.out.println(submenu);
			option = sc.nextInt();
			if(option!=18){
			do{
			mainmenu(genres[option-1],sizes[option-1]);
			opt=sc.next();
			if(opt.equals("n")){
			int start=0;
			do{
				navigate_message(genres[option-1],sizes[option-1] );
				range=sc.nextInt();
				
				
				Movie[][] all_movies = make_arrays(manifest);
				if(range>0){
					for(int i=0;i<range;start++,i++){
						try{
							if(all_movies[option-1]!=null) 
								System.out.println(all_movies[option-1][start]);
							else
								System.out.println("Empty Section");
						}catch(IndexOutOfBoundsException e){
							System.out.println("EOF has been reached.");
						}
						
					}
					
				}
				else if(range<0){
					start+=(range+1);
					for(int i=0;i<-range;i++,start++){
						
						try{
							if(all_movies[option-1]!=null) 
							System.out.println(all_movies[option-1][start]);
						else
							System.out.println("Empty Section");
							
						}catch(IndexOutOfBoundsException e){
							System.out.println("BOF has been reached");
							break;
						}
					}
				}
				else
					break;
				

			}while(start!=0);
		}
			
			}while(!opt.equals("x") && !opt.equals("s"));
		}
		}while(option!=18 && !opt.equals("x"));
	}

	public Movie(int year,String title,int duration, String genre,String rating,double score,String director, String actor1,String actor2,String actor3) {
		this.year=year;
		this.title=title;
		this.duration=duration;
		this.genre=genre;
		this.rating=rating;
		this.score=score;
		this.director=director;
		this.actor1=actor1;
		this.actor2=actor2;
		this.actor3=actor3;
	}
	
	public int getYear(){
		return this.year;
	}
	public String getTitle(){
		return this.title;
	}
	public int getDuration(){
		return this.duration;
	}
	public String getGenre(){
		return this.genre;
	}
	public String getRating(){
		return this.rating;
	}
	public double getScore(){
		return this.score;
	}
	public String getDirector(){
		return this.director;
	}
	public String getActor1(){
		return this.actor1;
	}
	public String getActor2(){
		return this.actor2;
	}
	public String getActor3(){
		return this.actor3;
	}
	public void setYear(int y) {
		this.year=y;
	}
	public void setTitle(String t) {
		this.title=t;
	}
	public void setDuration(int d) {
		this.duration=d;
	}
	public void setGenre(String g) {
		this.genre=g;
	}
	public void setRating(String r) {
		this.rating=r;
	}
	public void setScore(double s) {
		this.score=s;
	}
	public void setDirector(String d) {
		this.director=d;
	}
	public void setActor1(String a1){
		this.actor1=a1;
	}
	public void setActor2(String a2) {
		this.actor2=a2;
	}
	public void setActor3(String a3) {
		this.actor3=a3;
	}
	
	
	public boolean equals(Movie anotherMovie) {
		return this.actor3==anotherMovie.actor3 && 
			   this.actor2==anotherMovie.actor2 &&
			   this.actor1 == anotherMovie.actor1 &&
			   this.director==anotherMovie.director &&
			   this.duration==anotherMovie.duration &&
			   this.genre==anotherMovie.genre &&
			   this.rating==anotherMovie.genre &&
			   this.score==anotherMovie.score &&
			   this.title==anotherMovie.title &&
			   this.year==anotherMovie.year;
	}
	
	@Override
	public String toString() {
		return  "Year:\t"+this.year + "\n"
			   + "Title:\t"+this.title +"\n"
			   + "Score:\t"+this.score +"\n"
			   + "Rating:\t"+this.rating+"\n"
			   + "Genre:\t"+this.genre+"\n"
			   + "Duration:\t"+this.duration+"\n"
			   + "Director:\t"+this.director+"\n"
			   + "Actor 1:\t"+this.actor1+"\n"
			   + "Actor 2:\t"+this.actor2+"\n"
			   + "Actor 3:\t"+this.actor3+"\n";
		}
	
	public static boolean EmptyString(String str) {
	     return str.length() == 0;
	    }
	  
	public static int LetterNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                count++; 
            }
        }
        return count;
    }
	
    public static int DigitNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count++; 
            }
        }
        return count;
    }
    
    public static boolean Inside(String[] array, String targetString) {
        for (String str : array) {
            if (str.equals(targetString)) {
                return true; 
            }
        }
		return false;
        
    }
	
	public static int lines(String file) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(file));
		int number_lines=0;
		while(b.readLine()!=null) 
			number_lines+=1;
			
		b.close();
		return number_lines;
	}
	
	
	
	public static boolean Periods(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                return true; 
            }
        }
        return false; 
    }
	
	public static boolean checkRecord(String record, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(record)) {
                return true;
            }
        }
        return false;
    }
	
//	public static String[] splitStringByCommasIgnoringQuotes(String str) {
//		
//	}
	


    public static String[] splitStringByCommasIgnoringQuotes(String str) {
        String[] parts = new String[10];
        int partIndex = 0;
        String currentPart = "";
        boolean withinQuotes = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '"') {
                withinQuotes = !withinQuotes;
            } else if (c == ',' && !withinQuotes) {
                parts[partIndex++] = currentPart;
                currentPart = "";
                if (partIndex >= parts.length) {
                    parts = resizeArray(parts);
                }
            } else {
                currentPart += c;
            }
        }

        if (!currentPart.isEmpty()) {
            parts[partIndex++] = currentPart;
            if (partIndex >= parts.length) {
                parts = resizeArray(parts);
            }
        }

        parts = trimArray(parts, partIndex);
        return parts;
    }

    public static String[] splitStringByCommas(String str) {
        String[] parts = new String[10];
        int partIndex = 0;
        String currentPart = "";
        boolean withinQuotes = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ',' && !withinQuotes) {
                parts[partIndex++] = currentPart;
                currentPart = "";
                if (partIndex >= parts.length) {
                    parts = resizeArray(parts);
                }
            } else {
                currentPart += c;
                if (c == '"') {
                    withinQuotes = !withinQuotes;
                }
            }
        }

        if (!currentPart.isEmpty()) {
            parts[partIndex++] = currentPart;
            if (partIndex >= parts.length) {
                parts = resizeArray(parts);
            }
        }

        parts = trimArray(parts, partIndex);
        return parts;
    }

    private static String[] resizeArray(String[] arr) {
        int newSize = arr.length * 2; // Double the size
        String[] newArr = new String[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static String[] trimArray(String[] arr, int size) {
        String[] trimmedArr = new String[size];
        for (int i = 0; i < size; i++) {
            trimmedArr[i] = arr[i];
        }
        return trimmedArr;
    }






	
	
	 
	public static void error_1file(String infile) throws IOException, FileNotFoundException{
		
		String line;
		BufferedReader b = new BufferedReader(new FileReader(infile));
		BufferedWriter w = new BufferedWriter(new FileWriter("bad_records.txt",true));
		int lineNumber =0;
		while((line = b.readLine())!=null) {
		try {
			
			
			lineNumber++;
			
			String[] record =  splitStringByCommasIgnoringQuotes(line);
			

			if (record.length<10) 
			{
				throw new MissingFieldsException("Syntax Error: ");
			}
			else if(record.length>10)
			{

				throw new ExcessFieldsException("Syntax Error: ");

			}
			else if(record.length==10) {
				int quotes =0;
				for(int j=0;j<record.length;j++) {
					if(record[j].indexOf("\"")!=-1)
							quotes+=1;
					}
				if(quotes%2!=0 )
					throw new MissingQuotesException("Syntax Error: Invalid");
				
				if(record[0].equals(""))
					throw new BadYearException("Syntax Error: Invalid");
				
				if(Periods(record[0]) || LetterNumber(record[0])>0 || (Integer.parseInt(record[0])>1999 || Integer.parseInt(record[0])<1990))
					throw new BadYearException("Semantic Error: Invalid");
				
				if(record[1].equals(""))
					throw new BadTitleException("Syntax Error: Missing");
				
				
				if(DigitNumber(record[1])==record[1].length())
					throw new BadTitleException("Semantic Error: Invalid");
				
				if(record[2].equals(""))
					throw new BadDurationException("Syntax Error: Missing");
				
				if(LetterNumber(record[2])>0 || Periods(record[2]) || (Integer.parseInt(record[2])>300 || Integer.parseInt(record[2])<30))
					throw new BadDurationException("Semantic Error: Invalid");
				
				if(record[3].equals(""))
					throw new BadGenreException("Syntax Error: Missing");
				
				if(!Inside(genres,record[3]))
					throw new BadGenreException("Semantic Error: Invalid");
				
				if(record[4].equals(""))
					throw new BadRatingException("Syntax Error: Missing");
				
				if(!Inside(ratings,record[4]))
					throw new BadRatingException("Semantic Error: Invalid");
					
				if(record[5].equals(""))
					throw new  BadScoreException("Syntax Error: Missing");
				
//				if(!Periods(record[5]))
//					throw new BadScoreException("Semantic Error: Invalid");
				
				if(Double.parseDouble(record[5])>10 || Double.parseDouble(record[5])<0)
					throw new BadScoreException("Semantic Error: Invalid");
				
//				if(Periods(record[5]) && (Double.parseDouble(record[5])>10 || Double.parseDouble(record[5])<0))
//					throw new BadScoreException("Semantic Error: Invalid");
				
				if(record[6].equals("") || record[7].equals("") || record[8].equals("") || record[9].equals(""))
					throw new BadNameException("Syntax Error: Missing");
				
				if(DigitNumber(record[6])>0 || DigitNumber(record[7])>0 || DigitNumber(record[8])>0 || DigitNumber(record[9])>0)
					throw new BadNameException("Semantic Error: Invalid");
			}
			}catch(MissingFieldsException | 
					ExcessFieldsException |
					MissingQuotesException | 
					BadYearException | 
					BadTitleException | 
					BadDurationException |
					BadGenreException |
					BadRatingException |
					BadScoreException |
					BadNameException e){
				
				
				w.write(e.getMessage() + "\n");
				w.write("Original Movie Record: " + line + "\n");
				w.write("Input Filename: " + infile + "\n");
				w.write("Input Line Number: " + lineNumber + "\n\n");
				
//				w.write(e.getMessage() +"in line " +lineNumber+ " of file "+infile+"\n");
//				w.write("line:\t"+line +"\n");
				
				
				
		}
		
		
		
		}
		b.close();
		w.close();
			
	}
	 public static boolean containsElement(String[] array, String target) {
	        for (String element : array) {
	            if (element !=null && target !=null && element.equals(target)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 


	
	 public static void a(String file) throws IOException {
        FileReader fileReaderA = new FileReader(file);
        BufferedReader a = new BufferedReader(fileReaderA);
        
        FileReader fileReaderB = new FileReader("bad_records.txt");
        BufferedReader b = new BufferedReader(fileReaderB);

        // Read movie file names
        String line;
        int movieFileCount = 0;
        while ((line = a.readLine()) != null) {
            movieFileCount++;
        }
       
        a.close();
        fileReaderA.close();

        FileReader fileReaderC = new FileReader(file);
        BufferedReader c = new BufferedReader(fileReaderC);
        String[] moviefiles = new String[movieFileCount];
        int total_records = 0;
        for (int i = 0; i < moviefiles.length; i++) {
            moviefiles[i] = c.readLine();
            total_records += lines(moviefiles[i]);
        }
        c.close();
        fileReaderC.close();

        // Read error lines
        int errorLinesCount = lines("bad_records.txt");
        FileReader fileReaderD = new FileReader("bad_records.txt");
        BufferedReader d = new BufferedReader(fileReaderD);
        String[] errorlines = new String[errorLinesCount];
        int errorIndex = 0;
        while ((line = d.readLine()) != null) {
            errorlines[errorIndex++] = line;
        }
        d.close();
        fileReaderD.close();

        // Writing Genre Filenames to Part2_manifest.txt
        FileWriter fileWriterPart2 = new FileWriter("part2_manifest.txt", true);
        BufferedWriter part2 = new BufferedWriter(fileWriterPart2);
        for (String genre : genres) {
            part2.write(genre.toLowerCase() + ".csv\n");
        }
        part2.close();
        fileWriterPart2.close();
        // PART 2 MANIFEST FILE DONE

        // CREATING EMPTY genre.CSV files
        for (String genre : genres) {
            String genreFileName = genre.toLowerCase() + ".csv";
            FileWriter fileWriterGenre = new FileWriter(genreFileName, true);
            BufferedWriter genreFileWriter = new BufferedWriter(fileWriterGenre);
            genreFileWriter.close();
            fileWriterGenre.close();
        }
       
        // Now must categorize the records into their .CSV files
        for (String inputFile : moviefiles) {
            FileReader fileReaderMovie = new FileReader(inputFile);
            BufferedReader movieFileReader = new BufferedReader(fileReaderMovie);
            while ((line = movieFileReader.readLine()) != null) {
                String[] stringArray = splitStringByCommasIgnoringQuotes(line);
                String movieTitle = stringArray[1];
                String linexxx;
                boolean errorMovie = false;

                FileReader fileReaderE = new FileReader("bad_records.txt");
                BufferedReader e = new BufferedReader(fileReaderE);
                while ((linexxx = e.readLine()) != null) {
                    if (linexxx.contains(movieTitle)) {
                        errorMovie = true;
                    }
                }
                e.close();
                fileReaderE.close();

                if (!line.isEmpty() && !errorMovie && splitStringByCommasIgnoringQuotes(line).length == 10) {
                    //if (movieTitle.equals("Richie Rich")) {
                      //  System.out.println("CUNT" + containsElement(errorlines, movieTitle));
                    
                    for (String genre : genres) {
                        if (line.contains(genre)) {
                            String genreFileName = genre.toLowerCase() + ".csv";
                            FileWriter fileWriterGenre = new FileWriter(genreFileName, true);
                            BufferedWriter genreFileWriter = new BufferedWriter(fileWriterGenre);
                            genreFileWriter.write(line + "\n");
                            genreFileWriter.close();
                            fileWriterGenre.close();
                            break; // Break the loop once the line is written to the correct file
                        }
                    }
                }
            }
            movieFileReader.close();
            fileReaderMovie.close();
        }
    }

	
	public static void categoryFile( String category, String originalFile) {
		try {
		BufferedReader mistakes = new BufferedReader(new FileReader("bad_records.txt"));
		BufferedReader  original= new BufferedReader(new FileReader(originalFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(category+".txt",true));
		String lineA;
		
		while((lineA= original.readLine()) !=null) {
				if(!checkRecord(lineA,mistakes)&& lineA.contains(category))
					bw.write(lineA+"\n");
				}
		mistakes.close();
		original.close();
		bw.close();
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] readFilesToCheck(String fileA) throws IOException {
        BufferedReader readerA = new BufferedReader(new FileReader(fileA));
        String line;
        int count = 0;
        while (readerA.readLine() != null) {
            count++;
        }
        readerA.close();

        String[] filesToCheck = new String[count];
        readerA = new BufferedReader(new FileReader(fileA));
        int index = 0;
        while ((line = readerA.readLine()) != null) {
            filesToCheck[index++] = line;
        }
        readerA.close();
        return filesToCheck;
    }
	
	public static String do_part1(String file)  {
		 
		try(BufferedReader b1 = new BufferedReader(new FileReader(file));) {
		
		// DELETING OLD FILES TO REWRITE
		File badRecordsFile = new File("bad_records.txt");
	    if (badRecordsFile.exists()) {
	        badRecordsFile.delete();
	    }
	    File part2_Manifest = new File("part2_manifest.txt");
	    if (part2_Manifest.exists()) {
	    	part2_Manifest.delete();
	    }
	    
	    for (String genre: genres) {
	    	File genreFile = new File(genre+".csv");
		    if (genreFile.exists()) {
		    	genreFile.delete();
		    }
	    }
	    
		// DELETING OLD FILES TO REWRITE
		
	    
	    
		String linex;
		while((linex= b1.readLine()) !=null) {
			error_1file(linex);	
		}
		b1.close();
		a(file);
		
		
		
		}catch(	  IOException e){
			e.printStackTrace();
			}
		return "part2_manifest.txt";
			
	}

	
	public static String do_part2(String file) {
	    try {
	    	//Initializing serialized files
	    	
	    	
	    	
	    		
    		try {
    	    	BufferedWriter manifestpart3Writer = new BufferedWriter(new FileWriter("part3_manifest.txt"));

    			for (String genre : genres) {
	
		            FileOutputStream fossy = new FileOutputStream(genre+".ser");
		            fossy.close();
		            
		            manifestpart3Writer.write(genre + ".ser\n");
		            
		    		}
	    		
    			manifestpart3Writer.close();

    			}
    		
    		catch (IOException e) {
    			e.printStackTrace();
    		}

	    	
	    	
	        BufferedReader b1 = new BufferedReader(new FileReader(file));
	        String line;
	        
	        BufferedReader badRecordsReader = new BufferedReader(new FileReader("bad_records.txt"));
	        
	        // Read error lines
	        String[] errorlines = new String[lines("bad_records.txt")];
	        int errorIndex = 0;
	        while ((line = badRecordsReader.readLine()) != null) {
	            errorlines[errorIndex++] = line;
	        }
	        badRecordsReader.close();
	        
	        while ((line = b1.readLine()) != null) {
	            BufferedReader b2 = new BufferedReader(new FileReader(line));
	            
	            while ((line = b2.readLine()) != null) {
	            	if (!line.isEmpty() && !containsElement(errorlines, line)) {
	            		String[] l = splitStringByCommasIgnoringQuotes(line);
		                
		               
		                
		                Movie movie = new Movie(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), l[3], l[4],
		                        Double.parseDouble(l[5]), l[6], l[7], l[8], l[9]);
		                
		                ObjectOutputStream bro = new ObjectOutputStream(new FileOutputStream(movie.getGenre() + ".ser"));
		                bro.writeObject(movie);
		                bro.close();
		                
	            		
		                // Write to the 
	            	}
	                
	            }
	            b2.close();
	        }
	        b1.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "part3_manifest.txt";
	}


	public static Movie[][] make_arrays(String part3_manifest) {
        try {
            BufferedReader part3_manifestReader = new BufferedReader(new FileReader(part3_manifest));
            int fileCount = 0;
            String line;
            while ((line = part3_manifestReader.readLine()) != null) {
                fileCount++;
            }
            part3_manifestReader.close();

            Movie[][] allMovies = new Movie[fileCount][];
            int index = 0;

            BufferedReader br = new BufferedReader(new FileReader(part3_manifest));
            while ((line = br.readLine()) != null) {
                FileInputStream fileInput = new FileInputStream(line);
                File serFile = new File(line);

                if (serFile.length() == 0) {
                    allMovies[index++] = null; // Assign null for empty file
                    continue;
                }

                ObjectInputStream movieInput = new ObjectInputStream(fileInput);

                Movie[] movies = new Movie[100]; // Initial capacity, adjust as needed
                int count = 0;

                // Read movies from the binary file
                while (true) {
                    try {
                        Movie movie = (Movie) movieInput.readObject();
                        if (count == movies.length) {
                            // Resize the array if needed
                            Movie[] newArray = new Movie[movies.length * 2];
                            System.arraycopy(movies, 0, newArray, 0, movies.length);
                            movies = newArray;
                        }
                        movies[count++] = movie;
                    } catch (EOFException e) {
                        break; // End of file reached
                    }
                }

                // Trim the array to remove unused slots
                Movie[] trimmedMovies = new Movie[count];
                System.arraycopy(movies, 0, trimmedMovies, 0, count);
                allMovies[index++] = trimmedMovies;
                movieInput.close();
            }
            br.close();
            return allMovies;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
	        
	
	
	
	
	public static void main(String[] args) {
		
		
		String part1_manifest = "part1_manifest.txt";
		String part2_manifest = do_part1(part1_manifest);
		
		
	
		String part3_manifest = do_part2(part2_manifest);
		
		
		for(int i=0;i<72;i++){
			System.out.println(make_arrays(part3_manifest)[3][i]);
		}
								
		
																   
		return;
		
	}
	
	
}