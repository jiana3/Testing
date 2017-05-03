public class CaesarCipher implements Cipher
{
  public enum EncryptionType {ENCRYPT, DECRYPT};

  private static final int CHAR_LENGTH = 26;
  private static final int DIGIT_LENGTH = 10;

  public String encrypt(String plainText, int offset)
  {
    return shift(plainText, offset, EncryptionType.ENCRYPT);
  }
 
  public String decrypt(String cipherText, int offset)
  {
    return shift(cipherText, offset, EncryptionType.DECRYPT);
  }

  /**
   * Shift each character in text 'offset' letters forward (if eType =
   * ENCRYPT) or backward (if eType = DECRYPT).
   */
  public String shift(String text, int offset, EncryptionType eType)
  {
    //Calculte the offset required for encrypting or decrypting
    int charOffset = offset;
    int digitOffset = offset;
    if (eType == EncryptionType.DECRYPT) {
      charOffset = CHAR_LENGTH - offset;
      digitOffset = DIGIT_LENGTH - offset;
    }
    return shift(text, charOffset, digitOffset);
  } 

  private static String shift(String enc, int charOffset, int digitOffset)
  {
    StringBuilder shifted = new StringBuilder();

    for (char c : enc.toCharArray()) {

      //for each char (digit), move along charOffset (digitOffset),
      //wrapping around if the end of the range is reached
      if (Character.isLetter(c)) {
        if (c >= 'A' && c <= 'Z') {
	  shifted.append((char) ('A' + (c - 'A' + charOffset) % CHAR_LENGTH));
        }
        else {
          shifted.append((char) ('a' + (c - 'a' + charOffset) % CHAR_LENGTH));
        }
      } 
      else if (c >= '0' && c <= '9') {
	shifted.append((char) ('0' + (c - '0' + digitOffset) % DIGIT_LENGTH));
      }
      //if the character is not an alpha-num character
      else {
	shifted.append(c);
      }
    }
    return shifted.toString();
  }
}
