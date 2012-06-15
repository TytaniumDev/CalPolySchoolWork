/**
 * @file
 * <pre> CPE 357 Winter 2009
 * -------------------
 *
 * Program to decode a morse-code message.
 *
 * Last Modified: Wed Oct 28 12:58:40 PDT 2009</pre>
 * @author Kevin O'Gorman
 */

#include "demorse.h"
#include "morse.h"
#include <errno.h>

/** The main thing.
 * @param argc the number of tokens on the input line.
 * @param argv an array of tokens.
 * @return 0 on success, 1-255 on failure
 */
int
main(int argc, char *argv[])
{
  struct termios origattr, newattr;
  char token[TOKENLEN + 1];
  int len;
  int addlen = 0;
  int linelen;
  int r;
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

  linelen = 0;
  while (1) {
    token[0] = '\0';
    errno = 0;
    r = fscanf(infile, "%9s", token);
    if (r < 0 && errno == 0 && !feof(infile)) {
      r = 0;
    }
    if (r < 0) {
      if (feof(infile)) {
        break;
      } else {
        perror("scanf");
        break;
      }
    }
    if (strchr(token, '\004')) {
      break;
    }

    len = strlen(token);
    linelen += len*addlen + 2;
    if (len > 6) {
      printf(" * ");
    } else if (strspn(token, ".-") != len) {
      printf(" * ");
    } else {
      fputc(toChar(token), stdout);
      if ((ch = fgetc(infile)) == EOF) {
        break;
      } else if (ch != ' ' && ch != '\n') {
        fprintf(stderr, "Illegal morse sequence -- no space terminator\n");
        exit(EXIT_FAILURE);
      }
    }
    while ((ch = fgetc(infile)) != EOF && isspace(ch)) {
      if (linelen > 80) {
        fputc('\n', stdout);
        linelen = 0;
      } else {
        fputc(ch, stdout);
      }
      linelen++;
      if (ch == '\n') {
        linelen = 0;
      }
      if ((ch = fgetc(infile)) == EOF || !isspace(ch)) {
        break;
      } 
    }
    if (ch == '\004') {
      break;
    }
    ungetc(ch, infile);
  }
  
  if (isatty(infd)) {
    if (tcsetattr(infd, TCSANOW, &origattr) != 0) {
      perror("tcsetattr");
      exit(EXIT_FAILURE);
    }
  }
  fputc('\n', stdout);
  return EXIT_SUCCESS;
}

/* vim: set et ai sts=2 sw=2: */
