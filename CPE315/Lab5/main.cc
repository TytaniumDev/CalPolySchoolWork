#include "mipsim.hpp"
#include "unistd.h"

Memory<Data8,Data32> imem(0x400000);
Memory<Data8,Data32> dmem(0xffff0000);
Memory<Data32,Data32> rf(32, Data32(0));
Register pc;
Options opts;

int main(int argc, char ** argv) {
  int c;
  string filename;
  while ((c = getopt(argc, argv, "pdiwsc:f:")) != -1) {
    switch(c) {
    case 'p':
      opts.program = true;
      break;
    case 'd':
      opts.dump = true;
      break;
    case 'i':
      opts.instrs = true;
      break;
    case 'w':
      opts.writes = true;
      break;
    case 's':
      opts.stats = true;
      break;
    case 'c':
      caches = Caches(atoi(optarg));
      break;
    case 'f':
      filename = optarg;
      break;
    }
  }

  if (filename == "") {
    cerr << "ERROR: no source file specified; "
         << "run this program with -f filename" << endl;
    exit(1);
  }

  op_init();

  parse(filename.c_str());

  if (opts.program) {
    cout << "Instructions:" << endl;
    imem.dump(INSTRUCTIONS);
  }

  cout << "Starting at PC " << hex << pc << endl;

  while(imem.inRange(pc)) {
    if (opts.instrs) {
      cout << "Executing: " << pc << ": ";
      Data32::printI(imem[pc]);
    }
    execute();
  }

  if (opts.dump) {
    cout << "DATA:" << endl;
    dmem.dump(DATA);
    cout << "RF:" << endl;
    rf.dump(DATA);
  }

  if (opts.stats) {
    stats.print();
    caches.printStats();
  }

  return 0;
}
