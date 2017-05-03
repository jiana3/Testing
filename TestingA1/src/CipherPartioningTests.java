import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CipherPartioningTests {

	CaesarCipher caesar = new CaesarCipher();
//    caesar.shift("-", 3, CaesarCipher.EncryptionType.ENCRYPT);

//	Test of text
//	Invalid class that text is not in [a-zA-Z0-9]
	@Test public void textInvalidTest(){
	    String result = caesar.shift("-", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "-";
	    assertTrue(result.equals(expcet));
	  }
//	Valid class that text is in [a-zA-Z0-9]
	@Test public void textValidTest(){
	    String result = caesar.shift("Testing", 3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Whvwlqj";
	    assertTrue(result.equals(expcet));
	  }
	
//	Test of offset
//	Invalid class that offset is less than 0
	@Test public void offsetInvalidSmall(){
	    String result = caesar.shift("Testing", -3, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Whvwlqj";
	    assertTrue(!result.equals(expcet));
	}

//	Valid class that offset is greater than or equals to 0
	@Test public void offsetValidTest(){
	    String result = caesar.shift("Testing", 5, CaesarCipher.EncryptionType.ENCRYPT);
	    String expcet = "Yjxynsl";
	    assertTrue(result.equals(expcet));
	}
	
//	Test of eType
//	Invalid class that eType is not in [ENCRYPT, DECRYPT] is untestable
//	Valid class that eType is in [ENCRYPT, DECRYPT]
	@Test public void eTypeValidTest(){
	    String result = caesar.shift("Juhdw", 3, CaesarCipher.EncryptionType.DECRYPT);
	    String expcet = "Great";
	    assertTrue(result.equals(expcet));
	}	
}
