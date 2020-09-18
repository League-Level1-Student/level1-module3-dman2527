package _05_netflix;

public class NetflixRunner {
public static void main(String[] args) {
	Movie newton = new Movie("newton", 5);
	Movie coco = new Movie("coco", 4);
	Movie luca = new Movie("luca", 3);
	Movie cherry = new Movie("cherry", 2);
	Movie romeo = new Movie("romeo", 1);
	System.out.println(newton.getTicketPrice());
	NetflixQueue netflixqueue = new NetflixQueue();
	netflixqueue.addMovie(newton);
	netflixqueue.addMovie(coco);
	netflixqueue.addMovie(luca);
	netflixqueue.addMovie(cherry);
	netflixqueue.addMovie(romeo);
	netflixqueue.printMovies();
	netflixqueue.sortMoviesByRating();
	System.out.println("The first best movie is, "+netflixqueue.getBestMovie());
	System.out.println("The second best movie is, " +netflixqueue.getMovie(1));
}
}
