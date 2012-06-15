/**
 * @file
 * <pre> CPE 357 Winter 2009
 * -------------------
 *
 * Program to turn 1s and 0s back into morse code.
 * The program ignores all inputs other than '0', '1' and end-of-file.
 *
 * Last Modified: Wed Oct 28 13:00:11 PDT 2009</pre>
 * @author Kevin O'Gorman
 */

#include "dedit.h"

/** The main thing.
 * @param argc the number of tokens on the input line.
 * @param argv an array of tokens.
 * @return 0 on success, 1-255 on failure
 */
int
main(int argc, char *argv[])
{
  struct termios origattr, newattr;
  int linelen;
  int ch;
  ditstate_e state = NEW;
  int done = 0;
  FILE * infile = stdin;
  int infd;

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

  linelen = 0;
  while (!done && (ch = fgetc(infile)) != EOF) {
    if (ch != '0' && ch != '1') {
      continue;
    }
    switch(state) {
    case BEGIN:
      /* Ignore leading quiet. */
      if (ch == '1') {
        state = GOT1;
      }
      break;
    case NEW:
      if (ch == '0') {
        state = GOT0;
      } else {
        state = GOT1;
      }
      break;
    case GOT1:
      if (ch == '0') {
        fputc('.', stdout);
        linelen++;
        state = NEW;
      } else {
        state = GOT11;
      }
      break;
    case GOT11:
      if (ch == '0') {
        /* This otherwise illegal sequence is used in-band to indicate */
        /* end-of-file. */
        done = 1;
      } else {
        state = GOT111;
      }
      break;
    case GOT111:
      if (ch == '0') {
        fputc('-', stdout);
        linelen++;
        state = NEW;
      } else {
        fprintf(stderr, "Illegal sequence: too many 1's.\n");
        exit(EXIT_FAILURE);
      }
      break;
    case GOT0:
      if (ch == '0') {
        state = GOT00;
      } else {
        state = GOT1;
      }
      break;
    case GOT00:
      if (ch == '0') {
        if (linelen > 80) {
          fputc('\n', stdout);
          linelen = 0;
        } else {
          fputc(' ', stdout);
          linelen++;
        }
        state = NEW;
      } else {
        state = GOT1;
      }
      break;
    default:
      fprintf(stderr, "Unknown state code: %d\n", state);
      exit(EXIT_FAILURE);
    }
  }
  
  if (isatty(infd)) {
    /* restore original input attributes. */
    if (tcsetattr(infd, TCSANOW, &origattr) != 0) {
      perror("tcsetattr");
      exit(EXIT_FAILURE);
    }
  }
  fputc('\n', stdout);
  return EXIT_SUCCESS;
}

/* vim: set et ai sts=2 sw=2: */
