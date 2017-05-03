import static org.junit.Assert.*;

import org.junit.Test;


public class CipherBoundaryTests {

	CaesarCipher caesar = new CaesarCipher();
	
//	Test of text
//	Boundary value ` and { of invalid class that text is out of [a-z]
	@Test public void textInvalidatoz(){
	    String resultOne = caesar.shift("`", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "`";
	    String resultTwo = caesar.shift("{", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = "{";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
//	Boundary value @ and [ of invalid class that text is out of [A-Z]
	@Test public void textInvalidAtoZ(){
	    String resultOne = caesar.shift("@", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "@";
	    String resultTwo = caesar.shift("[", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = "[";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
//	Boundary value / and : of invalid class that text is out of [0-9]
	@Test public void textInvalid0to9(){
	    String resultOne = caesar.shift("/", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "/";
	    String resultTwo = caesar.shift(":", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = ":";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
//	Boundary value a and z of valid class that text is in [a-z]
	@Test public void textValidatoz(){
	    String resultOne = caesar.shift("a", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "d";
	    String resultTwo = caesar.shift("z", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = "c";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
//	Boundary value A and Z of valid class that text is in [A-Z]
	@Test public void textValidAtoZ(){
		String resultOne = caesar.shift("A", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "D";
	    String resultTwo = caesar.shift("Z", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = "C";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
//	Boundary value 0 and 9 of valid class that text is in [0-9]
	@Test public void textValid0to9(){
		String resultOne = caesar.shift("0", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetOne = "3";
	    String resultTwo = caesar.shift("9", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcetTwo = "2";
	    assertTrue(resultOne.equals(expcetOne)&&resultTwo.equals(expcetTwo));
	  }
	
//	Test of offset
//	Boundary value -1 of invalid class that offset is less than 0
	@Test public void offsetInvalidOne(){
	    String result = caesar.shift("Testing", -1, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Uftujoh";
	    assertTrue(!result.equals(expcet));
	}
//	Boundary value 0 of valid class that offset is greater than or equals to 0
	@Test public void offsetvalid(){
	    String result = caesar.shift("Testing", 0, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Testing";
	    assertTrue(result.equals(expcet));
	}

//	Test of eType
//	Invalid class that eType is not in [ENCRYPT, DECRYPT] is untestable
//	Boundary value DECRYPT of valid class that eType is from [ENCRYPT, DECRYPT]
	@Test public void eTypeValidOne(){
	    String result = caesar.shift("Juhdw", 3, CaesarCipher.EncryptionType.DECRYPT);
	    String expcet = "Great";
	    assertTrue(result.equals(expcet));
	}
//	Boundary value ENCRYPT of valid class that eType is from [ENCRYPT, DECRYPT]
	@Test public void eTypeValidTwo(){
	    String result = caesar.shift("Great", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Juhdw";
	    assertTrue(result.equals(expcet));
	}

}
