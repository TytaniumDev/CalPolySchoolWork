	.ORIG 	x3300

Q1    	 .STRINGZ  "\nWhat size is your PC case?\n   1 - Takes up a room\n   2 - Slim/microATX\n   3 - ATX/XL-ATX\n   4 - Mid ATX\n"
Val_A1_1 .FILL    #7
Val_A1_2 .FILL    #2
Val_A1_3 .FILL    #7
Val_A1_4 .FILL    #4

Q2    	 .STRINGZ  "\nHow many video cards do you have?\n   1 - Integrated\n   2 - One\n   3 - Two or Three\n   4 - Four to Nine\n"
Val_A2_1 .FILL    #2
Val_A2_2 .FILL    #4
Val_A2_3 .FILL    #7
Val_A2_4 .FILL    #10

Q3    	 .STRINGZ  "\nHow fast is your CPU?\n   1 - Under 2.0ghz\n   2 - 2.0-2.8ghz\n   3 - 2.8ghz-3.6ghz\n   4 - 3.6ghz+\n"
Val_A3_1 .FILL    #2
Val_A3_2 .FILL    #4
Val_A3_3 .FILL    #7
Val_A3_4 .FILL    #10

Result1	.STRINGZ  "\nYou can get by with default cooling, congrats."
Result2	.STRINGZ  "\nGet a bunch of fans and water cool your CPU."
Result3	.STRINGZ  "\nYou should have multiple water cooling loops."
Result4	.STRINGZ  "\nConsider using Liquid Nitrogen before your CPU explodes!"

	.END