int main(int argc, char *argv[])
{
	int n;
	for(n = 1; n < argc; n++)
	{
		execvp(argv[n], &(argv[n]));
	}
	return 0;
}
