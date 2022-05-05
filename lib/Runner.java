public class Runner {
    
    public static void runApp(){

        Main.database.createConnection();
        Main.database.setUsers();
        Main.database.setMovies();
        
        new MainFrame() ; 


    }



}
