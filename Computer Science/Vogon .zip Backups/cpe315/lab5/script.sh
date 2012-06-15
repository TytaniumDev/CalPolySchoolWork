#!/bin/sh
bin/mips-elf-gcc -S test.c -static -msoft-float -o test.s
bin/mips-elf-gcc test.c -static -msoft-float -o testmips
bin/mips-elf-objdump -D testmips | bin/gensimcode > test.sim
bin/mips-elf-gcc -S shang.c -O0 -static -msoft-float -o shang0.s
bin/mips-elf-gcc shang.c -O0 -static -msoft-float -o shangmips0
bin/mips-elf-objdump -D shangmips0 | bin/gensimcode > shang0.sim
bin/mips-elf-gcc -S shang.c -O3 -static -msoft-float -o shang3.s
bin/mips-elf-gcc shang.c -O3 -static -msoft-float -o shangmips3
bin/mips-elf-objdump -D shangmips3 | bin/gensimcode > shang3.sim
bin/mips-elf-gcc -S shang.c -O1 -static -msoft-float -o shang1.s
bin/mips-elf-gcc shang.c -O1 -static -msoft-float -o shangmips1
bin/mips-elf-objdump -D shangmips1 | bin/gensimcode > shang1.sim
