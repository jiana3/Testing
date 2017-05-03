interface Cipher
{
  /**
   * Encrypt a given plaintext with a given key.
   */
  String encrypt(String plainText, int key);

  /**
   * Encrypt a given ciphertext with a given key.
   */
  String decrypt(String cipherText, int key);
}
