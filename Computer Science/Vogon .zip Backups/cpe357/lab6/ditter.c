/**
 * @file
 * <pre> CPE 357 Winter 2009
 * -------------------
 *
 * Functions for transcribing dots and dashes into units
 * of sound and silence.
 *
 * Last Modified: Wed Oct 28 12:59:14 PDT 2009</pre>
 * @author Kevin O'Gorman
 */

#include "ditter.h"

/** The main thing.
 * @param argc the number of tokens on the input line.
 * @param argv an array of tokens.
 * @return 0 on success, 1-255 on failure
 */
int
main(int argc, char *argv[])
{
  struct termios origattr, newattr;
  int ch;
  FILE *infile = stdin;
  int infd = STDIN_FILENO;

  if (argc > 2) {
    fprintf(stderr, "Usage: %s [filepath]\n", argv[0]);
    exit(EXIT_FAILURE);
  }
  if (argc == 2) {
    if (!(infile = fopen(argv[1], "r"))) {
      perror(argv[1]);
      exit(EXIT_FAILURE);
    }
    infd = fileno(infile);
  }

  /* Make interactive terminals VERY interactive */
  if (isatty(infd)) {
    /* Get original attributes of input */
    if (tcgetattr(infd, &origattr) != 0) {  
      perror("tcgetattr");
      exit(EXIT_FAILURE);
    }
    newattr = origattr;
    newattr.c_lflag &= ~ (ICANON);    /* remove canonic processing */
    newattr.c_cc[VMIN] = 1;           /* go to reading one byte at a time */
    newattr.c_cc[VTIME] = 0;          /* do not wait for any more */
    if (tcsetattr(infd, TCSANOW, &newattr) != 0) {  /* set new attributes */
      perror("tcsetattr");
      exit(EXIT_FAILURE);
    }
  }
  setbuf(stdout, 0);  /* set non-buffered output */

  while ((ch = fgetc(infile)) != EOF) {
    if (ch == '\004') {
      break;
    } else if (ch == '\n') {
      fprintf(stdout, "000\n");
    } else if (isspace(ch)) {
      fprintf(stdout, "000");
    } else if (ch == '.') {
      fprintf(stdout, "10");
    } else if (ch == '-') {
      fprintf(stdout, "1110");
    } else {
      fprintf(stdout, "*%c*", ch);
    }
  }
  
  if (isatty(infd)) {
    if (tcsetattr(infd, TCSANOW, &origattr) != 0) {
      perror("tcsetattr");
      exit(EXIT_FAILURE);
    }
  }
  fprintf(stdout, "\n");
  return EXIT_SUCCESS;
}

/* vim: set et ai sts=2 sw=2: */
