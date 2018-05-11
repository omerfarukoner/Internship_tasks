/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckUniqueString;

/**
 *
 * @author Omerfaruk
 */
public class Test {


    public static void main(String[] args) {
   
        String test_s="abcfts";
        String test_s2="ab-c-y?";
        
        String test_1 = "OmerFarukkk";
        String test_2 = "Oner";
        UniqueString uniq_str = new UniqueString();
        
        uniq_str.uniqueCharacters(test_1);
        uniq_str.uniqueCharacters(test_2);
       
        uniq_str.uniqueCharacters(test_s);
        uniq_str.uniqueCharacters(test_s2);
        
        

    }

}
