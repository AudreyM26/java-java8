package java8.ex05;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.function.Consumer;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
    /*Consumer<Person> changePasswordToSecret = new Consumer<Person>(){

		@Override
		public void accept(Person t) {
			// TODO Auto-generated method stub
			t.setPassword("secret");
		}
    	
    };*/
	
	 Consumer<Person> changePasswordToSecret = t -> t.setPassword("secret");
    
    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
    /*Consumer<Person> verifyAge = new Consumer<Person>(){

		@Override
		public void accept(Person t) {
			// TODO Auto-generated method stub
			assertTrue(t.getAge()>4);
		}
    	
    };*/
	
	Consumer<Person> verifyAge = t -> assertTrue(t.getAge()>4);
	
    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
    /*Consumer<Person> verifyPassword = new Consumer<Person>(){

		@Override
		public void accept(Person t) {
			// TODO Auto-generated method stub
			assertEquals(t.getPassword(),"secret");
		}
    	
    };*/
    //end::functions[]
    
    Consumer<Person> verifyPassword = t-> assertEquals(t.getPassword(),"secret");

    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);
        
        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        /*for(Person p : personList) {
            verifyAge.accept(p);
            verifyPassword.accept(p);
        }*/
        
        personList.forEach(verifyAge.andThen(verifyPassword));
    }
}
