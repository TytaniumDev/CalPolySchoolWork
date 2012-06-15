/**
 * @file
 * <pre> CPE 357 Fall 2008
 * -------------------
 *
 * Functions for transcribing morse code.
 *
 * Last Modified: Sat Feb  7 19:16:49 PST 2009</pre>
 * @author Kevin O'Gorman
 */

#include "morse.h"

/* Not included:
Á .--.- A with accent
Ä  .-.- A with two dots
É  ..-.. E with accent
Ñ  --.-- N with tilde
Ö  ---. O with two dots
Ü  ..-- U with two dots
*/

static char * letters[] = {".-", "-...", "-.-.", "-..", ".",
    "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
    "...-", ".--", "-..-", "-.--", "--.."};
static char * digits[] = {"-----", ".----", "..---", "...--", "....-", ".....",
  "-....", "--...", "---..", "----."};
static char * morse[] = { "A.-", "B-...", "C-.-.", "D-..", "E.",
  "F..-.", "G--.", "H....", "I..", "J.---", "K-.-", "L.-..", "M--",
  "N-.", "O---", "P.--.", "Q--.-", "R.-.", "S...", "T-", "U..-",
  "V...-", "W.--", "X-..-", "Y-.--", "Z--..", "1.----", "2..---",
  "3...--", "4....-", "5.....", "6-....", "7--...", "8---..", "9----.",
  "0-----", ",--..--", "..-.-.-", "?..--..", ";-.-.-", ":---...",
  "/-..-.", "--....-", "'.----.", ")-.--.-", "(-.--.-", "_..--.-", NULL};

/**
 * Turn a character into the equivalent morse code sequence.
 * Dits (short sounds) are represented by ".", and dahs (long
 * sounds) are represented by "-".
 * @param c the character to encode.
 * @return a pointer to the morse code string for the character,
 * with no terminating whitespace (just the usual NUL byte).
 * Unknown characters are returned as "?".
 */
char *toMorse(char c) {
  if (islower(c)) {
    return letters[c - 'a'];
  } else if (isupper(c)) {
    return letters[c - 'A'];
  } else if (isdigit(c)) {
    return digits[c - '0'];
  } else {
    switch(c) {
    case ',':
      return "--..--";
    case '.':
      return ".-.-.-";
    case '?':
      return "..--..";
    case ';':
      return "-.-.-";
    case ':':
      return "---...";
    case '/':
      return "-..-.";
    case '-':
      return "-....-";
    case '\'':
      return ".----.";
    case '(':
    case ')':
      return "-.--.-";
    case '_':
      return "..--.-";
    default:
      return "?";
    }
  }
}

/**
 * Turn a morse code string into a character.
 * @param dits the code string, which must have no surrounding whitespace.
 * @return the corresponding character, or "*" if this is not a legal code
 * string.
 */
char toChar(char *dits) {
  char **ptr = morse;
  while (*ptr && strcmp(dits, (*ptr) + 1) ) {
    ptr++;
  }
  if (ptr && *ptr) {
    return **ptr;
  } else {
    return '*';
  }
}

/* vim: set et ai sts=2 sw=2: */
